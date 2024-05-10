package co.zsmb.requirektx

import android.content.Intent
import android.location.Location
import android.net.Uri
import android.os.Bundle
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.Calendar
import java.util.UUID

@RunWith(RobolectricTestRunner::class)
internal class IntentExtrasReferenceTest {

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

    private val testBundle = Bundle().apply {
        putInt("int", 1)
        putString("string", "a")
    }

    private val testIntent = Intent().apply {
        putExtra("string", "a")
        putExtra("charsequence", "b" as CharSequence)
        putExtra("bundle", testBundle)

        putExtra("serializable1", testSerializable1)
        putExtra("serializable2", testSerializable2)

        putExtra("parcelable1", testParcelable1)
        putExtra("parcelable2", testParcelable2)

        // Example for invalid types
        putExtra("int", 1)
    }

    @Test
    fun testString() {
        assertEquals("a", testIntent.getStringExtraOrNull("string"))
        assertEquals(null, testIntent.getStringExtraOrNull("int"))
        assertEquals(null, testIntent.getStringExtraOrNull("invalid"))

        assertEquals("a", testIntent.requireStringExtra("string"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireStringExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireStringExtra("int")
        }
    }

    @Test
    fun testCharSequence() {
        assertEquals("b", testIntent.getCharSequenceExtraOrNull("charsequence"))
        assertEquals(null, testIntent.getCharSequenceExtraOrNull("int"))
        assertEquals(null, testIntent.getCharSequenceExtraOrNull("invalid"))

        assertEquals("b", testIntent.requireCharSequenceExtra("charsequence"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireCharSequenceExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireCharSequenceExtra("int")
        }
    }

    @Test
    fun testBundle() {
        assertEquals(testBundle, testIntent.getBundleExtraOrNull("bundle"))
        assertEquals(null, testIntent.getBundleExtraOrNull("int"))
        assertEquals(null, testIntent.getBundleExtraOrNull("invalid"))

        assertEquals(testBundle, testIntent.requireBundleExtra("bundle"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireBundleExtra("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireBundleExtra("int")
        }
    }

    @Test
    fun testSerializable() {
        assertEquals(testSerializable1, testIntent.getSerializableExtraOrNull("serializable1"))
        assertEquals(null, testIntent.getSerializableExtraOrNull<UUID>("serializable2"))
        assertEquals(null, testIntent.getSerializableExtraOrNull<UUID>("invalid"))

        assertEquals(testSerializable1, testIntent.requireSerializableExtra("serializable1"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireSerializableExtra<UUID>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireSerializableExtra<UUID>("serializable2")
        }
    }

    @Test
    fun testParcelable() {
        assertEquals(testParcelable1, testIntent.getParcelableExtraOrNull("parcelable1"))
        assertEquals(null, testIntent.getParcelableExtraOrNull<Uri>("parcelable2"))
        assertEquals(null, testIntent.getParcelableExtraOrNull<Uri>("invalid"))

        assertEquals(testParcelable1, testIntent.requireParcelableExtra("parcelable1"))
        assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireParcelableExtra<Uri>("invalid")
        }
        assertThrows(IllegalStateException::class.java) {
            testIntent.requireParcelableExtra<Uri>("parcelable2")
        }
    }
}
