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
public inline fun Intent.requireIntegerArrayListExtra(key: String): ArrayList<Int> = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getIntegerArrayListExtraOrNull(key: String): ArrayList<Int>? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireParcelableArrayListExtra(key: String): ArrayList<Parcelable> = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getParcelableArrayListExtraOrNull(key: String): ArrayList<Parcelable>? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireCharSequenceArrayListExtra(key: String): ArrayList<CharSequence> = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getCharSequenceArrayListExtraOrNull(key: String): ArrayList<CharSequence>? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireStringArrayListExtra(key: String): ArrayList<String> = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getStringArrayListExtraOrNull(key: String): ArrayList<String>? = getExtraOrNullImpl(key)
