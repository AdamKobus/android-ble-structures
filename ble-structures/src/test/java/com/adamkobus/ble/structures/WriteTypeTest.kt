package com.adamkobus.ble.structures

import com.adamkobus.ble.structures.error.UnexpectedSdkValueException
import junit.framework.TestCase
import org.junit.Assert.assertThrows
import org.junit.Test

class WriteTypeTest {

    @Test
    fun `GIVEN proper sdk value WHEN fromSdkValue THEN expected WriteType is returned`() {
        // given
        val data = mapOf(
            1 to WriteType.NoResponse,
            2 to WriteType.Default,
            4 to WriteType.Signed
        )
        TestCase.assertEquals(data.size, WriteType.values().size) // sanity check

        data.forEach { (sdkValue, expected) ->

            // when
            val obtained = WriteType.fromSdkValue(sdkValue)

            // then
            TestCase.assertEquals("Failed for $sdkValue", expected, obtained)
        }
    }

    @Test
    fun `GIVEN invalid sdk value WHEN fromSdkValue THEN UnexpectedSdkValueException is thrown`() {
        // when
        assertThrows(UnexpectedSdkValueException::class.java) {
            WriteType.fromSdkValue(-1)
        }
    }

    @Test
    fun `WHEN toString THEN proper String is returned`() {
        // given
        val expected = "Signed(sdkValue=4)"

        // when
        val obtained = WriteType.Signed.toString()

        // then
        TestCase.assertEquals(expected, obtained)
    }
}
