@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.content.Intent
import androidx.core.bundle.Bundle

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalStateException if no extras are present.
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Intent.requireExtraImpl(key: String): T {
    val extras = checkNotNull(extras) { "Intent has no extras" }
    if (!extras.containsKey(key)) {
        throw IllegalArgumentException("Intent extras has no key $key")
    }
    @Suppress("DEPRECATION")
    return extras[key] as? T ?: throw IllegalStateException("Wrong type found in Intent for key $key")
}

/**
 * Returns the value associated with the given key, or null if the extras aren't present,
 * the key doesn't exist, or the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Intent.getExtraOrNullImpl(key: String): T? {
    @Suppress("DEPRECATION")
    return extras?.get(key) as? T?
}
