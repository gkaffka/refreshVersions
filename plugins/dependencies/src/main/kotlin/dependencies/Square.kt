@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection", "unused")

import dependencies.DependencyNotationAndGroup
import org.gradle.api.Incubating

@Incubating
object Square {

    val okHttp3 = OkHttp3
    val retrofit2 = Retrofit2
    val sqlDelight = SqlDelight
    val moshi = Moshi
    val wire = Wire

    /**
     * **LeakCanary is a memory leak detection library for Android.**
     *
     * **Official website:**
     * - [Home/Overview](https://square.github.io/leakcanary/)
     * - [Getting Started](https://square.github.io/leakcanary/getting_started/)
     * - [Fundamentals](https://square.github.io/leakcanary/fundamentals/)
     * - [Code recipes](https://square.github.io/leakcanary/recipes/)
     * - [FAQ](https://square.github.io/leakcanary/faq/)
     *
     * Browse the navigation menu on the website to see more.
     */
    val leakCanary = LeakCanary

    /**
     * `KotlinPoet` is a Kotlin and Java API for generating `.kt` source files.
     *
     * Official website: [square.github.io/kotlinpoet](https://square.github.io/kotlinpoet/)
     *
     * [Change Log](https://square.github.io/kotlinpoet/changelog/)
     *
     * GitHub page: [square/kotlinpoet](https://github.com/square/kotlinpoet)
     *
     * [API reference](https://square.github.io/kotlinpoet/1.x/kotlinpoet/)
     */
    val kotlinPoet = KotlinPoet

    /**
     * Official website: [square.github.io/picasso](https://square.github.io/picasso/)
     *
     * [Change log](https://github.com/square/picasso/blob/master/CHANGELOG.md)
     *
     * GitHub page: [square/picasso](https://github.com/square/picasso)
     */
    val picasso = Picasso

    const val okio = "com.squareup.okio:okio:_"

    object OkHttp3 {
        private const val group = "com.squareup.okhttp3"
        const val okHttp = "$group:okhttp:_"
        const val loggingInterceptor = "$group:logging-interceptor:_"
        const val mockWebServer = "$group:mockwebserver:_"
    }

    object Retrofit2 {
        private const val group = "com.squareup.retrofit2"

        const val retrofit = "$group:retrofit:_"
        const val mock = "$group:retrofit-mock:_"

        val converter = Converter
        val adapter = Adapter

        object Converter {
            private const val artifactPrefix = "$group:converter"

            const val scalars = "$artifactPrefix-scalars:_"

            const val moshi = "$artifactPrefix-moshi:_"
            const val gson = "$artifactPrefix-gson:_"
            const val jackson = "$artifactPrefix-jackson:_"

            const val simpleXml = "$artifactPrefix-simplexml:_"
        }

        object Adapter {
            const val java8 = "$group:adapter-java8:_"
            const val rxJava1 = "$group:adapter-rxjava:_"
            const val rxJava2 = "$group:adapter-rxjava2:_"
            const val rxJava3 = "$group:adapter-rxjava3:_"
        }
    }

    object SqlDelight {
        private const val group = "com.squareup.sqldelight"

        const val gradlePlugin = "$group:gradle-plugin:_"

        val drivers = Drivers

        const val coroutinesExtensions = "$group:coroutines-extensions"

        object Drivers {
            const val android = "$group:android-driver:_"

            const val jdbc = "$group:jdbc-driver:_"
            const val jdbcSqlite = "$group:sqlite-driver:_"

            const val native = "$group:native-driver:_"
        }
    }

    object Moshi : DependencyNotationAndGroup(group = "com.squareup.moshi", name = "moshi") {
        @JvmField val kotlinReflect = "$artifactPrefix-kotlin:_"
        @JvmField val kotlinCodegen = "$artifactPrefix-kotlin-codegen:_"
        @JvmField val javaReflect = backingString
    }

    object Wire {
        private const val artifactPrefix = "com.squareup.wire:wire"

        const val gradlePlugin = "$artifactPrefix-gradle-plugin:_"

        const val runtime = "$artifactPrefix-runtime:_"
        val grpc = Grpc

        object Grpc {
            const val client = "$artifactPrefix-grpc-client:_"
        }
    }

    object LeakCanary {
        private const val group = "com.squareup.leakcanary"

