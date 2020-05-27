import org.gradle.api.JavaVersion

object Versions {
    // region Languages
    const val kotlin = "1.3.72"
    val java = JavaVersion.VERSION_1_8
    // endregion
    // region Plugins
    const val androidGradlePlugin = "3.6.3"
    const val kotlinGradlePlugin = kotlin
    const val googleServicesPlugin = "4.3.3"
    // endregion
    // region AndroidX
    const val androidxAppCompat = "1.1.0"
    const val androidxCardView = "1.0.0"
    const val androidxConstraintLayout = "1.1.3"
    const val androidxCoordinatorLayout = "1.1.0"
    const val androidxRecyclerView = "1.1.0"
    const val material = "1.1.0"
    // endregion
    // region Libraries
    const val adapterDelegates = "4.3.0"
    const val cicerone = "5.1.0"
    const val firebaseAnalytics = "17.4.1"
    const val fragment = "1.2.4"
    const val koin = "2.1.5"
}
