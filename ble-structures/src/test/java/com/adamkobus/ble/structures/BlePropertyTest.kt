package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class BlePropertyTest {

    @Test
    fun `GIVEN proper sdk value WHEN fromSdkValue THEN expected BleProperty is returned`() {
        // given
        val data = mapOf(
            1 to BleProperty.Broadcast,
            128 to BleProperty.ExtendedProps,
            32 to BleProperty.Indicate,
            16 to BleProperty.Notify,
            2 to BleProperty.Read,
            64 to BleProperty.SignedWrite,
            8 to BleProperty.Write,
            4 to BleProperty.WriteNoResponse,
        )
        TestCase.assertEquals(data.size, BleProperty.values().size) // sanity check

        data.forEach { (sdkValue, expected) ->
            val expectedList = listOf(expected)

            // when
            val obtained = BleProperty.fromSdkValue(sdkValue)

            // then
            TestCase.assertEquals("Failed for $sdkValue", expectedList, obtained)
        }
    }

    @Test
    fun `GIVEN negative sdk value WHEN fromSdkValue THEN UnexpectedSdkValueException is thrown`() {
        // when
        assertThrows(UnexpectedSdkValueException::class.java) {
            BleProperty.fromSdkValue(-1)
        }
    }

    @Test
    fun `WHEN toString THEN proper String is returned`() {
        // given
        val expected = "SignedWrite(sdkValue=64)"

        // when
        val obtained = BleProperty.SignedWrite.toString()

        // then
        TestCase.assertEquals(expected, obtained)
    }

    @Test
    fun `GIVEN multiple permissions WHEN fromSdkValue THEN all expected permissions are returned`() {
        // given
        val expected = listOf(BleProperty.Broadcast, BleProperty.Read, BleProperty.SignedWrite)
        val data = BluetoothGattCharacteristic.PROPERTY_READ or
            BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE or
            BluetoothGattCharacteristic.PROPERTY_BROADCAST

        // when
        val obtained = BleProperty.fromSdkValue(data)

        // then
        assertEquals(expected, obtained)
    }
}
