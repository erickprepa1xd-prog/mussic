plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.plugin.serialization)
}

group = "com"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

dependencies {
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.partial.content)
    implementation(libs.ktor.server.resources)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    // EXPOSED
implementation("org.jetbrains.exposed:exposed-core:0.45.0")
implementation("org.jetbrains.exposed:exposed-dao:0.45.0")
implementation("org.jetbrains.exposed:exposed-jdbc:0.45.0")
    implementation("com.zaxxer:HikariCP:5.1.0")
implementation("org.jetbrains.exposed:exposed-java-time:0.43.0")

// DRIVER BD (elige uno)
implementation("org.postgresql:postgresql:42.7.2") // PostgreSQL
// implementation("mysql:mysql-connector-java:8.0.33") // MySQL

}
