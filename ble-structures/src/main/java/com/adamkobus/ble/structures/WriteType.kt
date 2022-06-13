package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException

enum class WriteType(val sdkValue: Int) {

    /**
     * Write characteristic, requesting acknowledgement by the remote device
     *
     * @see BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
     */
    Default(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT),

    /**
     * Write characteristic without requiring a response by the remote device
     *
     * @see BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
     */
    NoResponse(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE),

    /**
     * Write characteristic including authentication
     *
     * @see BluetoothGattCharacteristic.WRITE_TYPE_SIGNED
     */
    Signed(BluetoothGattCharacteristic.WRITE_TYPE_SIGNED);

    override fun toString(): String =
        "$name(sdkValue=$sdkValue)"

    companion object {
        fun fromSdkValue(value: Int): WriteType =
            values().find { it.sdkValue == value } ?: throw UnexpectedSdkValueException(value)
    }
}
