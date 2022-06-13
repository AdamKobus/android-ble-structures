package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException

enum class IntFormat(val sdkValue: Int) {
    /**
     * Signed 8-bit integer
     *
     * @see [BluetoothGattCharacteristic.FORMAT_SINT8]
     */
    SInt8(BluetoothGattCharacteristic.FORMAT_SINT8),

    /**
     * Signed 16-bit integer
     *
     * @see [BluetoothGattCharacteristic.FORMAT_SINT16]
     */
    SInt16(BluetoothGattCharacteristic.FORMAT_SINT16),

    /**
     * Signed 32-bit integer
     *
     * @see [BluetoothGattCharacteristic.FORMAT_SINT32]
     */
    SInt32(BluetoothGattCharacteristic.FORMAT_SINT32),

    /**
     * Unsigned 8-bit integer
     *
     * @see [BluetoothGattCharacteristic.FORMAT_UINT8]
     */
    UInt8(BluetoothGattCharacteristic.FORMAT_UINT8),

    /**
     * Unsigned 16-bit integer
     *
     * @see [BluetoothGattCharacteristic.FORMAT_UINT16]
     */
    UInt16(BluetoothGattCharacteristic.FORMAT_UINT16),

    /**
     * Unsigned 32-bit integer
     *
     * @see [BluetoothGattCharacteristic.FORMAT_UINT32]
     */
    UInt32(BluetoothGattCharacteristic.FORMAT_UINT32);

    override fun toString(): String =
        "$name(sdkValue=$sdkValue)"

    companion object {
        fun fromSdkValue(value: Int): IntFormat =
            values().find { it.sdkValue == value } ?: throw UnexpectedSdkValueException(value)
    }
}
