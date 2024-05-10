@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import androidx.work.Data

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireBoolean(key: String): Boolean = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getBooleanOrNull(key: String): Boolean? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireByte(key: String): Byte = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getByteOrNull(key: String): Byte? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireDouble(key: String): Double = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getDoubleOrNull(key: String): Double? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireFloat(key: String): Float = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getFloatOrNull(key: String): Float? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireInt(key: String): Int = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getIntOrNull(key: String): Int? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireLong(key: String): Long = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getLongOrNull(key: String): Long? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Data.requireString(key: String): String = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Data.getStringOrNull(key: String): String? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Data.requireImpl(key: String): T {
    val value = this.keyValueMap[key] ?: throw IllegalArgumentException("Data has no key $key")
    return value as? T ?: throw IllegalStateException("Wrong type found in Data for key $key")
}

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Data.getOrNullImpl(key: String): T? = keyValueMap[key] as? T
