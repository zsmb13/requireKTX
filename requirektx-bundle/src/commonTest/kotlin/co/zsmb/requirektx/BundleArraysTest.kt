package co.zsmb.requirektx

import androidx.core.bundle.Bundle
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith

class BundleArraysTest : RoboTest() {

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

        // Example for invalid types
        putString("string", "a")
    }

    @Test
    fun testBooleanArray() {
        assertContentEquals(booleanArrayOf(true, false, true), testBundle.getBooleanArrayOrNull("boolean-array"))
        assertContentEquals(null, testBundle.getBooleanArrayOrNull("string"))
        assertContentEquals(null, testBundle.getBooleanArrayOrNull("invalid"))

        assertContentEquals(booleanArrayOf(true, false, true), testBundle.requireBooleanArray("boolean-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireBooleanArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireBooleanArray("string")
        }
    }

    @Test
    fun testByteArray() {
        assertContentEquals(byteArrayOf(1, 2, -3), testBundle.getByteArrayOrNull("byte-array"))
        assertContentEquals(null, testBundle.getByteArrayOrNull("int-array"))
        assertContentEquals(null, testBundle.getByteArrayOrNull("invalid"))

        assertContentEquals(byteArrayOf(1, 2, -3), testBundle.requireByteArray("byte-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireByteArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireByteArray("string")
        }
    }

    @Test
    fun testCharArray() {
        assertContentEquals(charArrayOf('a', 'b', 'c'), testBundle.getCharArrayOrNull("char-array"))
        assertContentEquals(null, testBundle.getCharArrayOrNull("string"))
        assertContentEquals(null, testBundle.getCharArrayOrNull("invalid"))

        assertContentEquals(charArrayOf('a', 'b', 'c'), testBundle.requireCharArray("char-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireCharArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireCharArray("string")
        }
    }

    @Test
    fun testDoubleArray() {
        assertContentEquals(doubleArrayOf(1.0, 2.0, -3.0), testBundle.getDoubleArrayOrNull("double-array"))
        assertContentEquals(null, testBundle.getDoubleArrayOrNull("string"))
        assertContentEquals(null, testBundle.getDoubleArrayOrNull("invalid"))

        assertContentEquals(doubleArrayOf(1.0, 2.0, -3.0), testBundle.requireDoubleArray("double-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireDoubleArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireDoubleArray("string")
        }
    }

    @Test
    fun testFloatArray() {
        assertContentEquals(floatArrayOf(1f, 2f, -3f), testBundle.getFloatArrayOrNull("float-array"))
        assertContentEquals(null, testBundle.getFloatArrayOrNull("string"))
        assertContentEquals(null, testBundle.getFloatArrayOrNull("invalid"))

        assertContentEquals(floatArrayOf(1f, 2f, -3f), testBundle.requireFloatArray("float-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireFloatArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireFloatArray("string")
        }
    }

    @Test
    fun testIntArray() {
        assertContentEquals(intArrayOf(1, 2, -3), testBundle.getIntArrayOrNull("int-array"))
        assertContentEquals(null, testBundle.getIntArrayOrNull("string"))
        assertContentEquals(null, testBundle.getIntArrayOrNull("invalid"))

        assertContentEquals(intArrayOf(1, 2, -3), testBundle.requireIntArray("int-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireIntArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireIntArray("string")
        }
    }

    @Test
    fun testLongArray() {
        assertContentEquals(longArrayOf(1L, 2L, -3L), testBundle.getLongArrayOrNull("long-array"))
        assertContentEquals(null, testBundle.getLongArrayOrNull("string"))
        assertContentEquals(null, testBundle.getLongArrayOrNull("invalid"))

        assertContentEquals(longArrayOf(1L, 2L, -3L), testBundle.requireLongArray("long-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireLongArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireLongArray("string")
        }
    }

    @Test
    fun testShortArray() {
        assertContentEquals(shortArrayOf(1, 2, -3), testBundle.getShortArrayOrNull("short-array"))
        assertContentEquals(null, testBundle.getShortArrayOrNull("string"))
        assertContentEquals(null, testBundle.getShortArrayOrNull("invalid"))

        assertContentEquals(shortArrayOf(1, 2, -3), testBundle.requireShortArray("short-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireShortArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireShortArray("string")
        }
    }

    @Test
    fun testStringArray() {
        assertContentEquals(arrayOf("a", "b", "c"), testBundle.getStringArrayOrNull("string-array"))
        assertContentEquals(null, testBundle.getStringArrayOrNull("string"))
        assertContentEquals(null, testBundle.getStringArrayOrNull("invalid"))

        assertContentEquals(arrayOf("a", "b", "c"), testBundle.requireStringArray("string-array"))
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireStringArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireStringArray("string")
        }
    }

    @Test
    fun testCharSequenceArray() {
        assertContentEquals(
            arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence),
            testBundle.getCharSequenceArrayOrNull("charsequence-array")
        )
        assertContentEquals(null, testBundle.getCharSequenceArrayOrNull("string"))
        assertContentEquals(null, testBundle.getCharSequenceArrayOrNull("invalid"))

        assertContentEquals(
            arrayOf("a" as CharSequence, "b" as CharSequence, "c" as CharSequence),
            testBundle.requireCharSequenceArray("charsequence-array")
        )
        assertFailsWith<IllegalArgumentException> {
            testBundle.requireCharSequenceArray("invalid")
        }
        assertFailsWith<IllegalStateException> {
            testBundle.requireCharSequenceArray("string")
        }
    }
}
