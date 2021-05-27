@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import androidx.work.Data

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getBooleanArrayOrNull(key: String): BooleanArray? = getBooleanArray(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getByteArrayOrNull(key: String): ByteArray? = getByteArray(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getDoubleArrayOrNull(key: String): DoubleArray? = getDoubleArray(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getFloatArrayOrNull(key: String): FloatArray? = getFloatArray(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getIntArrayOrNull(key: String): IntArray? = getIntArray(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getLongArrayOrNull(key: String): LongArray? = getLongArray(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getStringArrayOrNull(key: String): Array<String>? = getStringArray(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireBooleanArray(key: String): BooleanArray {
    return requireArrayImpl(key, { isArrayOf<Boolean>() }, Array<Boolean>::toBooleanArray)
}

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireByteArray(key: String): ByteArray {
    return requireArrayImpl(key, { isArrayOf<Byte>() }, Array<Byte>::toByteArray)
}

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireDoubleArray(key: String): DoubleArray {
    return requireArrayImpl(key, { isArrayOf<Double>() }, Array<Double>::toDoubleArray)
}

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireFloatArray(key: String): FloatArray {
    return requireArrayImpl(key, { isArrayOf<Float>() }, Array<Float>::toFloatArray)
}

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireIntArray(key: String): IntArray {
    return requireArrayImpl(key, { isArrayOf<Int>() }, Array<Int>::toIntArray)
}

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireLongArray(key: String): LongArray {
    return requireArrayImpl(key, { isArrayOf<Long>() }, Array<Long>::toLongArray)
}

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireStringArray(key: String): Array<String> {
    return requireArrayImpl<String, Array<String>>(key, { isArrayOf<String>() }, { this })
}

/**
 * Returns the value associated with the given key.
 *
 * Uses [arrayTypeCheck] to verify that the array is of the correct type, and applies
 * [transform] to map it to the required primitive array return type.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any, A : Any> Data.requireArrayImpl(
    key: String,
    arrayTypeCheck: Array<*>.() -> Boolean,
    transform: Array<T>.() -> A,
): A {
    val value = keyValueMap[key] ?: throw IllegalArgumentException("Data has no key $key")
    if (value !is Array<*> || !arrayTypeCheck(value)) {
        throw IllegalStateException("Wrong type found in Data for key $key")
    }
    @Suppress("UNCHECKED_CAST")
    return (value as Array<T>).transform()
}
