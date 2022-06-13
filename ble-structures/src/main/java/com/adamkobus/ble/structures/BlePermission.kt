package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGattDescriptor
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException

/**
 * Represents read and write permissions for [BluetoothGattCharacteristic] and [BluetoothGattDescriptor].
 *
 * Characteristic and Descriptor use the same constants values and it's safe to reuse this structure for both of them.
 */
enum class BlePermission(val sdkValue: Int) {

    /**
     * Allow reading without authentication and encryption
     *
     * @see BluetoothGattCharacteristic.PERMISSION_READ
     * @see BluetoothGattDescriptor.PERMISSION_READ
     */
    Read(BluetoothGattCharacteristic.PERMISSION_READ),

    /**
     * Allow encrypted read operations
     *
     * @see BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED
     * @see BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED
     */
    ReadEncrypted(BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED),

    /**
     * Allow reading with person-in-the-middle protection
     *
     * @see BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED_MITM
     * @see BluetoothGattDescriptor.PERMISSION_READ_ENCRYPTED_MITM
     */
    ReadEncryptedMitm(BluetoothGattCharacteristic.PERMISSION_READ_ENCRYPTED_MITM),

    /**
     * Allow write without authentication and encryption
     *
     * @see BluetoothGattCharacteristic.PERMISSION_WRITE
     * @see BluetoothGattDescriptor.PERMISSION_WRITE
     */
    Write(BluetoothGattCharacteristic.PERMISSION_WRITE),

    /**
     * Allow encrypted writes
     *
     * @see BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED
     * @see BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED
     */
    WriteEncrypted(BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED),

    /**
     * Allow encrypted writes with person-in-the-middle protection
     *
     * @see BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED_MITM
     * @see BluetoothGattDescriptor.PERMISSION_WRITE_ENCRYPTED_MITM
     */
    WriteEncryptedMitm(BluetoothGattCharacteristic.PERMISSION_WRITE_ENCRYPTED_MITM),

    /**
     * Allow signed write operations
     *
     * @see BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED
     * @see BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED
     */
    WriteSigned(BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED),

    /**
     * Allow signed write operations with person-in-the-middle protection
     *
     * @see BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED_MITM
     * @see BluetoothGattDescriptor.PERMISSION_WRITE_SIGNED_MITM
     */
    WriteSignedMitm(BluetoothGattCharacteristic.PERMISSION_WRITE_SIGNED_MITM);

    override fun toString(): String =
        "$name(sdkValue=$sdkValue)"

    companion object {
        /**
         * Maps either [BluetoothGattCharacteristic.getPermissions] or [BluetoothGattDescriptor.getPermissions]
         * to a list of [BlePermission]s
         */
        fun fromSdkValue(value: Int): List<BlePermission> {
            if (value < 0) {
                throw UnexpectedSdkValueException(value)
            }
            return values().filter { value and it.sdkValue != 0 }
        }
    }
}
