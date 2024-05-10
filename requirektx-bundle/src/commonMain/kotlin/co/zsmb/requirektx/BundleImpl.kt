@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import androidx.core.bundle.Bundle

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Bundle.requireImpl(key: String): T {
    if (!this.containsKey(key)) {
        throw IllegalArgumentException("Bundle has no key $key")
    }
    @Suppress("DEPRECATION")
    return get(key) as? T ?: throw IllegalStateException("Wrong type found in Bundle for key $key")
}

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Bundle.getOrNullImpl(key: String): T? {
    if (!this.containsKey(key)) {
        return null
    }
    @Suppress("DEPRECATION")
    return get(key) as? T?
}
