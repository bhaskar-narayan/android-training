

plugins {
    id("com.android.application")
    id("com.apollographql.android")
    id("kotlin-android")
//    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
//    id("com.google.gms.google-services")
//    id("com.google.firebase.crashlytics")
}

android {
    compileSdkVersion(Dependencies.Android.compileSdkVersion)
    buildToolsVersion(Dependencies.Android.buildToolsVersion)

    fun getGradleProperty(key: String): String {
        return project.property(key) as String
    }

    defaultConfig {
        applicationId = Dependencies.Android.applicationId
        minSdkVersion(Dependencies.Android.minSdkVersion)
        targetSdkVersion(Dependencies.Android.targetSdkVersion)
        versionCode = Dependencies.Android.versionCode
        versionName = Dependencies.Android.versionName
        multiDexEnabled = true
        testInstrumentationRunner = Dependencies.Android.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isCrunchPngs = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isDebuggable = true
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
//        freeCompilerArgs = listOf("-Xallow-result-return-type")
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("com.android.volley:volley:1.2.0")
    val retrofitVersion = "2.9.0"
    val okhttpVersion = "4.9.0"
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.JetPack.core)
    implementation(Dependencies.JetPack.appCompat)
    implementation(Dependencies.JetPack.constraintLayout)
    implementation(Dependencies.JetPack.workRuntime)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("com.google.android.gms:play-services-analytics:17.0.1")
    implementation("com.google.android.gms:play-services-location:18.0.0")

    // Navigation Components
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    // For Service
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Material Design
    implementation("com.google.android.material:material:1.4.0")

    // firbase
//    implementation("com.google.firebase:firebase-config:21.0.1")
//    implementation(platform("com.google.firebase:firebase-bom:29.0.3"))
//    implementation("com.google.firebase:firebase-crashlytics-ktx")
//    implementation("com.google.firebase:firebase-analytics-ktx")

    // Joda time Android
    implementation("net.danlew:android.joda:2.10.9.1")

    // Timber
    implementation("com.jakewharton.timber:timber:4.7.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    // Coroutine Lifecycle Scopes
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Room
    implementation("androidx.room:room-runtime:2.3.0")
    kapt("androidx.room:room-compiler:2.3.0")

    // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.3.0")

    // Dagger Core
    implementation("com.google.dagger:dagger:2.37")
    kapt("com.google.dagger:dagger-compiler:2.37")

    // Dagger Android
    api("com.google.dagger:dagger-android:2.35.1")
    api("com.google.dagger:dagger-android-support:2.23.2")
    kapt("com.google.dagger:dagger-android-processor:2.23.2")

    // Activity KTX for viewModels()
    implementation("androidx.activity:activity-ktx:1.3.1")
    implementation("androidx.fragment:fragment-ktx:1.4.0-alpha08")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.37")
    kapt("com.google.dagger:hilt-android-compiler:2.37")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Retrofit
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion") {

        exclude("okhttp")
    }

    implementation("com.android.support:multidex:1.0.3")
    implementation("com.google.code.gson:gson:2.8.7")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0-alpha03")

    // Easy Permissions
    implementation("pub.devrel:easypermissions:3.0.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    // Datastore
    implementation(Dependencies.JetPack.dataStore)
    implementation(Dependencies.JetPack.datastorePreferences)

    //    test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // APIs for SplashScreen, including compatiblity helpers on devices prior Android 12
    implementation("androidx.core:core-splashscreen:1.0.0-beta01")

    implementation("me.dm7.barcodescanner:zxing:1.9.8")

//    MSAL
    implementation("com.microsoft.identity.client:msal:2.2.3")
}
