// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("lifecycle_version", "2.6.2")
        set("room_version", "2.6.1")
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("com.android.library") version "8.1.2" apply false

    // ✅ FIXED: Kotlin upgraded to 1.9.20
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false

    // ✅ Also add KSP globally (matches your app)
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
}