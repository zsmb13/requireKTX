package co.zsmb.requirektx

import android.content.Intent
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

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
