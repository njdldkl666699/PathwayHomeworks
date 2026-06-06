plugins {
    id("my.android.app")
}

android {
    namespace = "io.njdldkl.android.courses"

    defaultConfig {
        applicationId = "io.njdldkl.android.courses"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}