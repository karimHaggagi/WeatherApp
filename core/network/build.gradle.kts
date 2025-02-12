import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.android)
}


val localProperties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

val apiKey = localProperties.getProperty("API_KEY") ?: System.getenv("API_KEY") ?: ""
android {
    namespace = "com.example.network"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField("String", "API_KEY", "\"$apiKey\"")

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // okhttp3
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(projects.core.common)
    implementation(projects.core.model)
}