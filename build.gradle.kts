plugins {
    kotlin("multiplatform") version Versions.kotlinCompiler apply false
    kotlin("plugin.serialization") version Versions.kotlinCompiler apply false
}

group = "com.elouyi"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}
