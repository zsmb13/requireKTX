package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination

actual fun createNavBackstackEntry(
    arguments: Bundle?
): NavBackStackEntry = NavBackStackEntry.create(
    destination = NavDestination(""),
    arguments = arguments
)
