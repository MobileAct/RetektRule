# Retekt
[![Build Status](https://dev.azure.com/MobileAct/RetektRule/_apis/build/status/MobileAct.RetektRule?branchName=master)](https://dev.azure.com/MobileAct/RetektRule/_build/latest?definitionId=6&branchName=master) [ ![Download](https://api.bintray.com/packages/mobile-act/RetektRule/Retekt/images/download.svg) ](https://bintray.com/mobile-act/RetektRule/Retekt/_latestVersion)  
Retekt is extension rules for detekt

## Usage
build.gradle
```groovy
allprojects {
    repositories {
        google()
        jcenter()
        maven{ url "https://dl.bintray.com/mobile-act/RetektRule" } // need!
    }
}
```

```groovy
dependencies {
    detektPlugins 'mobile-act:retekt:VERSION' // adapt latest version
}
```

## Rule
see [example config](detekt.yml)

### InterfaceNaming
check interface name

#### Option
- `interfacePattern`: Regex for interface name

### TypeParameterNaming
check type parameter name

### Option
- `typeParameterPattern`: Regex for type parameter name

### SuspendFunction
check function type, validate suspend function

#### Option
- `ignorePrivateFunction`: ignore private function for this checking

### UnitFunction
check function type, validate unit function for no-return

#### Option
- `ignorePrivateFunction`: ignore private function for this checking

## License
This library is under MIT License

### Rule
- using [Kotlin Standard Library](https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib), published by [Apache License 2.0](https://github.com/JetBrains/kotlin/tree/master/license)
- using [detekt](https://github.com/arturbosch/detekt), published by [Apache License 2.0](https://github.com/arturbosch/detekt/blob/master/LICENSE)
- using [JUnit5](https://github.com/junit-team/junit5), published by [Eclipse Public License 2.0](https://github.com/junit-team/junit5/blob/master/LICENSE.md)

### Sample
- using [Kotlin Standard Library](https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib), published by [Apache License 2.0](https://github.com/JetBrains/kotlin/tree/master/license)
- using [AndroidX](https://github.com/aosp-mirror/platform_frameworks_support), published by [Apache License 2.0](https://github.com/aosp-mirror/platform_frameworks_support/blob/androidx-master-dev/LICENSE.txt)
- using [ConstraintLayout](https://android.googlesource.com/platform/frameworks/opt/sherpa/+/refs/heads/studio-master-dev/constraintlayout/), published by [Apache License 2.0](https://android.googlesource.com/platform/frameworks/opt/sherpa/+/refs/heads/studio-master-dev/constraintlayout/src/main/java/android/support/constraint/ConstraintLayout.java)
- using [detekt](https://github.com/arturbosch/detekt), published by [Apache License 2.0](https://github.com/arturbosch/detekt/blob/master/LICENSE)
- using [AndroidX Test](https://github.com/android/android-test), published by [Apache License 2.0](https://github.com/android/android-test/blob/master/LICENSE)
- using [JUnit4](https://github.com/junit-team/junit4), published by [Eclipse Public License 1.0](https://github.com/junit-team/junit4/blob/master/LICENSE-junit.txt)

## Contribute
ToDo: Write

## Other
Author: [@MeilCli](https://github.com/MeilCli)
