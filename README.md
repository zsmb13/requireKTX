# requireKTX

**requireKTX** is a collection of small utility functions to make it easier to deal with some otherwise nullable APIs on Android, using the same idea as [`requireContext`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireContext()), [`requireArguments`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireArguments()), and other similar Android SDK methods.

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

TODO

### Intent

TODO

### NavBackStackEntry

TODO

### WorkManager Data

TODO
