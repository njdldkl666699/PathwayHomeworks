plugins {
    id("my.android.app")
}

android {
    namespace = "io.njdldkl.android.lemonade"

    defaultConfig {
        applicationId = "io.njdldkl.android.lemonade"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}
