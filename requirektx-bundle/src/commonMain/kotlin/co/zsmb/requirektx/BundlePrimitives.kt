@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import androidx.core.bundle.Bundle

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireBoolean(key: String): Boolean = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getBooleanOrNull(key: String): Boolean? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireByte(key: String): Byte = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getByteOrNull(key: String): Byte? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireChar(key: String): Char = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getCharOrNull(key: String): Char? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireDouble(key: String): Double = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getDoubleOrNull(key: String): Double? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireFloat(key: String): Float = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getFloatOrNull(key: String): Float? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireInt(key: String): Int = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getIntOrNull(key: String): Int? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireLong(key: String): Long = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getLongOrNull(key: String): Long? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireShort(key: String): Short = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getShortOrNull(key: String): Short? = getOrNullImpl(key)
