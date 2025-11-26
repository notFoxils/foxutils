plugins {
    id("java-library")
    id("maven-publish")
    id("com.gradleup.shadow") version("9.2.2")
}

group = "me.foxils.foxutils"
version = "2.0.0-SNAPSHOT"

dependencies {
    compileOnlyApi(libs.spigot.api)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }

    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

tasks.shadowJar {
    minimize()
}
