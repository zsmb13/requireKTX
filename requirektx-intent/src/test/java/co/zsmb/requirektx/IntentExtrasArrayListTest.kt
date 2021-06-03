package co.zsmb.requirektx

import android.content.Intent
import android.location.Location
import android.net.Uri
import org.junit.Assert
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.ArrayList

@RunWith(RobolectricTestRunner::class)
internal class IntentExtrasArrayListTest {

    // Parcelables
    private val testParcelable1: Uri
        get() = Uri.parse("some/fake/path")
    private val testParcelable2: Location = Location("dummy").apply {
        latitude = 25.832466
        longitude = -70.980690
    }

    private val testIntent = Intent().apply {
        putIntegerArrayListExtra("int-arraylist", arrayListOf(1, 2, -3))
        putParcelableArrayListExtra("parcelable-arraylist", arrayListOf(testParcelable1, testParcelable2))
        @Suppress("UNCHECKED_CAST")
        putCharSequenceArrayListExtra("charsequence-arraylist", arrayListOf("c", "d", "e") as ArrayList<CharSequence>)
        putStringArrayListExtra("string-arraylist", arrayListOf("a", "b", "c"))

        // Example for invalid types
        putExtra("string", "a")
    }

    @Test
    fun testIntegerArrayList() {
        assertEquals(arrayListOf(1, 2, -3), testIntent.getIntegerArrayListExtraOrNull("int-arraylist"))
        assertEquals(null, testIntent.getIntegerArrayListExtraOrNull("string"))
        assertEquals(null, testIntent.getIntegerArrayListExtraOrNull("invalid"))

        assertEquals(arrayListOf(1, 2, -3), testIntent.requireIntegerArrayListExtra("int-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireIntegerArrayListExtra("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testIntent.requireIntegerArrayListExtra("string")
        }
    }

    @Test
    fun testParcelableArrayList() {
        assertEquals(arrayListOf(testParcelable1, testParcelable2), testIntent.getParcelableArrayListExtraOrNull("parcelable-arraylist"))
        assertEquals(null, testIntent.getParcelableArrayListExtraOrNull("string"))
        assertEquals(null, testIntent.getParcelableArrayListExtraOrNull("invalid"))

        assertEquals(arrayListOf(testParcelable1, testParcelable2), testIntent.requireParcelableArrayListExtra("parcelable-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireParcelableArrayListExtra("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testIntent.requireParcelableArrayListExtra("string")
        }
    }

    @Test
    fun testCharSequenceArrayList() {
        assertEquals(arrayListOf("c", "d", "e"), testIntent.getCharSequenceArrayListExtraOrNull("charsequence-arraylist"))
        assertEquals(null, testIntent.getCharSequenceArrayListExtraOrNull("string"))
        assertEquals(null, testIntent.getCharSequenceArrayListExtraOrNull("invalid"))

        assertEquals(arrayListOf("c", "d", "e"), testIntent.requireCharSequenceArrayListExtra("charsequence-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireCharSequenceArrayListExtra("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testIntent.requireCharSequenceArrayListExtra("string")
        }
    }

    @Test
    fun testStringArrayList() {
        assertEquals(arrayListOf("a", "b", "c"), testIntent.getStringArrayListExtraOrNull("string-arraylist"))
        assertEquals(null, testIntent.getStringArrayListExtraOrNull("string"))
        assertEquals(null, testIntent.getStringArrayListExtraOrNull("invalid"))

        assertEquals(arrayListOf("a", "b", "c"), testIntent.requireStringArrayListExtra("string-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testIntent.requireStringArrayListExtra("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testIntent.requireStringArrayListExtra("string")
        }
    }
}
