plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.6.2"
    id("com.google.cloud.tools.jib") version "2.8.0"
}

version = "0.1"
group = "com.bouceka.registration"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
	kapt("io.micronaut.data:micronaut-data-processor")
	kapt("io.micronaut:micronaut-http-validation")
	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut:micronaut-jackson-databind")
	implementation("io.micronaut.data:micronaut-data-jdbc")
	implementation("io.micronaut.flyway:micronaut-flyway")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
	implementation("io.micronaut.nats:micronaut-nats")
	implementation("io.micronaut.sql:micronaut-jdbc-hikari")
	implementation("jakarta.annotation:jakarta.annotation-api")
	implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
	implementation("io.micronaut:micronaut-validation")
	implementation("org.postgresql:postgresql:42.2.26.jre7")
	runtimeOnly("ch.qos.logback:logback-classic")
	runtimeOnly("com.h2database:h2")

	runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("com.bouceka.registration.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    jib {
        to {
            image = "gcr.io/myapp/jib-image"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.bouceka.registration.*")
    }
}



