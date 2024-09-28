// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false

}
dependencies {
    implementation("com.google.android.material:material:1.5.0")
    // ... other dependencies
}

fun implementation(s: String) {

}
