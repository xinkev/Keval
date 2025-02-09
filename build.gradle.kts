/*
 * @notKamui
 *
 * Gradle build file for Keval
 */

group = "com.notkamui.libs"
version = "1.1.1"


plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

repositories {
    mavenCentral()
}

kotlin {
    jvm("desktop")
    js(IR) {
        nodejs()
        browser()
    }
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "keval"
            isStatic = true
        }
    }

    sourceSets {
        val desktopMain by getting
        val commonMain by getting {
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}
