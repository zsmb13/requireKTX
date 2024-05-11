# requireKTX

**requireKTX** is a collection of small utility functions to make it easier to deal with some otherwise nullable APIs on Android and Kotlin Multiplatform, in the style of [`requireContext`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireContext()), [`requireArguments`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireArguments()), and other similar Android SDK methods.

Types that requireKTX provides extensions for:

- [Bundle](#bundle) (Kotlin Multiplatform)
- [NavBackStackEntry](#navbackstackentry) (Kotlin Multiplatform)
- [Intent](#intent) (Android)
- [WorkManager Data](#workmanager-data) (Android)

## Why?

Take the example of grabbing a Bundle and reading a String ID from it that should always be there: the Bundle APIs give you a nullable result, which means you'll have to do some kind of null handling.

```kotlin
val id: String = argumentBundle.getString("user_id")!!
```

The exception potentially thrown by this code also won't be too helpful in tracking down the problem, as it won't tell you details such as whether the value was missing, or if it was the wrong type for the request.

Instead of using these methods, requireKTX provides extensions such as `requireString`, which you can use to *require* a value that must always be there. These methods give you non-nullable return types.

```kotlin
val id: String = argumentBundle.requireString("user_id")
```

If the value isn't available, these methods throw meaningful exceptions based on the error that occurred - see the method docs for details.

### getOrNull

requireKTX **also includes `getOrNull` style methods for everything that it covers with `require` style methods**,to make the nullable case more obvious and explicit. These match the conventions of the Kotlin Standard Library, and can make it clearer that `null` is returned if a value for a key couldn't be fetched.

```kotlin
val userId: String? = requireArguments().getStringOrNull("user_id")
``` 

## Dependencies

requireKTX is available from MavenCentral.

```kotlin
repositories {
    mavenCentral()
}
```

It's available in several artifacts which you can import depending on which types you want to get extensions for - see the module descriptions below for more info.

```kotlin
dependencies {
    // commonMain or Android
    implementation("co.zsmb:requirektx-bundle:2.0.0-alpha01")
    implementation("co.zsmb:requirektx-navigation:2.0.0-alpha01")

    // Android only
    implementation("co.zsmb:requirektx-intent:2.0.0-alpha01")
    implementation("co.zsmb:requirektx-work:2.0.0-alpha01")
}
```

## Available modules and extensions

### Bundle

*The `requirektx-bundle` artifact works with the `androidx.core.bundle.Bundle` type, available on Android and other Kotlin Multiplatform targets from `org.jetbrains.androidx.core:core-bundle`.*

Given a `Bundle`, you can require the following types of values:

```kotlin
// Primitives (examples)
bundle.requireBoolean()
bundle.requireByte()
bundle.requireChar()
bundle.requireDouble()
bundle.requireFloat()

// Reference types
bundle.requireString()
bundle.requireBundle()
bundle.requireCharSequence()
bundle.requireParcelable()
bundle.requireSerializable()

// Arrays (examples)
bundle.requireBooleanArray()
bundle.requireByteArray()
bundle.requireCharArray()
bundle.requireDoubleArray()
bundle.requireFloatArray()
```

... and many more!

### NavBackStackEntry

*The `requirektx-navigation` artifact works with the `androidx.navigation.NavBackStackEntry` type, available on Android and other Kotlin Multiplatform targets from `org.jetbrains.androidx.navigation:navigation-runtime`.*

*This is compatible with both the [Jetpack Navigaton component on Android](https://developer.android.com/guide/navigation) (with or without Compose) and the [Compose Multiplatform navigation library](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-navigation-routing.html).*

To get

```kotlin
val args: Bundle = navBackStackEntry.requireArguments()
```

An example of using this with Compose, in combination with the [Bundle extensions](#bundle):

```kotlin
composable("detail/{objectId}") { backStackEntry ->
    val args = backStackEntry.requireArguments()
    val objectId = args.requireInt("objectId")
    DetailScreen(navController, objectId)
}
```

### Intent

*The `requirektx-intent` artifact works with the [`android.content.Intent`](https://developer.android.com/reference/android/content/Intent) type, available on Android only.*

Given an `Intent`, you can require its extras `Bundle` (and then require values from it as seen above):

```kotlin
val extras: Bundle = intent.requireExtras()
```

Or you can require specific extras directly for various types of values:

```kotlin
// Primitives (examples)
intent.requireBooleanExtra()
intent.requireByteExtra()
intent.requireCharExtra()
intent.requireDoubleExtra()
intent.requireFloatExtra()

// Reference types
intent.requireStringExtra()
intent.requireBundleExtra()
intent.requireCharSequenceExtra()
intent.requireParcelableExtra()
intent.requireSerializableExtra()

// Arrays (examples)
intent.requireBooleanArrayExtra()
intent.requireByteArrayExtra()
intent.requireCharArrayExtra()
intent.requireDoubleArrayExtra()
intent.requireFloatArrayExtra()
```

... and many more!

### WorkManager Data

*The `requirektx-work` artifact provides extensions for the [`androidx.work.Data`](https://developer.android.com/reference/androidx/work/Data) type, available on Android only.*

Given a WorkManager `Data` object (such as `inputData` inside a worker), you can require the following types of values:

```kotlin
class SomeWorker : Worker() {
    override fun doWork(): Result {
        // Values
        inputData.requireBoolean()
        inputData.requireByte()
        inputData.requireDouble()
        inputData.requireFloat()
        inputData.requireInt()
        inputData.requireLong()
        inputData.requireString()

        // Arrays
        inputData.requireBooleanArray()
        inputData.requireByteArray()
        inputData.requireDoubleArray()
        inputData.requireFloatArray()
        inputData.requireIntArray()
        inputData.requireLongArray()
        inputData.requireStringArray()

        // ...
    }
}
```

## License

    Copyright 2021 Márton Braun

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
