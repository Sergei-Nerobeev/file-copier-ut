plugins {
    application
}

group = "hu.nerbe"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("hu.nerbe.fcu.FileCopier")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("info.picocli:picocli:4.7.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine")


}

tasks.test {
    useJUnitPlatform()
}

