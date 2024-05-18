@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import android.os.Parcelable

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireParcelableArrayList(key: String): ArrayList<Parcelable> = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getParcelableArrayListOrNull(key: String): ArrayList<Parcelable>? = getOrNullImpl(key)
