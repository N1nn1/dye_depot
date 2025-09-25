plugins {
    id("net.minecraftforge.gradle") version "[6.0,6.2)"
    id("org.spongepowered.mixin") version "0.7-SNAPSHOT"
    id("com.diffplug.spotless") version "7.0.4"
    `maven-publish`
}

val minecraft_version: String by extra
val forge_version: String by extra
val mod_id: String by extra
val mod_name: String by extra
val mod_version: String by extra
val maven_group: String by extra
val repository: String by extra
val mixin_version: String by extra
val mixin_extras_version: String by extra

base {
    archivesName = mod_id
}

repositories {
    maven {
        url = uri("https://maven.blamejared.com/")
        content {
            includeGroup("mezz.jei")
        }
    }

    maven {
        url = uri("https://api.modrinth.com/maven")
        content {
            includeGroup("maven.modrinth")
        }
    }
}

val datagenOutput = file("src/generated/resources").absolutePath
sourceSets.main {
    resources.srcDir(datagenOutput)
}

minecraft {
    mappings("official", minecraft_version)

    accessTransformer(file("src/main/resources/META-INF/accesstransformer.cfg"))

    runs {
        create("client")
        create("server") {
            workingDirectory("run/server")
        }
        create("data") {
            val existingMods = listOf("supplementaries", "suppsquared")
            args(
                listOf(
                    "--mod",
                    mod_id,
                    "--all",
                    "--output",
                    datagenOutput,
                    "--existing",
                    file("src/main/resources/"),
                ) + existingMods.flatMap {
                    listOf("--existing-mod", it)
                })
        }
    }
}

mixin {
    config("${mod_id}.mixins.json")
}

fun DependencyHandler.modImplementation(notation: String) = implementation(fg.deobf(notation))
fun DependencyHandler.modCompileOnly(notation: String) = compileOnly(fg.deobf(notation))
fun DependencyHandler.modRuntimeOnly(notation: String) = runtimeOnly(fg.deobf(notation))

dependencies {
    minecraft("net.minecraftforge:forge:$minecraft_version-$forge_version")
    annotationProcessor("org.spongepowered:mixin:$mixin_version:processor")

    compileOnly(annotationProcessor("io.github.llamalad7:mixinextras-common:$mixin_extras_version")!!)
    implementation(jarJar("io.github.llamalad7:mixinextras-forge:$mixin_extras_version") {
        version {
            strictly("[$mixin_extras_version,)")
            prefer(mixin_extras_version)
        }
    })

    val jei_version: String by project.extra
    modCompileOnly("mezz.jei:jei-$minecraft_version-common-api:$jei_version")
    modCompileOnly("mezz.jei:jei-$minecraft_version-forge-api:$jei_version")
    modRuntimeOnly("mezz.jei:jei-$minecraft_version-forge:$jei_version")

    val moonlight_lib_version: String by project.extra
    val supplementaries_version: String by project.extra
    val supplementaries_squared_version: String by project.extra
    modImplementation("maven.modrinth:moonlight:$moonlight_lib_version")
    modImplementation("maven.modrinth:supplementaries:$supplementaries_version")
    modImplementation("maven.modrinth:supplementaries-squared:$supplementaries_squared_version")
}

tasks.withType<ProcessResources> {
    inputs.property("version", mod_version)
    filesMatching(
        listOf(
            "META-INF/mods.toml",
            "${mod_id}*.mixins.json",
        )
    ) {
        expand(
            mapOf(
                "mod_version" to mod_version,
                "mod_name" to mod_name,
                "mod_id" to mod_id,
                "repository" to repository,
            )
        )
    }
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(17)
    withSourcesJar()
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${mod_id}" }
    }
}

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = maven_group
            artifactId = mod_id
            version = "${minecraft_version}-${mod_version}"

            from(components["java"])

            // forge does not handle transitive dependencies well
            pom.withXml {
                val node = asNode()
                val list = node.get("dependencies") as groovy.util.NodeList
                list.forEach { node.remove(it as groovy.util.Node) }
            }
        }
    }

    repositories {
        mavenLocal()
    }
}

spotless {
    java {
        importOrder()
        removeUnusedImports()
    }

    kotlinGradle {
        ktlint()
        suppressLintsFor { shortCode = "standard:property-naming" }
    }

    json {
        target("src/main/**/*.json")
        gson().indentWithSpaces(2)
    }
}