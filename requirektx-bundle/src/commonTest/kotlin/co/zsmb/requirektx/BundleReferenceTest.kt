package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BundleReferenceTest : RoboTest() {

    private val testNestedBundle = Bundle().apply { putString("key", "value") }

    private val testBundle = Bundle().apply {
        putString("string", "a")
        putCharSequence("charsequence", "b" as CharSequence)
        putBundle("bundle", testNestedBundle)

        // Produces a java.lang.NoSuchMethodError
//        putBinder("binder", testBinder)
//        putSize("size", Size(10, 20))
//        putSizeF("sizef", SizeF(30f, 40f))

        // Example for invalid types
        putInt("int", 1)
    }

    @Test
    fun testString() {
        assertEquals("a", testBundle.getStringOrNull("string"))
        assertEquals(null, testBundle.getStringOrNull("int"))
        assertEquals(null, testBundle.getStringOrNull("invalid"))

        assertEquals("a", testBundle.requireString("string"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireString("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireString("int")
        }
    }

    @Test
    fun testCharSequence() {
        assertEquals("b", testBundle.getCharSequenceOrNull("charsequence"))
        assertEquals(null, testBundle.getCharSequenceOrNull("int"))
        assertEquals(null, testBundle.getCharSequenceOrNull("invalid"))

        assertEquals("b", testBundle.requireCharSequence("charsequence"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireCharSequence("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireCharSequence("int")
        }
    }

    @Test
    fun testBundle() {
        assertEquals(testNestedBundle, testBundle.getBundleOrNull("bundle"))
        assertEquals(null, testBundle.getBundleOrNull("int"))
        assertEquals(null, testBundle.getBundleOrNull("invalid"))

        assertEquals(testNestedBundle, testBundle.requireBundle("bundle"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireBundle("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireBundle("int")
        }
    }
}
