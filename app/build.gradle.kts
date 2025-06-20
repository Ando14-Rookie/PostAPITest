plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.postapitest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.postapitest"
        minSdk = 24
        targetSdk = 34
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Okhttp3 for the POST requests
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    // Gson to convert raw JSON to pretty JSON
    implementation("com.google.code.gson:gson:2.13.1")
    // Coroutines to make the HTTP requests asynchronous(In the background thread)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //Gson Converter Factory
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}