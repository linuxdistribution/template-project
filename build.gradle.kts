plugins {
    id("java")
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

