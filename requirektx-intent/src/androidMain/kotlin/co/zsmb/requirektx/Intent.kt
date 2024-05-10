@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.content.Intent
import androidx.core.bundle.Bundle

/**
 * Returns the extras of [this] Intent.
 *
 * @throws IllegalStateException If the Intent has no extras.
 */
public inline fun Intent.requireExtras(): Bundle {
    return checkNotNull(extras) { "Intent $this does not have any arguments." }
}
