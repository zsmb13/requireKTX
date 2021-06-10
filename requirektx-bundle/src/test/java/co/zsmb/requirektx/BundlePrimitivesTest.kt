package co.zsmb.requirektx

import android.os.Bundle
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class BundlePrimitivesTest {

    private val testBundle = Bundle().apply {
        putBoolean("boolean", true)
        putByte("byte", 1.toByte())
        putChar("char", 'a')
        putDouble("double", 1.0)
        putFloat("float", 1f)
        putLong("long", 1L)
        putInt("int", 1)
        putShort("short", 1.toShort())

        // Example for invalid types
        putString("string", "a")
    }

    @Test
    fun testBoolean() {
        assertEquals(true, testBundle.getBooleanOrNull("boolean"))
        assertEquals(null, testBundle.getBooleanOrNull("string"))
        assertEquals(null, testBundle.getBooleanOrNull("invalid"))

        assertEquals(true, testBundle.requireBoolean("boolean"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireBoolean("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireBoolean("string")
        }
    }

    @Test
    fun testByte() {
        assertEquals(1.toByte(), testBundle.getByteOrNull("byte"))
        assertEquals(null, testBundle.getByteOrNull("string"))
        assertEquals(null, testBundle.getByteOrNull("invalid"))

        assertEquals(1.toByte(), testBundle.requireByte("byte"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireByte("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireByte("string")
        }
    }

    @Test
    fun testChar() {
        assertEquals('a', testBundle.getCharOrNull("char"))
        assertEquals(null, testBundle.getCharOrNull("string"))
        assertEquals(null, testBundle.getCharOrNull("invalid"))

        assertEquals('a', testBundle.requireChar("char"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireChar("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireChar("string")
        }
    }

    @Test
    fun testDouble() {
        assertEquals(1.0, testBundle.getDoubleOrNull("double"))
        assertEquals(null, testBundle.getDoubleOrNull("string"))
        assertEquals(null, testBundle.getDoubleOrNull("invalid"))

        assertEquals(1.0, testBundle.requireDouble("double"), 0.0)
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireDouble("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireDouble("string")
        }
    }

    @Test
    fun testFloat() {
        assertEquals(1f, testBundle.getFloatOrNull("float"))
        assertEquals(null, testBundle.getFloatOrNull("string"))
        assertEquals(null, testBundle.getFloatOrNull("invalid"))

        assertEquals(1f, testBundle.requireFloat("float"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireFloat("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireFloat("string")
        }
    }

    @Test
    fun testInt() {
        assertEquals(1, testBundle.getIntOrNull("int"))
        assertEquals(null, testBundle.getIntOrNull("string"))
        assertEquals(null, testBundle.getIntOrNull("invalid"))

        assertEquals(1, testBundle.requireInt("int"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireInt("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireInt("string")
        }
    }

    @Test
    fun testLong() {
        assertEquals(1L, testBundle.getLongOrNull("long"))
        assertEquals(null, testBundle.getLongOrNull("string"))
        assertEquals(null, testBundle.getLongOrNull("invalid"))

        assertEquals(1L, testBundle.requireLong("long"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireLong("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireLong("string")
        }
    }

    @Test
    fun testShort() {
        assertEquals(1.toShort(), testBundle.getShortOrNull("short"))
        assertEquals(null, testBundle.getShortOrNull("string"))
        assertEquals(null, testBundle.getShortOrNull("invalid"))

        assertEquals(1.toShort(), testBundle.requireShort("short"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireShort("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireShort("string")
        }
    }

}
