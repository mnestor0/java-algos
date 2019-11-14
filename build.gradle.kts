plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:28.0-jre")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.5.1")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.1")
}

application {
    mainClassName = "com.github.mnestor0.java.algos.App"
}

val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()
}
