plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("com.android.tools.build:gradle:9.0.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.21")
}

gradlePlugin {
    plugins {
        register("myAndroidApp") {
            id = "my.android.app"
            implementationClass = "MyAndroidAppPlugin"
        }
    }
}