package co.zsmb.requirektx

import android.location.Location
import android.net.Uri
import androidx.core.bundle.Bundle
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.ArrayList

@RunWith(RobolectricTestRunner::class)
internal class BundleArrayListTestAndroid {

    // Parcelables
    private val testParcelable1: Uri
        get() = Uri.parse("some/fake/path")
    private val testParcelable2: Location = Location("dummy").apply {
        latitude = 25.832466
        longitude = -70.980690
    }

    private val testBundle = Bundle().apply {
        putIntegerArrayList("int-arraylist", arrayListOf(1, 2, -3))
        putParcelableArrayList("parcelable-arraylist", arrayListOf(testParcelable1, testParcelable2))
        @Suppress("UNCHECKED_CAST")
        putCharSequenceArrayList("charsequence-arraylist", arrayListOf("c", "d", "e") as ArrayList<CharSequence>)
        putStringArrayList("string-arraylist", arrayListOf("a", "b", "c"))

        // Example for invalid types
        putString("string", "a")
    }

    @Test
    fun testIntegerArrayList() {
        assertEquals(arrayListOf(1, 2, -3), testBundle.getIntegerArrayListOrNull("int-arraylist"))
        assertEquals(null, testBundle.getIntegerArrayListOrNull("string"))
        assertEquals(null, testBundle.getIntegerArrayListOrNull("invalid"))

        assertEquals(arrayListOf(1, 2, -3), testBundle.requireIntegerArrayList("int-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireIntegerArrayList("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireIntegerArrayList("string")
        }
    }

    @Test
    fun testParcelableArrayList() {
        assertEquals(arrayListOf(testParcelable1, testParcelable2), testBundle.getParcelableArrayListOrNull("parcelable-arraylist"))
        assertEquals(null, testBundle.getParcelableArrayListOrNull("string"))
        assertEquals(null, testBundle.getParcelableArrayListOrNull("invalid"))

        assertEquals(arrayListOf(testParcelable1, testParcelable2), testBundle.requireParcelableArrayList("parcelable-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireParcelableArrayList("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireParcelableArrayList("string")
        }
    }

    @Test
    fun testCharSequenceArrayList() {
        assertEquals(arrayListOf("c", "d", "e"), testBundle.getCharSequenceArrayListOrNull("charsequence-arraylist"))
        assertEquals(null, testBundle.getCharSequenceArrayListOrNull("string"))
        assertEquals(null, testBundle.getCharSequenceArrayListOrNull("invalid"))

        assertEquals(arrayListOf("c", "d", "e"), testBundle.requireCharSequenceArrayList("charsequence-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireCharSequenceArrayList("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireCharSequenceArrayList("string")
        }
    }

    @Test
    fun testStringArrayList() {
        assertEquals(arrayListOf("a", "b", "c"), testBundle.getStringArrayListOrNull("string-arraylist"))
        assertEquals(null, testBundle.getStringArrayListOrNull("string"))
        assertEquals(null, testBundle.getStringArrayListOrNull("invalid"))

        assertEquals(arrayListOf("a", "b", "c"), testBundle.requireStringArrayList("string-arraylist"))
        Assert.assertThrows(IllegalArgumentException::class.java) {
            testBundle.requireStringArrayList("invalid")
        }
        Assert.assertThrows(IllegalStateException::class.java) {
            testBundle.requireStringArrayList("string")
        }
    }
}
