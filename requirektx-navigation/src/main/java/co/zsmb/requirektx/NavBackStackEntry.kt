@file:Suppress("NOTHING_TO_INLINE")

package co.zsmb.requirektx

import android.os.Bundle
import androidx.navigation.NavBackStackEntry

/**
 * Returns the arguments stored in [this] back stack entry.
 *
 * @throws IllegalStateException If no arguments were supplied during navigation.
 */
public inline fun NavBackStackEntry.requireArguments(): Bundle {
    return checkNotNull(arguments) { "NavBackStackEntry $this does not have any arguments." }
}
