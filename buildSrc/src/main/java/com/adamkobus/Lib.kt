package com.adamkobus

object Lib {
    /**
     * [Jetpack Compose Releases](https://developer.android.com/jetpack/androidx/versions/all-channel)
     */
    const val COMPOSE_VERSION = "1.2.1"

    /**
     * [Kotlin Releases](https://kotlinlang.org/docs/releases.html#release-details)
     */
    const val KOTLIN_VERSION = "1.6.10"

    /**
     * [Accompanist Version](https://github.com/google/accompanist/releases)
     */
    const val ACCOMPANIST_VERSION = "0.25.1"

    /**
     * [Kotlint Coroutines Releases](https://github.com/Kotlin/kotlinx.coroutines/releases)
     */
    const val KOTLIN_COROUTINES_VERSION = "1.6.4"

    /**
     * [Hilt Releases](https://github.com/google/dagger/releases)
     */
    const val HILT_VERSION = "2.40.5"

    /**
     * [Ktlint Releases](https://github.com/pinterest/ktlint/releases)
     */
    const val KTLINT_VERSION = "0.45.2"

    /**
     * [Appcompat Releases](https://developer.android.com/jetpack/androidx/releases/appcompat#1.4.1)
     */
    const val APPCOMPAT_VERSION = "1.4.1"

    object Kotlin {
        const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$KOTLIN_COROUTINES_VERSION"
    }

    object Compose {
        /**
         * [Compose Activity Releases](https://androidx.tech/artifacts/activity/activity-compose/)
         */
        const val Activity = "androidx.activity:activity-compose:1.4.0"
        const val Ui = "androidx.compose.ui:ui:$COMPOSE_VERSION"
        const val Material = "androidx.compose.material:material:$COMPOSE_VERSION"
        const val ToolingPreview = "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"

        const val UiTooling = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
    }

    object Accompanist {
        const val NavigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$ACCOMPANIST_VERSION"
        const val SystemUiController = "com.google.accompanist:accompanist-systemuicontroller:$ACCOMPANIST_VERSION"
    }

    object AndroidX {
        const val Core = "androidx.core:core-ktx:1.7.0"
        const val Appcompat = "androidx.appcompat:appcompat:$APPCOMPAT_VERSION"
        const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
        const val LifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
    }

    object Google {
        /**
         * [Material Releases](https://github.com/material-components/material-components-android/releases)
         */
        const val Material = "com.google.android.material:material:1.5.0"
        const val Hilt = "com.google.dagger:hilt-android:$HILT_VERSION"
        const val HiltCompiler = "com.google.dagger:hilt-android-compiler:$HILT_VERSION"

        /**
         * [Hilt Navigation Compose Releases](https://developer.android.com/jetpack/androidx/releases/hilt)
         */
        const val HiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object AdamKobus {
        /**
         * [Lifecycle Aware ViewModel Releases](https://github.com/AdamKobus/lifecycle-aware-viewmodel/releases)
         */
        const val LifecycleAwareViewModel = "com.adamkobus:lifecycle-observer-viewmodel-ktx:1.0.2"
    }

    object Test {
        /**
         * [JUnit4 Releases](https://github.com/junit-team/junit4/releases)
         */
        const val JUnit = "junit:junit:4.13.2"

        /**
         * [Mockk Releases](https://github.com/mockk/mockk/releases)
         */
        const val Mockk = "io.mockk:mockk:1.12.5"

        const val CoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$KOTLIN_COROUTINES_VERSION"
    }
}
