package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class BlePermissionTest {

    @Test
    fun `GIVEN proper sdk value WHEN fromSdkValue THEN expected BlePermission is returned`() {
        // given
        val data = mapOf(
            1 to BlePermission.Read,
            2 to BlePermission.ReadEncrypted,
            4 to BlePermission.ReadEncryptedMitm,
            16 to BlePermission.Write,
            32 to BlePermission.WriteEncrypted,
            64 to BlePermission.WriteEncryptedMitm,
            128 to BlePermission.WriteSigned,
            256 to BlePermission.WriteSignedMitm,
        )
        TestCase.assertEquals(data.size, BlePermission.values().size) // sanity check

        data.forEach { (sdkValue, expected) ->
            val expectedList = listOf(expected)

            // when
            val obtained = BlePermission.fromSdkValue(sdkValue)

            // then
            TestCase.assertEquals("Failed for $sdkValue", expectedList, obtained)
        }
    }

    @Test
    fun `GIVEN negative sdk value WHEN fromSdkValue THEN UnexpectedSdkValueException is thrown`() {
        // when
        assertThrows(UnexpectedSdkValueException::class.java) {
            BlePermission.fromSdkValue(-1)
        }
    }

    @Test
    fun `WHEN toString THEN proper String is returned`() {
        // given
        val expected = "ReadEncrypted(sdkValue=2)"

        // when
        val obtained = BlePermission.ReadEncrypted.toString()

        // then
        TestCase.assertEquals(expected, obtained)
    }

    @Test
    fun `GIVEN multiple permissions WHEN fromSdkValue THEN all expected permissions are returned`() {
        // given
        val expected = listOf(BlePermission.Read, BlePermission.WriteEncrypted, BlePermission.WriteSignedMitm)
        val data = BluetoothGattCharacteristic.PERMISSION_READ or
            BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED or
            BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED_MITM

        // when
        val obtained = BlePermission.fromSdkValue(data)

        // then
        assertEquals(expected, obtained)
    }
}
