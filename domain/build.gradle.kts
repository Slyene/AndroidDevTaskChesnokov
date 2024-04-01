plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    // Koin
    implementation(platform(libs.io.koin.bom))
    implementation(libs.io.koin.core)

    // Paging Compose
    implementation(libs.androidx.paging.common)

    testImplementation(libs.junit)
}