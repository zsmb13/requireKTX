package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NavBackStackEntryTest {
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
//            putString("hello", "world")
//            putInt("answer", 42)
        }

        val entry = createNavBackstackEntry(arguments = argBundle)

        assertEquals(argBundle.keySet(), entry.requireArguments().keySet())
    }
}
