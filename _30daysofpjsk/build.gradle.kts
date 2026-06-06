plugins {
    id("my.android.app")
}

android {
    namespace = "com.example.pjsk"

    defaultConfig {
        applicationId = "com.example.pjsk"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("androidx.compose.material3:material3-window-size-class")
}