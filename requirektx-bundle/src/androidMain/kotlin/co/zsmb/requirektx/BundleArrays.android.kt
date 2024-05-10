@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.os.Parcelable
import android.util.SparseArray
import androidx.core.bundle.Bundle

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireParcelableArray(key: String): Array<Parcelable> = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getParcelableArrayOrNull(key: String): Array<Parcelable>? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun <reified T : Parcelable> Bundle.requireSparseParcelableArray(key: String): SparseArray<T> = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun <reified T : Parcelable> Bundle.getSparseParcelableArrayOrNull(key: String): SparseArray<T>? = getOrNullImpl(key)
