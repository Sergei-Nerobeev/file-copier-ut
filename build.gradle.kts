plugins {
    id("java")
}

group = "hu.nerbe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("info.picocli:picocli:4.7.7")
    compileOnly("info.picocli:picocli-codegen:4.7.7")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

//tasks.compileJava {
//    options.compilerArgs.add("-Aproject=${project.group}/${project.name}")
//}