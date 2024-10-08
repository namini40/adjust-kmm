val MODULE_PACKAGE_NAME: String by project
val MODULE_NAME: String by project
val MODULE_VERSION_NUMBER: String by project

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.spm)
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "13.0"
        framework {
            baseName = "shared"
            isStatic = true
        }

        pod("Adjust") {
            version = "5.0.1"
            moduleName = "AdjustSdk"
//            packageName = "AdjustSdk"
//            headers = "Adjust/Adjust/*.h"
//            extraOpts = listOf("-compiler-option", "-fmodules")
        }
    }

    sourceSets {
        val commonMain by getting
        val androidMain by getting {
            dependencies {
                implementation(libs.adjust.android)
            }
        }
    }
    multiplatformSwiftPackage {
        packageName("com.adjust")
        swiftToolsVersion("5.4")
        targetPlatforms {
            iOS { v("13") }
        }
    }
}

android {
    namespace = "com.adjust"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
//    dependencies {
//        implementation(libs.adjust.android)
//    }
}
