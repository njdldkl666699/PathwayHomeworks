plugins {
    id("my.android.app")
}

android {
    namespace = "io.njdldkl.android.dessertclicker"
    defaultConfig {
        applicationId = "io.njdldkl.android.dessertclicker"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
    implementation("androidx.compose.material:material-icons-extended")
}