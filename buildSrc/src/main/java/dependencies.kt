package com.example.composemeapp.buildsrc

// Important versions
object Version {
    const val applicationId = "com.example.composemeapp"
    private const val versionCode = 1
    private const val appVersion = 1
    const val versionName = "$versionCode.$appVersion"

    const val minSdk = 21
    const val targetSdk = 30
    const val compileSdkVersion = 30
}

// Android Libraries + They Versions
public object Libs {

    const val spotlessPlugin = "com.diffplug.spotless:spotless-plugin-gradle:4.5.1"

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-alpha07"

    const val junit = "junit:junit:4.13"

    const val material = "com.google.android.material:material:1.1.0"

    // Some Utils for Image Loading, Insets,. Thx, Chris Banes
    object Accompanist {
        private const val version = "0.5.1"
        const val coil = "dev.chrisbanes.accompanist:accompanist-coil:$version"
    }

    object Kotlin {
        const val version = "1.4.30"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        // todo: not usage
        const val extensiobns = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.4.1"

        // todo: not usage
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"

        // todo: not usage
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    //Koin
    object Koin {
        const val version = "2.2.2"
        const val core = "org.koin:koin-core:$version"
        const val android = "org.koin:koin-android:$version"
        const val fragment = "org.koin:koin-androidx-fragment:$version"
        const val viewmodel = "org.koin:koin-androidx-viewmodel:$version"
        const val scope = "org.koin:koin-androidx-scope:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0-rc01"
        const val coreKtx = "androidx.core:core-ktx:1.5.0-alpha01"

        object Lifecycle {
            private const val version = "2.3.0-beta01"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha01"
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha02"
        }

        object Compose {
            const val version = "1.0.0-alpha12"

            // todo: no usages
            const val foundation = "androidx.compose.foundation:foundation:$version"

            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha02"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"

            // todo: not usage
            const val test = "androidx.compose.test:test-core:$version"
            const val uiTest = "androidx.compose.ui:ui-test:$version"
        }

        object Navigation {
            private const val version = "2.3.0"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Material {
            private const val version = "1.2.0"
            const val material = "com.google.android.material:material:$version"
        }

        object Test {
            private const val version = "1.2.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2-rc01"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }
}