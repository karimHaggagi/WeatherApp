plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.android)
}

android {
    namespace = "com.example.home"
    compileSdk = ProjectConfig.COMPILE_SDK

    defaultConfig {
        minSdk = ProjectConfig.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {


    implementation(projects.core.data)
    implementation(projects.core.common)
    implementation(projects.core.model)

    implementation(projects.core.ui)
    implementation(projects.domain.usecase)
    //hilt
    implementation (libs.hilt.android)
    implementation(libs.junit.ktx)
    implementation(libs.androidx.hilt.navigation.compose )
    ksp(libs.hilt.compiler)

    implementation(projects.core.utils)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // testing
    testImplementation (libs.hamcrest.all)
    testImplementation (libs.androidx.core.testing)
    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.truth)
    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.inline)

    testImplementation (libs.turbine)
    testImplementation(libs.junit)

    testImplementation (libs.mockito.core)
    testImplementation (libs.mockito.kotlin)


    // AndroidX Test - Instrumented testing
    androidTestImplementation (libs.androidx.junit.ktx)
    androidTestImplementation (libs.androidx.room.testing)
    androidTestImplementation (libs.androidx.core.testing)
    androidTestImplementation (libs.androidx.espresso.contrib)
    androidTestImplementation (libs.androidx.espresso.intents)
    androidTestImplementation (libs.androidx.idling.concurrent)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}