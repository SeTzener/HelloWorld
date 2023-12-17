// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    application
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.21"
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}

buildscript{
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.9.20"))
        classpath("com.android.tools.build:gradle:8.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.20")
    }
    repositories{
        google()
        mavenCentral()
    }
}