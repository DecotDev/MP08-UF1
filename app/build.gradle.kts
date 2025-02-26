plugins {
    alias(libs.plugins.android.application)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") version "2.0.1"

}

android {
    namespace = "com.example.mp08_uf1"
    compileSdk = 35


    defaultConfig {
        applicationId = "com.example.mp08_uf1"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {


    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.runtime)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.play.services.maps)
    implementation(libs.preference)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    //implementation(libs.navigation.fragment)

    //implementation(libs.navigation.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.osmdroid.android)
    implementation("org.osmdroid:osmdroid-android:6.1.16")


    //implementation(libs.material.v120)

    //implementation (libs.navigation.fragment.v230)
    //implementation (libs.navigation.ui.v230)
    //implementation (libs.viewpager2)
    //implementation (libs.material.v130alpha03)
    testImplementation (libs.junit)
    androidTestImplementation (libs.junit.v115)
    androidTestImplementation (libs.espresso.core.v351)

}
