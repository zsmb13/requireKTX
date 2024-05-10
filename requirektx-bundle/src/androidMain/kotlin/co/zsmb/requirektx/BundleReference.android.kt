@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.os.Binder
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import androidx.core.bundle.Bundle
import java.io.Serializable

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun <reified T : Parcelable> Bundle.requireParcelable(key: String): T = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun <reified T : Parcelable> Bundle.getParcelableOrNull(key: String): T? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun <reified T : Serializable> Bundle.requireSerializable(key: String): T = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun <reified T : Serializable> Bundle.getSerializableOrNull(key: String): T? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireSize(key: String): Size = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getSizeOrNull(key: String): Size? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireSizeF(key: String): SizeF = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getSizeFOrNull(key: String): SizeF? = getOrNullImpl(key)

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
public inline fun Bundle.requireBinder(key: String): Binder = requireImpl(key)

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
public inline fun Bundle.getBinderOrNull(key: String): Binder? = getOrNullImpl(key)
