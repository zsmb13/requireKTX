@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.content.Intent

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireBooleanExtra(key: String): Boolean = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getBooleanExtraOrNull(key: String): Boolean? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireByteExtra(key: String): Byte = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getByteExtraOrNull(key: String): Byte? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireCharExtra(key: String): Char = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getCharExtraOrNull(key: String): Char? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireDoubleExtra(key: String): Double = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getDoubleExtraOrNull(key: String): Double? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireFloatExtra(key: String): Float = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getFloatExtraOrNull(key: String): Float? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireIntExtra(key: String): Int = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getIntExtraOrNull(key: String): Int? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireLongExtra(key: String): Long = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getLongExtraOrNull(key: String): Long? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireShortExtra(key: String): Short = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getShortExtraOrNull(key: String): Short? = getExtraOrNullImpl(key)
