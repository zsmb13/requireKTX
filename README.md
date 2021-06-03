# requireKTX

**requireKTX** is a collection of small utility functions to make it easier to deal with some otherwise nullable APIs on Android, using the same idea as [`requireContext`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireContext()), [`requireArguments`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireArguments()), and other similar Android SDK methods.

Types that requireKTX provides extensions for:

- [Bundle](#bundle)
- [Intent](#intent)
- [NavBackStackEntry](#navbackstackentry)
- [WorkManager Data](#workmanager-data)

### Why?

Take the example of grabbing a Fragment argument bundle and reading a String ID from it that should always be there: you have two choices, and none of them are great: 

```kotlin
// Providing no default value
// Results in a nullable return type, caller has to do null handling
val id: String = requireArguments().getString("user_id")!!

// Providing a (meaningless) default value
// Results in a platform return type, caller has to explicitly type as non-null
val id: String = requireArguments().getString("user_id", "")
if (id == "") { ... } // ... and check to avoid accidentally using the default value
```

requireKTX provides methods such as `requireString` so that you can demand that a value be there, or otherwise get an exception:

```kotlin
val id: String = requireArguments().requireString("user_id")
```

These methods in the library will throw meaningful exceptions based on the error that occurred - see the method docs for details.

---

To make the nullable case more obvious and explicit, requireKTX also includes `getOrNull` style methods for everything that it covers with `require` style methods. These match the conventions of the Kotlin Standard Library, and can make it clearer that `null` is returned if a value for a key couldn't be fetched.

```kotlin
val userId: String? = requireArguments().getStringOrNull("user_id")
``` 

### Dependencies

requireKTX is available from MavenCentral.

```groovy
repositories {
    mavenCentral()
}
```

It's available in several artifacts which you can import depending on which types you want to get extensions for - see the module descriptions below for more info:

```groovy
dependencies {
    implementation "co.zsmb:requirektx-bundle:1.1.0"
    implementation "co.zsmb:requirektx-intent:1.1.0"
    implementation "co.zsmb:requirektx-navigation:1.1.0"
    implementation "co.zsmb:requirektx-work:1.1.0"
}
```

### Bundle

Given a `Bundle`, you can require the following types of values:

```
bundle.requireBoolean()
bundle.requireInt()
bundle.requireLong()
bundle.requireString()
bundle.requireParcelable()
bundle.requireSerializable()
```

### Intent

Given a `Intent`, you can require its extras `Bundle` (and then require values from it as seen above):

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

... and more!

### NavBackStackEntry

The navigation module provides an extension to require the arguments of a `NavBackStackEntry`, same as you could do for a `Fragment`:

```kotlin
val args: Bundle = navBackStackEntry.requireArguments()
```

### WorkManager Data

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

### License

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
