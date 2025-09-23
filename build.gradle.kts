plugins {
    id("fabric-loom") version "1.11-SNAPSHOT"
    `maven-publish`
}

val minecraft_version: String by extra
val fabric_api_version: String by extra
val fabric_loader_version: String by extra
val mod_id: String by extra
val mod_name: String by extra
val mod_version: String by extra
val maven_group: String by extra
val repository: String by extra

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
    maven {
        url = uri("https://mvn.devos.one/releases/")
        content {
            includeGroup("io.github.fabricators_of_create.Porting-Lib")
        }
    }
}

val datagenOutput = file("src/generated/resources").absolutePath
sourceSets.main {
    resources.srcDir(datagenOutput)
}

loom {
    accessWidenerPath = file("src/main/resources/$mod_id.accesswidener")

    runs {
        create("data") {
            client()
            property("fabric-api.datagen")
            property("fabric-api.datagen.output-dir=${datagenOutput}")
            property("fabric-api.datagen.modid=${mod_id}")
            property("porting_lib.datagen.existing_resources=${file("src/main/resources").absolutePath}")
            val existingMods = listOf("supplementaries", "suppsquared")
            property("porting_lib.datagen.existing-mod=${existingMods.joinToString(";")}")
        }
    }
}


dependencies {
    minecraft("com.mojang:minecraft:$minecraft_version")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:$fabric_loader_version")

    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabric_api_version")

    val jei_version: String by project.extra
    modCompileOnly("mezz.jei:jei-$minecraft_version-common-api:$jei_version")
    modCompileOnly("mezz.jei:jei-$minecraft_version-fabric-api:$jei_version")
    modRuntimeOnly("mezz.jei:jei-$minecraft_version-fabric:$jei_version")

    val moonlight_lib_version: String by project.extra
    val supplementaries_version: String by project.extra
    val supplementaries_squared_version: String by project.extra
    modImplementation("maven.modrinth:moonlight:$moonlight_lib_version")
    modImplementation("maven.modrinth:supplementaries:$supplementaries_version")
    modImplementation("maven.modrinth:supplementaries-squared:$supplementaries_squared_version")

    // for data generation
    val porting_lib_version: String by project.extra
    modImplementation("io.github.fabricators_of_create.Porting-Lib:model_generators:$porting_lib_version")
}

tasks.withType<ProcessResources> {
    inputs.property("version", mod_version)
    filesMatching(
        listOf(
            "fabric.mod.json",
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
        }
    }

    repositories {
        mavenLocal()
    }
}