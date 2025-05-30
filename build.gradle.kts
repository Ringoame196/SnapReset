plugins {
    kotlin("jvm") version "2.1.10"
}

group = "com.github.ringoame196"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(22)
}
tasks.register<Copy>("reset") {
    val srcDirPath = "src/main/java/"
    val srcDir = projectDir.resolve(srcDirPath).apply(File::mkdirs)
    srcDir.resolve("Main.java").writeText(
        """
            import java.util.*;
            
            public class Main {
                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Hello World");
                }
            }
            """.trimIndent()
    )
}