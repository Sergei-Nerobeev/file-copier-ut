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
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

