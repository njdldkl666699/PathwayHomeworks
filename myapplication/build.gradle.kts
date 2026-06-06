plugins {
    id("my.android.app")
}

android {
    namespace = "io.njdldkl.android.myapplication"

    defaultConfig {
        applicationId = "io.njdldkl.android.myapplication"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}