        /**
         * [API reference](https://square.github.io/leakcanary/api/leakcanary-android-core/leakcanary/)
         */
        const val android = "$group:leakcanary-android:_"

        /**
         * [Code recipe](https://square.github.io/leakcanary/recipes/#running-the-leakcanary-analysis-in-a-separate-process)
         *
         * [API reference](https://square.github.io/leakcanary/api/leakcanary-android-process/leakcanary/)
         */
        const val androidProcess = "$group:leakcanary-android-process:_"

        /**
         * [Code recipe](https://square.github.io/leakcanary/recipes/#running-leakcanary-in-instrumentation-tests)
         *
         * [API reference](https://square.github.io/leakcanary/api/leakcanary-android-instrumentation/leakcanary/)
         */
        const val androidInstrumentation = "$group:leakcanary-android-instrumentation:_"

        /**
         * [Blog post "LeakCanary—Deobfuscation Feature Explained" by the contributors to this feature](https://www.polidea.com/blog/leakcanary-deobfuscation-feature-explained/)
         */
        const val deobfuscationGradlePlugin = "$group:leakcanary-deobfuscation-gradle-plugin:_"

        /**
         * [Plumber introduction in the changelog of the version 2.4](https://square.github.io/leakcanary/changelog/#version-24-2020-06-10)
         */
        const val plumber = "$group:plumber-android:_"

        /**
         * [API reference](https://square.github.io/leakcanary/api/leakcanary-object-watcher/leakcanary/)
         */
        val objectWatcher = ObjectWatcher

        object ObjectWatcher : DependencyNotationAndGroup(group = group, name = "leakcanary-object-watcher") {

            /**
             * [Code recipe](https://square.github.io/leakcanary/recipes/#counting-retained-instances-in-release-builds)
             *
             * [API reference](https://square.github.io/leakcanary/api/leakcanary-object-watcher-android/leakcanary/)
             */
            @JvmField val android = "$artifactPrefix-android:_"
        }

        /**
         * Shark: Smart Heap Analysis Reports for Kotlin
         *
         * [Official documentation](https://square.github.io/leakcanary/shark/)
         *
         * [Announcement blog post](https://developer.squareup.com/blog/announcing-shark-smart-heap-analysis-reports-for-kotlin/)
         *
         * [API reference](https://square.github.io/leakcanary/api/shark/shark/)
         *
         * [Logging API reference](https://square.github.io/leakcanary/api/shark-log/shark/)
         */
        val shark = Shark

        object Shark : DependencyNotationAndGroup(group = group, name = "shark") {

            /**
             * [API reference](https://square.github.io/leakcanary/api/shark-hprof/shark/)
             */
            @JvmField val hprof = "$artifactPrefix-hprof:_"

            /**
             * [API reference](https://square.github.io/leakcanary/api/shark-graph/shark/)
             */
            @JvmField val graph = "$artifactPrefix-graph:_"

            /**
             * [API reference](https://square.github.io/leakcanary/api/shark-android/shark/)
             */
            @JvmField val android = "$artifactPrefix-android:_"

            /**
             * [Official documentation](https://square.github.io/leakcanary/shark/#shark-cli)
             */
            @JvmField val cli = "$artifactPrefix-cli:_"
        }
    }

    object KotlinPoet : DependencyNotationAndGroup(group = "com.squareup", name = "kotlinpoet") {

        /**
         * [Official webpage](https://square.github.io/kotlinpoet/kotlinpoet_metadata/)
         *
         * [API reference](https://square.github.io/kotlinpoet/1.x/kotlinpoet-metadata/com.squareup.kotlinpoet.metadata/)
         */
        @JvmField val metadata = "$artifactPrefix-metadata:_"

        /**
         * [Official webpage](https://square.github.io/kotlinpoet/kotlinpoet_metadata_specs/)
         *
         * [API reference](https://square.github.io/kotlinpoet/1.x/kotlinpoet-metadata-specs/com.squareup.kotlinpoet.metadata.specs/)
         */
        @JvmField val metadataSpecs = "$artifactPrefix-metadata-specs:_"
    }

    object Picasso : DependencyNotationAndGroup(group = "com.squareup.picasso", name = "picasso") {

        /**
         * [Documentation page](https://github.com/square/picasso/blob/master/picasso-pollexor/README.md)
         */
        @JvmField val pollexor = "$artifactPrefix-pollexor:_"
    }
}
