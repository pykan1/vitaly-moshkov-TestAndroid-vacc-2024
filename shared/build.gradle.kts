plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)

    alias(libs.plugins.cocoapods)
    alias(libs.plugins.libres)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktorfit)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.compose)
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.example")
        }
    }
}

configure<de.jensklingenberg.ktorfit.gradle.KtorfitGradleConfiguration>{
    version = libs.versions.ktorfit.asProvider().get()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = freeCompilerArgs + listOf("-Xcontext-receivers")
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        pod("Reachability") {
            version = "3.2"
        }
    }

    sourceSets {
        commonMain.dependencies {

            /**
             * Compose
             */
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)

            /**
             * Voyager
             */
            implementation(libs.voyager.navigator)
            implementation(libs.voyager.bottomSheetNavigator)
            implementation(libs.voyager.tabNavigator)

            implementation(libs.composeImageLoader)


            /**
             * Coroutines
             */
            implementation(libs.kotlinx.coroutines.core)

            /**
             * Koin
             */
            implementation(libs.koin.core)


            /**
             * Json Serialization
             */
            implementation(libs.kotlinx.serialization.json)

            /**
             * Ktor & Ktorfit
             */
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.jensklingenberg.ktorfit)

            /**
             * Orbit Mvi
             */
            implementation(libs.orbit.mvi.core)

            implementation(libs.libres.compose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        iosMain.dependencies {
            implementation(libs.sqldelight.driver.ios)
        }

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)

            /**
             * ViewModel
             */
            implementation(libs.androidx.lifecycle.viewmodel.ktx)

            /**
             * Sqldelight
             */
            implementation(libs.sqldelight.driver.android)
        }
    }
}

dependencies {
    val ktorfitVersion = libs.versions.ktorfit.asProvider().get()
    add("kspCommonMainMetadata", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspAndroid", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspIosX64", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspIosArm64", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
    add("kspIosSimulatorArm64", "de.jensklingenberg.ktorfit:ktorfit-ksp:$ktorfitVersion")
}

android {
    namespace = "com.example.foodapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
    }
}

libres {
    generatedClassName = "FoodResource" // "Res" by default
    generateNamedArguments = true // false by default
    baseLocaleLanguageCode = "ru" // "en" by default
    camelCaseNamesForAppleFramework = true // false by default
}

