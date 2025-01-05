plugins {
    java
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.flywaydb.flyway") version "9.22.3"
}

group = "com.seongha"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springModulithVersion"] = "1.3.1"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.springframework.modulith:spring-modulith-starter-jpa")

    // 추가 Library
    implementation("io.hypersistence:hypersistence-utils-hibernate-63:3.9.0")
    implementation("org.mapstruct:mapstruct:1.6.3")
    implementation("io.swagger.core.v3:swagger-annotations-jakarta:2.2.27")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.0")

    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")

    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
}

/**
 * MapStruct Spring Bean 자동 등록 설정
 * 해당 속성은 컴파일 시 MapStruct가 생성한 구현체를 Spring Bean으로 등록하기 위한 설정이다. (따라서 yml 같은 곳에 설정 불가)
 */
tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}

flyway {
    driver = "org.postgresql.Driver"
    url = "jdbc:postgresql://localhost:5432/toy_recruit_local"
    user = "seongha_flyway"
    password = "seongha123"
    baselineOnMigrate = true
    baselineVersion = "1"  // 기존 데이터베이스의 버전을 1로 설정
    locations = arrayOf("filesystem:flyway/migration/postgresql")
    cleanDisabled = false
}

tasks.withType<Test> {
    useJUnitPlatform()
}
