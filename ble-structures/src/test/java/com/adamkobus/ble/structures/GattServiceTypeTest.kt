package com.adamkobus.ble.structures

import com.adamkobus.ble.structures.error.UnexpectedSdkValueException
import junit.framework.TestCase
import org.junit.Assert.assertThrows
import org.junit.Test

class GattServiceTypeTest {

    @Test
    fun `GIVEN proper sdk value WHEN fromSdkValue THEN expected GattServiceType is returned`() {
        // given
        val data = mapOf(
            0 to GattServiceType.Primary,
            1 to GattServiceType.Secondary
        )
        TestCase.assertEquals(data.size, GattServiceType.values().size) // sanity check

        data.forEach { (sdkValue, expected) ->

            // when
            val obtained = GattServiceType.fromSdkValue(sdkValue)

            // then
            TestCase.assertEquals("Failed for $sdkValue", expected, obtained)
        }
    }

    @Test
    fun `GIVEN invalid sdk value WHEN fromSdkValue THEN UnexpectedSdkValueException is thrown`() {
        // when
        assertThrows(UnexpectedSdkValueException::class.java) {
            GattServiceType.fromSdkValue(-1)
        }
    }

    @Test
    fun `WHEN toString THEN proper String is returned`() {
        // given
        val expected = "Primary(sdkValue=0)"

        // when
        val obtained = GattServiceType.Primary.toString()

        // then
        TestCase.assertEquals(expected, obtained)
    }
}
