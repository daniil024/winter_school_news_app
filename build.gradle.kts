// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
  repositories {
    google()
    mavenCentral()
  }
}

plugins {
  id("com.android.application") version "8.1.2" apply false
  id("org.jetbrains.kotlin.android") version "1.8.10" apply false
  id("org.jetbrains.kotlin.jvm") version Versions.kotlin apply false
  id("com.android.library") version "8.1.2" apply false
}