package co.zsmb.requirektx

import android.location.Location
import android.net.Uri
import android.os.Binder
import androidx.core.bundle.Bundle
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.Calendar
import java.util.UUID

@RunWith(RobolectricTestRunner::class)
internal class BundleReferenceTestAndroid {

    // Parcelables
    private val testParcelable1: Uri
        get() = Uri.parse("some/fake/path")
    private val testParcelable2: Location
        get() {
            return Location("dummy").apply {
                latitude = 25.832466
                longitude = -70.980690
            }
        }

    // Serializables
    private val testSerializable1: UUID
        get() = UUID.fromString("1f3b3e0b-bc62-4606-bb4c-dbf768073912")
    private val testSerializable2: Calendar
        get() = Calendar.getInstance().apply { timeInMillis = 123456789L }
    private val testBinder = Binder()
    private val testNestedBundle = Bundle().apply { putString("key", "value") }

    private val testBundle = Bundle().apply {
        putString("string", "a")
        putCharSequence("charsequence", "b" as CharSequence)
        putBundle("bundle", testNestedBundle)

        // Produces a java.lang.NoSuchMethodError
//        putBinder("binder", testBinder)
//        putSize("size", Size(10, 20))
//        putSizeF("sizef", SizeF(30f, 40f))

        putSerializable("serializable1", testSerializable1)
        putSerializable("serializable2", testSerializable2)

        putParcelable("parcelable1", testParcelable1)
        putParcelable("parcelable2", testParcelable2)

        // Example for invalid types
        putInt("int", 1)
    }

    @Test
    fun testString() {
        assertEquals("a", testBundle.getStringOrNull("string"))
        assertEquals(null, testBundle.getStringOrNull("int"))
        assertEquals(null, testBundle.getStringOrNull("invalid"))

        assertEquals("a", testBundle.requireString("string"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireString("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireString("int")
        }
    }

    @Test
    fun testCharSequence() {
        assertEquals("b", testBundle.getCharSequenceOrNull("charsequence"))
        assertEquals(null, testBundle.getCharSequenceOrNull("int"))
        assertEquals(null, testBundle.getCharSequenceOrNull("invalid"))

        assertEquals("b", testBundle.requireCharSequence("charsequence"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireCharSequence("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireCharSequence("int")
        }
    }

    @Test
    fun testParcelable() {
        assertEquals(testParcelable1, testBundle.getParcelableOrNull("parcelable1"))
        assertEquals(null, testBundle.getParcelableOrNull<Uri>("parcelable2"))
        assertEquals(null, testBundle.getParcelableOrNull<Uri>("invalid"))

        assertEquals(testParcelable1, testBundle.requireParcelable("parcelable1"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireParcelable<Uri>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireParcelable<Uri>("parcelable2")
        }
    }

    @Test
    fun testSerializable() {
        assertEquals(testSerializable1, testBundle.getSerializableOrNull("serializable1"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("serializable2"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("invalid"))

        assertEquals(testSerializable1, testBundle.requireSerializable("serializable1"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireSerializable<UUID>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireSerializable<UUID>("serializable2")
        }
    }

    @Test
    fun testSize() {
//        assertEquals(Size(10, 20), testBundle.getSerializableOrNull("size"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("int"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("invalid"))

//        assertEquals(Size(10, 20), testBundle.requireSerializable("size"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireSerializable<UUID>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireSerializable<UUID>("int")
        }
    }

    @Test
    fun testSizeF() {
//        assertEquals(SizeF(30f, 40f), testBundle.getSerializableOrNull("sizef"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("int"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("invalid"))

//        assertEquals(SizeF(30f, 40f), testBundle.requireSerializable("sizef"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireSerializable<UUID>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireSerializable<UUID>("int")
        }
    }

    @Test
    fun testBinder() {
//        assertEquals(testBinder, testBundle.getSerializableOrNull("binder"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("int"))
        assertEquals(null, testBundle.getSerializableOrNull<UUID>("invalid"))

//        assertEquals(testBinder, testBundle.requireSerializable("binder"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireSerializable<UUID>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireSerializable<UUID>("int")
        }
    }

    @Test
    fun testBundle() {
        assertEquals(testNestedBundle, testBundle.getBundleOrNull("bundle"))
        assertEquals(null, testBundle.getBundleOrNull("int"))
        assertEquals(null, testBundle.getBundleOrNull("invalid"))

        assertEquals(testNestedBundle, testBundle.requireBundle("bundle"))
        assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireBundle("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testBundle.requireBundle("int")
        }
    }
}
