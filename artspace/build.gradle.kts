plugins {
    id("my.android.app")
}

android {
    namespace = "com.example.artspace"
    defaultConfig {
        applicationId = "com.example.artspace"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")

    implementation("androidx.compose.material:material-icons-core:1.7.8")

    implementation("androidx.compose.material3:material3-window-size-class")
    
    implementation("androidx.compose.runtime:runtime")
    implementation("androidx.compose.runtime:runtime-livedata")
}