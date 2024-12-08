plugins {
    application
    java
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.es2.Test")
}

tasks.javadoc {
    isFailOnError = false
}
