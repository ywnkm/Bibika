
plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

sourceSets {
    main {
        java {
            srcDirs("src/main/external")
        }
    }
}

kotlin {
    explicitApi()
}

dependencies {
    api(kotlin("reflect"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinxCoroutines}")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}")

    api("io.ktor:ktor-client-core:${Versions.ktor}")
    api("io.ktor:ktor-client-cio:${Versions.ktor}")
    api("io.ktor:ktor-client-websockets:${Versions.ktor}")
    api("io.ktor:ktor-client-encoding:${Versions.ktor}")
    api("io.ktor:ktor-client-content-negotiation:${Versions.ktor}")
    api("io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}")
    api("io.ktor:ktor-serialization-kotlinx-protobuf:${Versions.ktor}")

    api("io.github.microutils:kotlin-logging:${Versions.kotlinLogging}")

    implementation("io.insert-koin:koin-core:${Versions.koin}")

    implementation("ch.qos.logback:logback-classic:${Versions.logback}")
    implementation("org.brotli:dec:${Versions.brotli}")

    testImplementation(kotlin("test"))
    testImplementation("io.insert-koin:koin-test:${Versions.koin}")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {

}
