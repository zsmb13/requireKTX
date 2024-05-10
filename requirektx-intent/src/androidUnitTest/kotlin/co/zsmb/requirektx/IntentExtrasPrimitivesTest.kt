package co.zsmb.requirektx

import android.content.Intent
import android.location.Location
import android.net.Uri
import android.os.Bundle
import org.junit.Assert
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.lang.Exception
import java.util.Calendar
import java.util.UUID

@RunWith(RobolectricTestRunner::class)
internal class IntentExtrasPrimitivesTest {

    private val testIntent = Intent().apply {
        putExtra("boolean", true)
        putExtra("byte", 1.toByte())
        putExtra("char", 'a')
        putExtra("double", 1.0)
        putExtra("float", 1f)
        putExtra("long", 1L)
        putExtra("int", 1)
        putExtra("short", 1.toShort())

        // Example for invalid types
        putExtra("string", "a")
    }

    @Test
    fun testBoolean() {
        assertEquals(true, testIntent.getBooleanExtraOrNull("boolean"))
        assertEquals(null, testIntent.getBooleanExtraOrNull("string"))
        assertEquals(null, testIntent.getBooleanExtraOrNull("invalid"))

        assertEquals(true, testIntent.requireBooleanExtra("boolean"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireBooleanExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireBooleanExtra("string")
        }
    }

    @Test
    fun testByte() {
        assertEquals(1.toByte(), testIntent.getByteExtraOrNull("byte"))
        assertEquals(null, testIntent.getByteExtraOrNull("string"))
        assertEquals(null, testIntent.getByteExtraOrNull("invalid"))

        assertEquals(1.toByte(), testIntent.requireByteExtra("byte"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireByteExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireByteExtra("string")
        }
    }

    @Test
    fun testChar() {
        assertEquals('a', testIntent.getCharExtraOrNull("char"))
        assertEquals(null, testIntent.getCharExtraOrNull("string"))
        assertEquals(null, testIntent.getCharExtraOrNull("invalid"))

        assertEquals('a', testIntent.requireCharExtra("char"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireCharExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireCharExtra("string")
        }
    }

    @Test
    fun testDouble() {
        assertEquals(1.0, testIntent.getDoubleExtraOrNull("double"))
        assertEquals(null, testIntent.getDoubleExtraOrNull("string"))
        assertEquals(null, testIntent.getDoubleExtraOrNull("invalid"))

        assertEquals(1.0, testIntent.requireDoubleExtra("double"), 0.0)
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireDoubleExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireDoubleExtra("string")
        }
    }

    @Test
    fun testFloat() {
        assertEquals(1f, testIntent.getFloatExtraOrNull("float"))
        assertEquals(null, testIntent.getFloatExtraOrNull("string"))
        assertEquals(null, testIntent.getFloatExtraOrNull("invalid"))

        assertEquals(1f, testIntent.requireFloatExtra("float"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireFloatExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireFloatExtra("string")
        }
    }

    @Test
    fun testInt() {
        assertEquals(1, testIntent.getIntExtraOrNull("int"))
        assertEquals(null, testIntent.getIntExtraOrNull("string"))
        assertEquals(null, testIntent.getIntExtraOrNull("invalid"))

        assertEquals(1, testIntent.requireIntExtra("int"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireIntExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireIntExtra("string")
        }
    }

    @Test
    fun testLong() {
        assertEquals(1L, testIntent.getLongExtraOrNull("long"))
        assertEquals(null, testIntent.getLongExtraOrNull("string"))
        assertEquals(null, testIntent.getLongExtraOrNull("invalid"))

        assertEquals(1L, testIntent.requireLongExtra("long"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireLongExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireLongExtra("string")
        }
    }

    @Test
    fun testShort() {
        assertEquals(1.toShort(), testIntent.getShortExtraOrNull("short"))
        assertEquals(null, testIntent.getShortExtraOrNull("string"))
        assertEquals(null, testIntent.getShortExtraOrNull("invalid"))

        assertEquals(1.toShort(), testIntent.requireShortExtra("short"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireShortExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireShortExtra("string")
        }
    }

}
