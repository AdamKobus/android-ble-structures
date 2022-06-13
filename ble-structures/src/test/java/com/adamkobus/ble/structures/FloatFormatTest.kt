package com.adamkobus.ble.structures

import com.adamkobus.ble.structures.error.UnexpectedSdkValueException
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class FloatFormatTest {

    @Test
    fun `GIVEN proper sdk value WHEN fromSdkValue THEN expected FloatFormat is returned`() {
        // given
        val data = mapOf(
            50 to FloatFormat.SFloat,
            52 to FloatFormat.Float
        )
        assertEquals(data.size, FloatFormat.values().size) // sanity check

        data.forEach { (sdkValue, expected) ->

            // when
            val obtained = FloatFormat.fromSdkValue(sdkValue)

            // then
            assertEquals("Failed for $sdkValue", expected, obtained)
        }
    }

    @Test
    fun `GIVEN invalid sdk value WHEN fromSdkValue THEN UnexpectedSdkValueException is thrown`() {
        // when
        assertThrows(UnexpectedSdkValueException::class.java) {
            FloatFormat.fromSdkValue(-1)
        }
    }

    @Test
    fun `WHEN toString THEN proper String is returned`() {
        // given
        val expected = "Float(sdkValue=52)"

        // when
        val obtained = FloatFormat.Float.toString()

        // then
        assertEquals(expected, obtained)
    }
}
