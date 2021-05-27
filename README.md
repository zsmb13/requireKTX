# requireKTX

**requireKTX** is a collection of small utility functions to make it easier to deal with some otherwise nullable APIs on Android, using the same idea as [`requireContext`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireContext()), [`requireArguments`](https://developer.android.com/reference/androidx/fragment/app/Fragment.html#requireArguments()), and other similar Android SDK methods.

Take the example of grabbing a Fragment argument bundle and reading a String ID from it that should always be there: you have two choices, and none of them are great: 

```kotlin
// Nullable return type, have to do null handling
val id: String = requireArguments().getString(ARG_ID_KEY)!!

// Platform return type, have to explicitly type as non-null, plus provide a meaningless 
// default value that should never be used 
val id: String = requireArguments().getString(ARG_ID_KEY, "")
if (id == "") { ... } // ... and check that you didn't accidentally use the default value
```

With requireKTX, you can demand that a value be there, or otherwise just get an exception:

```kotlin
val id: String = requireArguments().requireString(ARG_ID_KEY)
```

These methods in the library will throw an `IllegalArgumentException` if the key is missing, and an `IllegalStateException` if the key is present, but the value associated with it is not the expected type.

---

To make the nullable case more obvious and explicit, requireKTX also includes `getOrNull` style methods for everything that it covers with `require` style methods. These match the conventions of the Kotlin standard library, and can make it easier to express that you want to get a `null` value if a value for a key couldn't be fetched (doesn't exist, or is the wrong type).

```kotlin
val userId: String? = requireArguments().getStringOrNull(ARG_USERID_KEY)
``` 

### Bundles

TODO

### NavBackStackEntry

TODO

### WorkManager Data

TODO
