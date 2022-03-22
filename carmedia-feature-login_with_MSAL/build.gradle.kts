// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
            setUrl("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath(Dependencies.BuildPlugins.androidGradle)
        classpath(Dependencies.BuildPlugins.kotlinGradlePlugin)
        classpath(Dependencies.BuildPlugins.apolloGraphQl)
        classpath(Dependencies.BuildPlugins.hiltGradlePlugin)
        classpath(Dependencies.BuildPlugins.googleServices)
        classpath(Dependencies.BuildPlugins.ktLint)
    }
}

allprojects {
    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
    }
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven {
            setUrl("https://jitpack.io")
            setUrl("https://plugins.gradle.org/m2/")
        }
        maven {
            setUrl("https://pkgs.dev.azure.com/MicrosoftDeviceSDK/DuoSDK-Public/_packaging/Duo-SDK-Feed/maven/v1")
        }
        maven {
            name = "vsts-maven-adal-android"
            setUrl("https://identitydivision.pkgs.visualstudio.com/_packaging/AndroidADAL/maven/v1")
            credentials {
                username = (System.getenv("ENV_VSTS_MVN_ANDROIDADAL_USERNAME") ?: project.findProperty("vstsUsername")).toString()
                password = ((System.getenv("ENV_VSTS_MVN_ANDROIDADAL_ACCESSTOKEN") ?: project.findProperty("vstsMavenAccessToken")).toString())
            }
        }
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(rootProject.buildDir)
    }
}
