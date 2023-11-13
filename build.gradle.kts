// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id("com.google.dagger.hilt.android") version "2.47" apply false
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}

buildscript{
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.9.20"))
    }
    repositories{
        google()
    }
}