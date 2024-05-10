@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.content.Intent
import androidx.core.bundle.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireStringExtra(key: String): String = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getStringExtraOrNull(key: String): String? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireBundleExtra(key: String): Bundle = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getBundleExtraOrNull(key: String): Bundle? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun Intent.requireCharSequenceExtra(key: String): CharSequence = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun Intent.getCharSequenceExtraOrNull(key: String): CharSequence? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun <reified T: Parcelable> Intent.requireParcelableExtra(key: String): T = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun <reified T: Parcelable> Intent.getParcelableExtraOrNull(key: String): T? = getExtraOrNullImpl(key)

/**
 * Returns the extra associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored extra is of the wrong type.
 */
public inline fun <reified T: Serializable> Intent.requireSerializableExtra(key: String): T = requireExtraImpl(key)

/**
 * Returns the extra associated with the given key, or null if the key doesn't exist,
 * or the extra is of the wrong type.
 */
public inline fun <reified T: Serializable> Intent.getSerializableExtraOrNull(key: String): T? = getExtraOrNullImpl(key)
