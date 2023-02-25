plugins {
    id("android-library-plugin")
    id(AndroidConfig.Plugin.mavenPublish)
}

publishComposePermissionHandler("core")

android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Versions.composeCompiler
}

dependencies {
    implementation(Libs.Google.Accompanist.permissions)
    implementation(Libs.AndroidX.Compose.material3)
}
