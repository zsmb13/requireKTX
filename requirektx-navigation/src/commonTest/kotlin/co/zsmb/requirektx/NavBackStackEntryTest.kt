package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NavBackStackEntryTest : RoboTest() {
    @Test
    fun testMissingArgs() {
        val entry = createNavBackstackEntry(arguments = null)

        assertFailsWith<IllegalStateException> {
            entry.requireArguments()
        }
    }

    @Test
    fun testPresentArgs() {
        val argBundle = Bundle().apply {
            putString("hello", "world")
            putInt("answer", 42)
        }

        val entry = createNavBackstackEntry(arguments = argBundle)

        val args = entry.requireArguments()

        assertEquals(argBundle.keySet(), args.keySet())
        argBundle.keySet().forEach { key ->
            @Suppress("DEPRECATION")
            assertEquals(argBundle[key], args[key])
        }
    }
}
