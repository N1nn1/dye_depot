plugins {
    id("com.possible-triangle.forge")
}

forge {
    accessTransformer()
    enableMixins()

    dataGen {
        splitSourceSet()

        existing("supplementaries")
        existing("suppsquared")
    }
}

repositories {
    maven {
        url = uri("https://maven.blamejared.com/")
        content {
            includeGroup("mezz.jei")
        }
    }
}

dependencies {
    modCompileOnly(libs.jei.common.api)
    modCompileOnly(libs.jei.api)
    modRuntimeOnly(libs.jei)

    modImplementation(pack.modrinth.moonlight)
    modImplementation(pack.modrinth.supplementaries)
    modImplementation(pack.modrinth.supplementaries.squared)
}

val (version, type) = mod.version.get().split("-")

mod.version = version

upload.maven {
    name = "${mod.id.get()}-$type"
    artifactVersion = "${mod.minecraftVersion.get()}-${mod.version.get()}"

    nexus()
}

enableSpotless()
