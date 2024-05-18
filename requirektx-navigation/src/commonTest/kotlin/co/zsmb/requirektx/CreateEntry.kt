package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import androidx.navigation.NavBackStackEntry

expect fun createNavBackstackEntry(arguments: Bundle?): NavBackStackEntry
