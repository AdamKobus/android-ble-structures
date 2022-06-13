package com.adamkobus.ble.structures

import com.adamkobus.ble.structures.error.UnexpectedSdkValueException
import junit.framework.TestCase
import org.junit.Assert.assertThrows
import org.junit.Test

class IntFormatTest {

    @Test
    fun `GIVEN proper sdk value WHEN fromSdkValue THEN expected IntFormat is returned`() {
        // given
        val data = mapOf(
            17 to IntFormat.UInt8,
            18 to IntFormat.UInt16,
            20 to IntFormat.UInt32,
            33 to IntFormat.SInt8,
            34 to IntFormat.SInt16,
            36 to IntFormat.SInt32,
        )
        TestCase.assertEquals(data.size, IntFormat.values().size) // sanity check

        data.forEach { (sdkValue, expected) ->

            // when
            val obtained = IntFormat.fromSdkValue(sdkValue)

            // then
            TestCase.assertEquals("Failed for $sdkValue", expected, obtained)
        }
    }

    @Test
    fun `GIVEN invalid sdk value WHEN fromSdkValue THEN UnexpectedSdkValueException is thrown`() {
        // when
        assertThrows(UnexpectedSdkValueException::class.java) {
            IntFormat.fromSdkValue(-1)
        }
    }

    @Test
    fun `WHEN toString THEN proper String is returned`() {
        // given
        val expected = "SInt32(sdkValue=36)"

        // when
        val obtained = IntFormat.SInt32.toString()

        // then
        TestCase.assertEquals(expected, obtained)
    }
}
