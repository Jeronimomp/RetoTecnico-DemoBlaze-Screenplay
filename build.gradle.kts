plugins {
    id("java")
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.2.11"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val serenityCoreVersion = "4.1.20"
val cucumberVersion = "7.15.0"
val junitVersion = "5.10.0"

dependencies {

    // ─── Serenity BDD Core ───────────────────────────────────────────────────
    implementation("net.serenity-bdd:serenity-core:$serenityCoreVersion")

    // ─── Serenity Screenplay (patrón de diseño) ──────────────────────────────
   implementation("net.serenity-bdd:serenity-screenplay:$serenityCoreVersion")
    implementation("net.serenity-bdd:serenity-screenplay-webdriver:$serenityCoreVersion")

    // ─── Serenity + Cucumber 7 ───────────────────────────────────────────────
   implementation("net.serenity-bdd:serenity-cucumber:$serenityCoreVersion")

    // ─── Cucumber Java ───────────────────────────────────────────────────────
    implementation("io.cucumber:cucumber-java:$cucumberVersion")
    implementation("io.cucumber:cucumber-core:$cucumberVersion")

    // ─── JUnit (plataforma de ejecución) ─────────────────────────────────────
    implementation(platform("org.junit:junit-bom:$junitVersion"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("org.junit.vintage:junit-vintage-engine:$junitVersion")

    // ─── WebDriver Manager (descarga automática de drivers) ──────────────────
    implementation("io.github.bonigarcia:webdrivermanager:5.7.0")

    // ─── AssertJ (aserciones fluidas) ────────────────────────────────────────
    implementation("org.assertj:assertj-core:3.25.1")

    // ─── Lombok (reduce boilerplate en modelos) ───────────────────────────────
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // ─── Logger ──────────────────────────────────────────────────────────────
    testImplementation("org.slf4j:slf4j-simple:2.0.9")

    // Source: https://mvnrepository.com/artifact/org.projectlombok/lombok
    implementation("org.projectlombok:lombok:1.18.42")

    // Source: https://mvnrepository.com/artifact/org.hamcrest/hamcrest
    testImplementation("org.hamcrest:hamcrest:3.0")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.publish.quiet", "true")
}

// ─── Tarea para generar reporte Serenity tras los tests ──────────────────────
tasks["test"].finalizedBy("aggregate")