package co.zsmb.requirektx

import android.location.Location
import android.net.Uri
import androidx.core.bundle.Bundle
import android.util.SparseArray
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
internal class BundleArraysTest {

    // Parcelables
    private val testParcelable1: Uri
        get() = Uri.parse("some/fake/path")
    private val testParcelable2: Location = Location("dummy").apply {
        latitude = 25.832466
        longitude = -70.980690
    }

    private val testSparseParcelable = SparseArray<Uri>().apply { this.put(10, testParcelable1) }

    private val testBundle = Bundle().apply {
        putBooleanArray("boolean-array", booleanArrayOf(true, false, true))
        putByteArray("byte-array", byteArrayOf(1, 2, -3))
        putCharArray("char-array", charArrayOf('a', 'b', 'c'))
        putDoubleArray("double-array", doubleArrayOf(1.0, 2.0, -3.0))
        putFloatArray("float-array", floatArrayOf(1f, 2f, -3f))
        putIntArray("int-array", intArrayOf(1, 2, -3))
        putLongArray("long-array", longArrayOf(1L, 2L, -3L))
        putShortArray("short-array", shortArrayOf(1, 2, -3))

        putStringArray("string-array", arrayOf("a", "b", "c"))
        putCharSequenceArray("charsequence-array", arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence))
        putParcelableArray("parcelable-array", arrayOf(testParcelable1, testParcelable2))
        putSparseParcelableArray("sparse-parcelable-array", testSparseParcelable)

        // Example for invalid types
        putString("string", "a")
    }

    @Test
    fun testBooleanArray() {
        assertArrayEquals(booleanArrayOf(true, false, true), testBundle.getBooleanArrayOrNull("boolean-array"))
        assertArrayEquals(null, testBundle.getBooleanArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getBooleanArrayOrNull("invalid"))

        assertArrayEquals(booleanArrayOf(true, false, true), testBundle.requireBooleanArray("boolean-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireBooleanArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireBooleanArray("string")
        }
    }

    @Test
    fun testByteArray() {
        assertArrayEquals(byteArrayOf(1, 2, -3), testBundle.getByteArrayOrNull("byte-array"))
        assertArrayEquals(null, testBundle.getByteArrayOrNull("int-array"))
        assertArrayEquals(null, testBundle.getByteArrayOrNull("invalid"))

        assertArrayEquals(byteArrayOf(1, 2, -3), testBundle.requireByteArray("byte-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireByteArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireByteArray("string")
        }
    }

    @Test
    fun testCharArray() {
        assertArrayEquals(charArrayOf('a', 'b', 'c'), testBundle.getCharArrayOrNull("char-array"))
        assertArrayEquals(null, testBundle.getCharArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getCharArrayOrNull("invalid"))

        assertArrayEquals(charArrayOf('a', 'b', 'c'), testBundle.requireCharArray("char-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireCharArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireCharArray("string")
        }
    }

    @Test
    fun testDoubleArray() {
        assertArrayEquals(doubleArrayOf(1.0, 2.0, -3.0), testBundle.getDoubleArrayOrNull("double-array"), 0.0)
        assertArrayEquals(null, testBundle.getDoubleArrayOrNull("string"), 0.0)
        assertArrayEquals(null, testBundle.getDoubleArrayOrNull("invalid"), 0.0)

        assertArrayEquals(doubleArrayOf(1.0, 2.0, -3.0), testBundle.requireDoubleArray("double-array"), 0.0)
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireDoubleArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireDoubleArray("string")
        }
    }

    @Test
    fun testFloatArray() {
        assertArrayEquals(floatArrayOf(1f, 2f, -3f), testBundle.getFloatArrayOrNull("float-array"), 0f)
        assertArrayEquals(null, testBundle.getFloatArrayOrNull("string"), 0f)
        assertArrayEquals(null, testBundle.getFloatArrayOrNull("invalid"), 0f)

        assertArrayEquals(floatArrayOf(1f, 2f, -3f), testBundle.requireFloatArray("float-array"), 0f)
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireFloatArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireFloatArray("string")
        }
    }

    @Test
    fun testIntArray() {
        assertArrayEquals(intArrayOf(1, 2, -3), testBundle.getIntArrayOrNull("int-array"))
        assertArrayEquals(null, testBundle.getIntArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getIntArrayOrNull("invalid"))

        assertArrayEquals(intArrayOf(1, 2, -3), testBundle.requireIntArray("int-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireIntArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireIntArray("string")
        }
    }

    @Test
    fun testLongArray() {
        assertArrayEquals(longArrayOf(1L, 2L, -3L), testBundle.getLongArrayOrNull("long-array"))
        assertArrayEquals(null, testBundle.getLongArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getLongArrayOrNull("invalid"))

        assertArrayEquals(longArrayOf(1L, 2L, -3L), testBundle.requireLongArray("long-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireLongArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireLongArray("string")
        }
    }

    @Test
    fun testShortArray() {
        assertArrayEquals(shortArrayOf(1, 2, -3), testBundle.getShortArrayOrNull("short-array"))
        assertArrayEquals(null, testBundle.getShortArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getShortArrayOrNull("invalid"))

        assertArrayEquals(shortArrayOf(1, 2, -3), testBundle.requireShortArray("short-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireShortArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireShortArray("string")
        }
    }

    @Test
    fun testStringArray() {
        assertArrayEquals(arrayOf("a", "b", "c"), testBundle.getStringArrayOrNull("string-array"))
        assertArrayEquals(null, testBundle.getStringArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getStringArrayOrNull("invalid"))

        assertArrayEquals(arrayOf("a", "b", "c"), testBundle.requireStringArray("string-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireStringArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireStringArray("string")
        }
    }

    @Test
    fun testCharSequenceArray() {
        assertArrayEquals(
            arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence),
            testBundle.getCharSequenceArrayOrNull("charsequence-array")
        )
        assertArrayEquals(null, testBundle.getCharSequenceArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getCharSequenceArrayOrNull("invalid"))

        assertArrayEquals(
            arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence),
            testBundle.requireCharSequenceArray("charsequence-array")
        )
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireCharSequenceArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireCharSequenceArray("string")
        }
    }

    @Test
    fun testParcelableArray() {
        assertArrayEquals(arrayOf(testParcelable1, testParcelable2), testBundle.getParcelableArrayOrNull("parcelable-array"))
        assertArrayEquals(null, testBundle.getParcelableArrayOrNull("string"))
        assertArrayEquals(null, testBundle.getParcelableArrayOrNull("invalid"))

        assertArrayEquals(arrayOf(testParcelable1, testParcelable2), testBundle.requireParcelableArray("parcelable-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireParcelableArray("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireParcelableArray("string")
        }
    }

    @Test
    fun testSparseParcelableArray() {
        assertEquals(testSparseParcelable, testBundle.getSparseParcelableArrayOrNull<Uri>("sparse-parcelable-array"))
        assertEquals(null, testBundle.getSparseParcelableArrayOrNull<Uri>("string"))
        assertEquals(null, testBundle.getSparseParcelableArrayOrNull<Uri>("invalid"))

        assertEquals(testSparseParcelable, testBundle.requireSparseParcelableArray<Uri>("sparse-parcelable-array"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireSparseParcelableArray<Uri>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireSparseParcelableArray<Uri>("string")
        }
    }
}
