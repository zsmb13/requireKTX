@file:Suppress("ClassName")

package co.zsmb.requirektx

import androidx.work.Data
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DataArrayValueTest {

    private val testData = Data.Builder()
        .putBooleanArray("boolean", booleanArrayOf(true, false, true))
        .putByteArray("byte", byteArrayOf(1, 2, -3))
        .putDoubleArray("double", doubleArrayOf(1.0, 2.0, -3.0))
        .putFloatArray("float", floatArrayOf(1f, 2f, -3f))
        .putLongArray("long", longArrayOf(1L, 2L, -3L))
        .putIntArray("int", intArrayOf(1, 2, -3))
        .putStringArray("string", arrayOf("a", "b", "c"))
        .build()

    @Nested
    inner class `Boolean arrays` {
        @Test
        fun getOrNull() {
            assertArrayEquals(
                booleanArrayOf(true, false, true),
                testData.getBooleanArrayOrNull("boolean")
            )
            assertArrayEquals(null, testData.getBooleanArrayOrNull("string"))
            assertArrayEquals(null, testData.getBooleanArrayOrNull("invalid"))
        }

        @Test
        fun require() {
            assertArrayEquals(
                booleanArrayOf(true, false, true),
                testData.requireBooleanArray("boolean")
            )
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireBooleanArray("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireBooleanArray("string")
            }
        }
    }

    @Nested
    inner class `Byte arrays` {
        @Test
        fun getOrNull() {
            assertArrayEquals(byteArrayOf(1, 2, -3), testData.getByteArrayOrNull("byte"))
            assertArrayEquals(null, testData.getByteArrayOrNull("string"))
            assertArrayEquals(null, testData.getByteArrayOrNull("invalid"))
        }

        @Test
        fun require() {
            assertArrayEquals(byteArrayOf(1, 2, -3), testData.requireByteArray("byte"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireByteArray("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireByteArray("string")
            }
        }
    }

    @Nested
    inner class `Double arrays` {
        @Test
        fun getOrNull() {
            assertArrayEquals(doubleArrayOf(1.0, 2.0, -3.0), testData.getDoubleArrayOrNull("double"))
            assertArrayEquals(null, testData.getDoubleArrayOrNull("string"))
            assertArrayEquals(null, testData.getDoubleArrayOrNull("invalid"))
        }

        @Test
        fun require() {
            assertArrayEquals(doubleArrayOf(1.0, 2.0, -3.0), testData.requireDoubleArray("double"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireDoubleArray("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireDoubleArray("string")
            }
        }
    }

    @Nested
    inner class `Float arrays` {
        @Test
        fun getOrNull() {
            assertArrayEquals(floatArrayOf(1f, 2f, -3f), testData.getFloatArrayOrNull("float"))
            assertArrayEquals(null, testData.getFloatArrayOrNull("string"))
            assertArrayEquals(null, testData.getFloatArrayOrNull("invalid"))
        }

        @Test
        fun require() {
            assertArrayEquals(floatArrayOf(1f, 2f, -3f), testData.requireFloatArray("float"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireFloatArray("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireFloatArray("string")
            }
        }
    }

    @Nested
    inner class `Long arrays` {
        @Test
        fun getOrNull() {
            assertArrayEquals(longArrayOf(1L, 2L, -3L), testData.getLongArrayOrNull("long"))
            assertArrayEquals(null, testData.getLongArrayOrNull("string"))
            assertArrayEquals(null, testData.getLongArrayOrNull("invalid"))
        }

        @Test
        fun require() {
            assertArrayEquals(longArrayOf(1L, 2L, -3L), testData.requireLongArray("long"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireLongArray("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireLongArray("string")
            }
        }
    }

    @Nested
    inner class `Int arrays` {
        @Test
        fun getOrNull() {
            assertArrayEquals(intArrayOf(1, 2, -3), testData.getIntArrayOrNull("int"))
            assertArrayEquals(null, testData.getIntArrayOrNull("string"))
            assertArrayEquals(null, testData.getIntArrayOrNull("invalid"))
        }

        @Test
        fun require() {
            assertArrayEquals(intArrayOf(1, 2, -3), testData.requireIntArray("int"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireIntArray("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireIntArray("string")
            }
        }
    }

    @Nested
    inner class `String arrays` {
        @Test
        fun getOrNull() {
            assertArrayEquals(arrayOf("a", "b", "c"), testData.getStringArrayOrNull("string"))
            assertArrayEquals(null, testData.getStringArrayOrNull("boolean"))
            assertArrayEquals(null, testData.getStringArrayOrNull("invalid"))
        }

        @Test
        fun require() {
            assertArrayEquals(arrayOf("a", "b", "c"), testData.requireStringArray("string"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireStringArray("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireStringArray("boolean")
            }
        }
    }

}
