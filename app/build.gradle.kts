plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.dswjp.muebleria_miley_movil"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dswjp.muebleria_miley_movil"
        minSdk = 29
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    packaging{
        resources {
            excludes.add("META-INF/NOTICE.md")
            excludes.add("META-INF/LICENSE.md")
        }
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

    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.runtime)
    implementation(libs.annotationprocesor)

    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging)

    implementation(libs.dagger.android)
    annotationProcessor(libs.dagger.compiler)

    implementation(libs.picasso)

    implementation(libs.stetho)
    implementation(libs.stetho.okhttp3)

    implementation(libs.material.spinner)

    implementation(libs.mail)
    implementation(libs.activation)

    implementation(libs.maps)
    implementation(libs.places)

    implementation(libs.sweet.alert)

    implementation(libs.circleimageview)

    implementation(libs.glide)
    
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(libs.android.image.slider)


    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}