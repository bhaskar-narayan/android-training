// Build Plugins
private const val androidGradleVersion = "4.2.2"
private const val kotlinVersion = "1.5.21"
private const val apolloVersion = "1.2.0"
private const val googleServicesVersion = "4.3.10"
private const val crashlyticsVersion = "2.8.1"

// JetPack
private const val navigationVersion = "2.3.5"
private const val hiltVersion = "2.38.1"
private const val ktLintVersion = "10.2.1"

object Dependencies {
    object BuildPlugins {
        const val androidGradle = "com.android.tools.build:gradle:$androidGradleVersion"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val apolloGraphQl = "com.apollographql.apollo:apollo-gradle-plugin:$apolloVersion"
        const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
        const val safeArgs ="androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
        const val googleServices = "com.google.gms:google-services:$googleServicesVersion"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:$crashlyticsVersion"
        const val ktLint = "org.jlleitschuh.gradle:ktlint-gradle:$ktLintVersion"

    }

    object Realm {
        const val realmDependency = "io.realm:realm-gradle-plugin:10.6.0"
    }

    object Android {
        const val minSdkVersion = 26
        const val targetSdkVersion = 31
        const val compileSdkVersion = 31
        const val buildToolsVersion = "30.0.3"
        const val applicationId = "com.carmedia2p0.capture.dev"
        const val versionCode = 1
        const val versionName = "1.0.1"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Kotlin {
        private const val coroutinesVersion = "1.5.0"

        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    }

    object JetPack {
        private const val coreVersion = "1.6.0"
        private const val appcompatVersion = "1.3.1"
        private const val materialVersion = "1.3.0"
        private const val activityVersion = "1.2.3"
        private const val fragmentVersion = "1.3.5"
        private const val constraintLayoutVersion = "2.1.0"
        private const val coordinatorLayoutVersion = "1.1.0"
        private const val pagingVersion = "3.0.0"
        private const val recyclerViewVersion = "1.2.1"
        private const val recyclerViewSelectionVersion = "1.1.0"
        private const val cardViewVersion = "1.0.0"
        private const val lifecycleVersion = "2.3.1"
        private const val roomVersion = "2.3.0"
        private const val dataStoreVersion = "1.0.0-rc01"
        private const val swipeRefreshLayoutVersion = "1.1.0"
        private const val deSugarVersion = "1.1.5"
        private const val workRuntimeVersion = "2.6.0"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appcompatVersion"
        const val material = "com.google.android.material:material:$materialVersion"
        const val activity = "androidx.activity:activity:$activityVersion"
        const val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val coordinatorLayout =
            "androidx.coordinatorlayout:coordinatorlayout:$coordinatorLayoutVersion"
        const val paging = "androidx.paging:paging-runtime:$pagingVersion"
        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"
        const val recyclerViewSelection =
            "androidx.recyclerview:recyclerview-selection:$recyclerViewSelectionVersion"
        const val cardView = "androidx.cardview:cardview:$cardViewVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
        const val room = "androidx.room:room-runtime:$roomVersion"
        const val roomKotlinAnnotation = "androidx.room:room-compiler:$roomVersion"
        const val roomKotlinExtension = "androidx.room:room-ktx:$roomVersion"
        const val dataStore = "androidx.datastore:datastore:$dataStoreVersion"
        const val datastorePreferences =
            "androidx.datastore:datastore-preferences:$dataStoreVersion"
        const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:$swipeRefreshLayoutVersion"
        const val deSugar = "com.android.tools:desugar_jdk_libs:$deSugarVersion"
        const val workRuntime = "androidx.work:work-runtime:$workRuntimeVersion"
    }

    object Test {
        private const val junitVersion = "4.12"
        private const val junitExtensionVersion = "1.1.2"
        private const val espressoVersion = "3.3.0"

        const val junit = "junit:junit:$junitVersion"
        const val junitExtension = "androidx.test.ext:junit:$junitExtensionVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    }

    object Retrofit {
        private const val retrofitVersion = "2.9.0"
        private const val okHttpVersion = "4.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val mock = "com.squareup.retrofit2:retrofit-mock:$retrofitVersion"
        const val gson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val okhttp3 = "com.squareup.okhttp3:okhttp:$okHttpVersion"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
    }

    object Epoxy {
        private const val epoxyVersion = "4.6.2"
        const val core = "com.airbnb.android:epoxy:$epoxyVersion"
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:$epoxyVersion"
        const val databinding = "com.airbnb.android:epoxy-databinding:$epoxyVersion"
        const val paging3 = "com.airbnb.android:epoxy-paging3:$epoxyVersion"
    }

    object PlayService {
        const val auth = "com.google.android.gms:play-services-auth:17.0.0"
        const val authApiPhone = "com.google.android.gms:play-services-auth-api-phone:17.4.0"
    }

    object Others {
        const val glide = "com.github.bumptech.glide:glide:4.12.0"
        const val ccp = "com.hbb20:ccp:2.5.3"
        const val decorator = "io.cabriole:decorator:1.3.0"
        const val imagePicker = "com.github.dhaval2404:imagepicker-support:1.7.1"
        const val signaturePad = "com.github.gcacace:signature-pad:1.3.1"
        const val photoView = "com.github.chrisbanes:PhotoView:2.3.0"
        const val ruler = "com.kevalpatel2106:ruler-picker:1.1"
        const val otp = "com.github.aabhasr1:OtpView:v1.1.2-ktx"
        const val fancyAndroidRuler = "com.github.AbdElraoufSabri:FancyAndroidRuler:1.5.1"
        const val circleImageView = "de.hdodenhof:circleimageview:3.1.0"
        const val mpChart = "com.github.PhilJay:MPAndroidChart:v3.1.0"
        const val calendar = "com.github.kizitonwose:CalendarView:1.0.4"
    }
}
