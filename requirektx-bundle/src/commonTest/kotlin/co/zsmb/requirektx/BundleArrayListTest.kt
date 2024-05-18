package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import kotlin.test.*

class BundleArrayListTest : RoboTest() {

    private val testBundle = Bundle().apply {
        putIntegerArrayList("int-arraylist", arrayListOf(1, 2, -3))
        putStringArrayList("string-arraylist", arrayListOf("a", "b", "c"))

        // Example for invalid types
        putString("string", "a")
    }

    @Test
    fun testIntegerArrayList() {
        assertEquals(arrayListOf(1, 2, -3), testBundle.getIntegerArrayListOrNull("int-arraylist"))
        assertEquals(null, testBundle.getIntegerArrayListOrNull("string"))
        assertEquals(null, testBundle.getIntegerArrayListOrNull("invalid"))

        assertEquals(arrayListOf(1, 2, -3), testBundle.requireIntegerArrayList("int-arraylist"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireIntegerArrayList("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireIntegerArrayList("string")
        }
    }

    @Test
    fun testStringArrayList() {
        assertEquals(arrayListOf("a", "b", "c"), testBundle.getStringArrayListOrNull("string-arraylist"))
        assertEquals(null, testBundle.getStringArrayListOrNull("string"))
        assertEquals(null, testBundle.getStringArrayListOrNull("invalid"))

        assertEquals(arrayListOf("a", "b", "c"), testBundle.requireStringArrayList("string-arraylist"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireStringArrayList("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireStringArrayList("string")
        }
    }
}
