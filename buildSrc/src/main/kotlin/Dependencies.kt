import Versions.Androidx
import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
  val TIMBER by lazy { "com.jakewharton.timber:timber:${Versions.TIMBER}" }
  val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }


  // APP_COMPAT
  const val ANDROID_APP_COMPAT = "androidx.appcompat:appcompat:${Androidx.APP_COMPAT}"
  const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Androidx.CORE_KTX}"

  // COMPOSE
  // Compose: BOM
  const val COMPOSE_BOM = "androidx.compose:compose-bom:${Versions.COMPOSE_BOM_VERSION}"

  // Compose: Compose for Activity
  val COMPOSE_ACTIVITY by lazy { "androidx.activity:activity-compose:1.7.0-alpha02" }

  // Compose: Compose for Lifecycle
  const val COMPOSE_RUNTIME_LIFECYCLE =
    "androidx.lifecycle:lifecycle-runtime-compose:${Androidx.RUNTIME_COMPOSE}"

  // Compose: Material
  const val COMPOSE_MATERIAL = "androidx.compose.material:material"

  // Compose: Android Studio Preview support
  const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
  const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"

  // Compose: UI tests
  const val COMPOSE_UI_TEST_JUNIT4 = "androidx.compose.ui:ui-test-junit4"
  const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"

  // NAVIGATION COMPONENT
  // Navigation: Jetpack Compose Integration
  const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:${Versions.NAV_VERSION}"

  // KOIN
  const val KOIN_CORE = "io.insert-koin:koin-core:${Versions.KOIN_VERSION}"
  const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN_VERSION}"
  const val KOIN_ANDROID_EXT = "io.insert-koin:koin-android-ext:${Versions.KOIN_EXT_VERSION}"
  const val KOIN_COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.KOIN_COMPOSE_VERSION}"

  // COROUTINES
  const val KOTLINX_COROUTINES_ANDROID =
    "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"

  // RETROFIT
  const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
  const val RETROFIT_GSON_CONVERTER =
    "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"

  // GSON
  const val GSON = "com.google.code.gson:gson:${Versions.GSON_VERSION}"

  // LANDSCAPIST: GLIDE
  const val LANDSCAPIST_GLIDE =
    "com.github.skydoves:landscapist-glide:${Versions.LANDSCAPIST_GLIDE}"

  // TEST
  const val JUNIT4 = "junit:junit:${Versions.JUNIT}"
  const val ANDROIDX_TEST_EXT_JUNIT = "androidx.test.ext:junit:${Androidx.TEST_EXT}"
  const val ANDROIDX_TEST_ESPRESSO = "androidx.test.espresso:espresso-core:${Androidx.TEST_ESPRESSO}"
}

fun DependencyHandler.appCompat() {
  implementation(Dependencies.ANDROID_APP_COMPAT)
  implementation(Dependencies.ANDROID_CORE_KTX)
}

fun DependencyHandler.compose() {
  val composeBom = platform(Dependencies.COMPOSE_BOM)
  implementation(composeBom)
  androidTestImplementation(composeBom)

  implementation(Dependencies.COMPOSE_MATERIAL)
  implementation(Dependencies.COMPOSE_UI_TOOLING_PREVIEW)
  implementation(Dependencies.COMPOSE_RUNTIME_LIFECYCLE)
  debugImplementation(Dependencies.COMPOSE_UI_TOOLING)
  androidTestImplementation(Dependencies.COMPOSE_UI_TEST_JUNIT4)
  debugImplementation(Dependencies.COMPOSE_UI_TEST_MANIFEST)
}

fun DependencyHandler.navigation() {
  implementation(Dependencies.NAVIGATION_COMPOSE)
}

fun DependencyHandler.koin() {
  implementation(Dependencies.KOIN_CORE)
  implementation(Dependencies.KOIN_ANDROID)
  implementation(Dependencies.KOIN_ANDROID_EXT)
  implementation(Dependencies.KOIN_COMPOSE)
}

fun DependencyHandler.coroutines() {
  implementation(Dependencies.KOTLINX_COROUTINES_ANDROID)
}

fun DependencyHandler.network() {
  implementation(Dependencies.RETROFIT)
  implementation(Dependencies.RETROFIT_GSON_CONVERTER)
  implementation(Dependencies.GSON)
}

fun DependencyHandler.gson() {
  implementation(Dependencies.GSON)
}

fun DependencyHandler.glide() {
  implementation(Dependencies.LANDSCAPIST_GLIDE)
}

fun DependencyHandler.timber() {
  implementation(Dependencies.TIMBER)
}

fun DependencyHandler.test() {
  testImplementation(Dependencies.JUNIT4)
  androidTestImplementation(Dependencies.ANDROIDX_TEST_EXT_JUNIT)
  androidTestImplementation(Dependencies.ANDROIDX_TEST_ESPRESSO)
}

fun DependencyHandler.implementation(dependency: Any) {
  add("implementation", dependency)
}

fun DependencyHandler.debugImplementation(dependency: Any) {
  add("debugImplementation", dependency)
}

fun DependencyHandler.testImplementation(dependency: Any) {
  add("testImplementation", dependency)
}

fun DependencyHandler.androidTestImplementation(dependency: Any) {
  add("androidTestImplementation", dependency)
}