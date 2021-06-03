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
internal class IntentTest {

    private val emptyIntent = Intent()

    private val testIntent = Intent().apply {
        putExtra("string", "a")
    }

    @Test
    fun `Missing intent extras`() {
        assertThrows(IllegalStateException::class.java) {
            emptyIntent.requireExtras()
        }
    }

    @Test
    fun `Present intent extras don't produce an exception`() {
        testIntent.requireExtras()
    }

}
