package co.zsmb.requirektx

import androidx.work.Data
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DataSingleValueTest {

    private val testData = Data.Builder()
        .putBoolean("boolean", true)
        .putByte("byte", 1)
        .putDouble("double", 1.0)
        .putFloat("float", 1f)
        .putLong("long", 1L)
        .putInt("int", 1)
        .putString("string", "a")
        .build()

    @Nested
    inner class Boolean {
        @Test
        fun getOrNull() {
            assertEquals(true, testData.getBooleanOrNull("boolean"))
            assertEquals(null, testData.getBooleanOrNull("string"))
            assertEquals(null, testData.getBooleanOrNull("invalid"))
        }

        @Test
        fun require() {
            assertEquals(true, testData.requireBoolean("boolean"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireBoolean("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireBoolean("string")
            }
        }
    }

    @Nested
    inner class Byte {
        @Test
        fun getOrNull() {
            assertEquals(1, testData.getByteOrNull("byte"))
            assertEquals(null, testData.getByteOrNull("string"))
            assertEquals(null, testData.getByteOrNull("invalid"))
        }

        @Test
        fun require() {
            assertEquals(1, testData.requireByte("byte"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireByte("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireByte("string")
            }
        }
    }

    @Nested
    inner class Double {
        @Test
        fun getOrNull() {
            assertEquals(1.0, testData.getDoubleOrNull("double"))
            assertEquals(null, testData.getDoubleOrNull("string"))
            assertEquals(null, testData.getDoubleOrNull("invalid"))
        }

        @Test
        fun require() {
            assertEquals(1.0, testData.requireDouble("double"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireDouble("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireDouble("string")
            }
        }
    }

    @Nested
    inner class Float {
        @Test
        fun getOrNull() {
            assertEquals(1f, testData.getFloatOrNull("float"))
            assertEquals(null, testData.getFloatOrNull("string"))
            assertEquals(null, testData.getFloatOrNull("invalid"))
        }

        @Test
        fun require() {
            assertEquals(1f, testData.requireFloat("float"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireFloat("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireFloat("string")
            }
        }
    }

    @Nested
    inner class Long {
        @Test
        fun getOrNull() {
            assertEquals(1L, testData.getLongOrNull("long"))
            assertEquals(null, testData.getLongOrNull("string"))
            assertEquals(null, testData.getLongOrNull("invalid"))
        }

        @Test
        fun require() {
            assertEquals(1L, testData.requireLong("long"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireLong("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireLong("string")
            }
        }
    }

    @Nested
    inner class Int {
        @Test
        fun getOrNull() {
            assertEquals(1, testData.getIntOrNull("int"))
            assertEquals(null, testData.getIntOrNull("string"))
            assertEquals(null, testData.getIntOrNull("invalid"))
        }

        @Test
        fun require() {
            assertEquals(1, testData.requireInt("int"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireInt("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireInt("string")
            }
        }
    }

    @Nested
    inner class String {
        @Test
        fun getOrNull() {
            assertEquals("a", testData.getStringOrNull("string"))
            assertEquals(null, testData.getStringOrNull("int"))
            assertEquals(null, testData.getStringOrNull("invalid"))
        }

        @Test
        fun require() {
            assertEquals("a", testData.requireString("string"))
            assertThrows(IllegalArgumentException::class.java) {
                testData.requireString("invalid")
            }
            assertThrows(IllegalStateException::class.java) {
                testData.requireString("int")
            }
        }
    }

}
