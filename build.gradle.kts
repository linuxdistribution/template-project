plugins {
    id("java")
    id("net.kyori.indra.license-header") version("3.1.3")
}

group = property("project_group") as String
version = property("project_version") as String
description = property("project_description") as String

base {
    archivesName = property("project_name") as String
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // Add your dependencies here
}

java {
    withSourcesJar()
    withJavadocJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.compileJava {
    dependsOn(tasks.licenseFormat)
}

