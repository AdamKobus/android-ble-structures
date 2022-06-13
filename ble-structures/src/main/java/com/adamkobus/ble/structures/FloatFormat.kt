package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException

enum class FloatFormat(val sdkValue: Int) {
    /**
     * 16-bit float
     *
     * @see [BluetoothGattCharacteristic.FORMAT_SFLOAT]
     */
    SFloat(BluetoothGattCharacteristic.FORMAT_SFLOAT),

    /**
     * 32-bit float
     *
     * @see [BluetoothGattCharacteristic.FORMAT_FLOAT]
     */
    Float(BluetoothGattCharacteristic.FORMAT_FLOAT);

    override fun toString(): String =
        "$name(sdkValue=$sdkValue)"

    companion object {
        fun fromSdkValue(value: Int): FloatFormat =
            values().find { it.sdkValue == value } ?: throw UnexpectedSdkValueException(value)
    }
}
