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
}

val datagenOutput = "src/generated/resources"
sourceSets.main {
    resources.srcDir(datagenOutput)
}

loom {
    accessWidenerPath = file("src/main/resources/dye_depot.accesswidener")

    runs {
        create("data") {
            client()
            property("fabric-api.datagen")
            property("fabric-api.datagen.output-dir=${datagenOutput}")
            property("fabric-api.datagen.modid=${mod_id}")
        }
    }
}


dependencies {
    minecraft("com.mojang:minecraft:${minecraft_version}")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:${fabric_loader_version}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${fabric_api_version}")

    val jei_version: String by project.extra
    modCompileOnly("mezz.jei:jei-${minecraft_version}-common-api:${jei_version}")
    modCompileOnly("mezz.jei:jei-${minecraft_version}-fabric-api:${jei_version}")
    modRuntimeOnly("mezz.jei:jei-${minecraft_version}-fabric:${jei_version}")
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