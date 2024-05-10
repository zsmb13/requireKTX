@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.os.Bundle

/**
 * Returns the value associated with the given key.
 *
 * @throws IllegalArgumentException if the key does not exist.
 * @throws IllegalStateException if the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Bundle.requireImpl(key: String): T {
    if (key !in this) {
        throw IllegalArgumentException("Bundle has no key $key")
    }
    return get(key) as? T ?: throw IllegalStateException("Wrong type found in Bundle for key $key")
}

/**
 * Returns the value associated with the given key, or null if the key doesn't exist,
 * or the stored value is of the wrong type.
 */
@PublishedApi
internal inline fun <reified T : Any> Bundle.getOrNullImpl(key: String): T? {
    if (key !in this) {
        return null
    }
    return get(key) as? T?
}

/**
 * Check if [this] Bundle contains the given [key].
 */
@PublishedApi
internal inline operator fun Bundle.contains(key: String): Boolean = containsKey(key)
