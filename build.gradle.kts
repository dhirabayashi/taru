import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.seasar.doma.compile") version "1.1.1-beta1"
	id("de.undercouch.download") version "4.1.2"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("kapt") version "1.6.10"
}

group = "com.github.dhirabayashi"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

val schemaSpyJdbc: Configuration by configurations.creating

repositories {
	mavenCentral()
}

dependencies {
	kapt("org.seasar.doma:doma-processor:2.51.0")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.seasar.doma:doma-kotlin:2.51.0")
	implementation("org.seasar.doma.boot:doma-spring-boot-starter:1.6.0")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")

	schemaSpyJdbc("org.postgresql:postgresql:42.3.1")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


tasks.create<JavaExec>("schemaSpy") {
	group = name
	description = "Generates database documents."

	val outputDir = file("${buildDir}/${name}")
	outputDir.deleteRecursively()

	val driverFile = schemaSpyJdbc.files.first()

	lateinit var schemaSpyFile: File
	task<de.undercouch.gradle.tasks.download.Download>("downloadTask") {
		schemaSpyFile = file( "${downloadTaskDir}/${name}/schemaspy.jar" )

		src("https://github.com/schemaspy/schemaspy/releases/download/v6.1.0/schemaspy-6.1.0.jar")
		dest(schemaSpyFile)
		overwrite(false)
	}

	main = "-jar"
	args = listOf(
		schemaSpyFile.toString(),
		"-t", "pgsql11",
		"-dp", driverFile.toString(),
		"-host", "localhost",
		"-port", "5432",
		"-u", "root",
		"-p", "root",
		"-db", "root",
		"-s", "public",
		"-o", outputDir.toString()
	)

	dependsOn("downloadTask")
}