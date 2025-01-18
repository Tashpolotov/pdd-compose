plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.pdd_compose"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.pdd_compose"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //okkhtp
    implementation (libs.com.squareup.okhttp3.logging.interceptor)
    implementation (libs.com.squareup.okhttp3.okhttp)
    //Splash Api
    implementation(libs.androidx.core.splashscreen)

    //Compose Navigation

    implementation (libs.androidx.navigation.compose)


    //Dagger Hilt
    implementation (libs.hilt.android)
    ksp (libs.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)


    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //Coil
    implementation(libs.coil.compose)

    //Datastore
    implementation (libs.androidx.datastore.preferences)

    //Compose Foundation
    implementation (libs.androidx.foundation)

    //Accompanist
    implementation (libs.accompanist.systemuicontroller)

    //Paging 3
//
//    implementation ("androidx.paging:paging-runtime:3.1.1")
//    implementation ("androidx.paging:paging-compose:3.2.0-rc01")

//    //Room
//
//    implementation ("androidx.room:room-runtime:$2.5.2")
//    kapt ("androidx.room:room-compiler:2.6.1")
//    implementation ("androidx.room:room-ktx:2.6.1")

    implementation(libs.accompanist.navigation.animation)
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.androidx.compose.material3.material3)

}