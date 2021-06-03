package co.zsmb.requirektx

import android.content.Intent
import android.location.Location
import android.net.Uri
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class IntentExtrasArraysTest {

    // Parcelables
    private val testParcelable1: Uri
        get() = Uri.parse("some/fake/path")
    private val testParcelable2: Location = Location("dummy").apply {
        latitude = 25.832466
        longitude = -70.980690
    }

    private val testIntent = Intent().apply {
        putExtra("boolean-array", booleanArrayOf(true, false, true))
        putExtra("byte-array", byteArrayOf(1, 2, -3))
        putExtra("char-array", charArrayOf('a', 'b', 'c'))
        putExtra("double-array", doubleArrayOf(1.0, 2.0, -3.0))
        putExtra("float-array", floatArrayOf(1f, 2f, -3f))
        putExtra("int-array", intArrayOf(1, 2, -3))
        putExtra("long-array", longArrayOf(1L, 2L, -3L))
        putExtra("short-array", shortArrayOf(1, 2, -3))

        putExtra("string-array", arrayOf("a", "b", "c"))
        putExtra("charsequence-array", arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence))
        putExtra("parcelable-array", arrayOf(testParcelable1, testParcelable2))

        // Example for invalid types
        putExtra("string", "a")
    }

    @Test
    fun testBooleanArray() {
        assertArrayEquals(booleanArrayOf(true, false, true), testIntent.getBooleanArrayExtraOrNull("boolean-array"))
        assertArrayEquals(null, testIntent.getBooleanArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getBooleanArrayExtraOrNull("invalid"))

        assertArrayEquals(booleanArrayOf(true, false, true), testIntent.requireBooleanArrayExtra("boolean-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireBooleanArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireBooleanArrayExtra("string")
        }
    }

    @Test
    fun testByteArray() {
        assertArrayEquals(byteArrayOf(1, 2, -3), testIntent.getByteArrayExtraOrNull("byte-array"))
        assertArrayEquals(null, testIntent.getByteArrayExtraOrNull("int-array"))
        assertArrayEquals(null, testIntent.getByteArrayExtraOrNull("invalid"))

        assertArrayEquals(byteArrayOf(1, 2, -3), testIntent.requireByteArrayExtra("byte-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireByteArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireByteArrayExtra("string")
        }
    }

    @Test
    fun testCharArray() {
        assertArrayEquals(charArrayOf('a', 'b', 'c'), testIntent.getCharArrayExtraOrNull("char-array"))
        assertArrayEquals(null, testIntent.getCharArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getCharArrayExtraOrNull("invalid"))

        assertArrayEquals(charArrayOf('a', 'b', 'c'), testIntent.requireCharArrayExtra("char-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireCharArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireCharArrayExtra("string")
        }
    }

    @Test
    fun testDoubleArray() {
        assertArrayEquals(doubleArrayOf(1.0, 2.0, -3.0), testIntent.getDoubleArrayExtraOrNull("double-array"), 0.0)
        assertArrayEquals(null, testIntent.getDoubleArrayExtraOrNull("string"), 0.0)
        assertArrayEquals(null, testIntent.getDoubleArrayExtraOrNull("invalid"), 0.0)

        assertArrayEquals(doubleArrayOf(1.0, 2.0, -3.0), testIntent.requireDoubleArrayExtra("double-array"), 0.0)
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireDoubleArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireDoubleArrayExtra("string")
        }
    }

    @Test
    fun testFloatArray() {
        assertArrayEquals(floatArrayOf(1f, 2f, -3f), testIntent.getFloatArrayExtraOrNull("float-array"), 0f)
        assertArrayEquals(null, testIntent.getFloatArrayExtraOrNull("string"), 0f)
        assertArrayEquals(null, testIntent.getFloatArrayExtraOrNull("invalid"), 0f)

        assertArrayEquals(floatArrayOf(1f, 2f, -3f), testIntent.requireFloatArrayExtra("float-array"), 0f)
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireFloatArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireFloatArrayExtra("string")
        }
    }

    @Test
    fun testIntArray() {
        assertArrayEquals(intArrayOf(1, 2, -3), testIntent.getIntArrayExtraOrNull("int-array"))
        assertArrayEquals(null, testIntent.getIntArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getIntArrayExtraOrNull("invalid"))

        assertArrayEquals(intArrayOf(1, 2, -3), testIntent.requireIntArrayExtra("int-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireIntArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireIntArrayExtra("string")
        }
    }

    @Test
    fun testLongArray() {
        assertArrayEquals(longArrayOf(1L, 2L, -3L), testIntent.getLongArrayExtraOrNull("long-array"))
        assertArrayEquals(null, testIntent.getLongArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getLongArrayExtraOrNull("invalid"))

        assertArrayEquals(longArrayOf(1L, 2L, -3L), testIntent.requireLongArrayExtra("long-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireLongArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireLongArrayExtra("string")
        }
    }

    @Test
    fun testShortArray() {
        assertArrayEquals(shortArrayOf(1, 2, -3), testIntent.getShortArrayExtraOrNull("short-array"))
        assertArrayEquals(null, testIntent.getShortArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getShortArrayExtraOrNull("invalid"))

        assertArrayEquals(shortArrayOf(1, 2, -3), testIntent.requireShortArrayExtra("short-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireShortArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireShortArrayExtra("string")
        }
    }

    @Test
    fun testStringArray() {
        assertArrayEquals(arrayOf("a", "b", "c"), testIntent.getStringArrayExtraOrNull("string-array"))
        assertArrayEquals(null, testIntent.getStringArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getStringArrayExtraOrNull("invalid"))

        assertArrayEquals(arrayOf("a", "b", "c"), testIntent.requireStringArrayExtra("string-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireStringArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireStringArrayExtra("string")
        }
    }

    @Test
    fun testCharSequenceArray() {
        assertArrayEquals(
            arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence),
            testIntent.getCharSequenceArrayExtraOrNull("charsequence-array")
        )
        assertArrayEquals(null, testIntent.getCharSequenceArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getCharSequenceArrayExtraOrNull("invalid"))

        assertArrayEquals(
            arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence),
            testIntent.requireCharSequenceArrayExtra("charsequence-array")
        )
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireCharSequenceArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireCharSequenceArrayExtra("string")
        }
    }

    @Test
    fun testParcelableArray() {
        assertArrayEquals(arrayOf(testParcelable1, testParcelable2), testIntent.getParcelableArrayExtraOrNull("parcelable-array"))
        assertArrayEquals(null, testIntent.getParcelableArrayExtraOrNull("string"))
        assertArrayEquals(null, testIntent.getParcelableArrayExtraOrNull("invalid"))

        assertArrayEquals(arrayOf(testParcelable1, testParcelable2), testIntent.requireParcelableArrayExtra("parcelable-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireParcelableArrayExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireParcelableArrayExtra("string")
        }
    }
}
