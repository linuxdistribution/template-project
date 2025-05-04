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

tasks {
    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE

        manifest {
            attributes(
                "Main-Class" to "com.linuxdistribution.templateproject",
            )
        }

        from("LICENSE") {
            rename { "${it}_${project.name}" }
        }
    }

    license {
        skipExistingHeaders = true
    }

    compileJava {
        dependsOn(licenseFormat)
    }
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    defaultCharacterEncoding = "UTF-8"
}

