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
    val srcJavaDirPath = "src/main/java/"
    val srcJavaDir = projectDir.resolve(srcJavaDirPath).apply(File::mkdirs)
    srcJavaDir.resolve("Main.java").writeText(
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

    val srcKotlinDirPath = "src/main/kotlin/"
    val srcKotlinDir = projectDir.resolve(srcKotlinDirPath).apply(File::mkdirs)
    srcKotlinDir.resolve("Main.kt").writeText(
        """
            import java.util.Scanner

            fun main(args: Array<String>) {
	            val scanner = Scanner(System.`in`)
	            println("Hello World")
            }
        """.trimIndent()
    )
}