plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.rcljava_test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.rcljava_test"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("src/main/jniLibs")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

buildscript {
    repositories {
        jcenter()
        mavenCentral()
        mavenLocal()
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath ("gradle.plugin.org.ros2.tools.gradle:ament:0.7.0")
        classpath ("me.tatarka:gradle-retrolambda:3.6.1")
    }
}

dependencies {
    implementation(fileTree("libs") {
        include("*.jar")
    })
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("org.slf4j:slf4j-api:2.0.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}