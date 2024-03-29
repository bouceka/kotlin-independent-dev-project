plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.6.3"
    id("com.google.cloud.tools.jib") version "2.8.0"
    id("io.micronaut.test-resources") version "3.6.3"
}

version = "0.1"
group = "com.bouceka.auth"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
	kapt("io.micronaut.security:micronaut-security-annotations")
	kapt("io.micronaut.data:micronaut-data-processor")
	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut.flyway:micronaut-flyway")
	implementation("io.micronaut:micronaut-jackson-databind")
	implementation("org.springframework.security:spring-security-crypto:5.7.3")
    implementation("io.micronaut:micronaut-management")
	implementation("io.micronaut.data:micronaut-data-jdbc")
	implementation("io.micronaut.reactor:micronaut-reactor")
	implementation("io.micronaut.reactor:micronaut-reactor-http-client")
	implementation("io.micronaut.security:micronaut-security-jwt")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.kubernetes:micronaut-kubernetes-client")
    implementation("io.micronaut.kubernetes:micronaut-kubernetes-discovery-client")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
    implementation("io.micronaut:micronaut-validation")
	runtimeOnly("com.h2database:h2")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("com.bouceka.auth.ApplicationKt")
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
        annotations("com.bouceka.auth.*")
    }
    testResources {
        additionalModules.add("jdbc-postgresql")
    }
}



