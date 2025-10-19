plugins {
    id("java")
}

group = "com.sbs.jsp.board"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("io.github.cdimascio:dotenv-java:3.0.1")

    implementation("dev.langchain4j:langchain4j:1.7.1")
    // OpenAI 통합
    implementation("dev.langchain4j:langchain4j-open-ai:1.7.1")

    implementation("dev.langchain4j:langchain4j-google-ai-gemini:1.7.1")
}

tasks.test {
    useJUnitPlatform()
}