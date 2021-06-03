@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.content.Intent
import android.os.Parcelable

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireBooleanArrayExtra(key: String): BooleanArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getBooleanArrayExtraOrNull(key: String): BooleanArray? = getBooleanArrayExtra(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireByteArrayExtra(key: String): ByteArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getByteArrayExtraOrNull(key: String): ByteArray? = getByteArrayExtra(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireCharArrayExtra(key: String): CharArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getCharArrayExtraOrNull(key: String): CharArray? = getCharArrayExtra(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireDoubleArrayExtra(key: String): DoubleArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getDoubleArrayExtraOrNull(key: String): DoubleArray? = getDoubleArrayExtra(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireFloatArrayExtra(key: String): FloatArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getFloatArrayExtraOrNull(key: String): FloatArray? = getFloatArrayExtra(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireIntArrayExtra(key: String): IntArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getIntArrayExtraOrNull(key: String): IntArray? = getIntArrayExtra(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireLongArrayExtra(key: String): LongArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getLongArrayExtraOrNull(key: String): LongArray? = getLongArrayExtra(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireShortArrayExtra(key: String): ShortArray = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getShortArrayExtraOrNull(key: String): ShortArray? = getShortArrayExtra(key)


/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireStringArrayExtra(key: String): Array<String> = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getStringArrayExtraOrNull(key: String): Array<String>? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireCharSequenceArrayExtra(key: String): Array<CharSequence> = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getCharSequenceArrayExtraOrNull(key: String): Array<CharSequence>? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireParcelableArrayExtra(key: String): Array<Parcelable> = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getParcelableArrayExtraOrNull(key: String): Array<Parcelable>? = getExtraOrNullImpl(key)
