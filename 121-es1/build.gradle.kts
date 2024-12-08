plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.77.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("it.unibo.es1.Test")
}

spotbugs {
    omitVisitors.set(listOf("FindReturnRef", "DumbMethods"))
}

tasks.javadoc {
    isFailOnError = false
}
