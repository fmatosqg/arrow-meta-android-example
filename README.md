To compile the compiler plugin and apply it to the android project, simply compile the android project. 

If you edit `HelloWorldPlugin` you have to clean the android app and build again. To be sure, just run

`./gradlew clean :app:assembleDe --no-build-cache`

# How does it work? 

The compiler plugin is implemented in file `create-plugin/.../HelloWorldPlugin.kt`

The compiler plugin will be built through this:
```groovy

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile) {
    compileTask -> compileTask.dependsOn ":create-plugin:createNewPlugin"
}

```

and it will be applied through this:

```groovy
    kotlinOptions {
        jvmTarget = '1.8'
        freeCompilerArgs += "-Xplugin=${project.rootDir}/create-plugin/build/libs/create-plugin-all.jar"
    }
```

both in app/build.gradle. 

Note that if the create-plugin-all.jar file is not created there will be no error and the android app will be built without applying the compiler plugin.


# Pitfalls

## TODO
`ext.kotlin_version = "1.3.61"` in ./build.gradle and `compileOnly "io.arrow-kt:compiler-plugin:1.3.61-SNAPSHOT"` in create-plugin/build.gradle must be the same numbers.

 
