package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException

enum class FloatFormat(val sdkValue: Int) {
    SIGNED_FLOAT(BluetoothGattCharacteristic.FORMAT_SFLOAT),
    FLOAT(BluetoothGattCharacteristic.FORMAT_FLOAT);

    companion object {
        fun fromSdkValue(value: Int): FloatFormat =
            values().find { it.sdkValue == value } ?: throw UnexpectedSdkValueException(value)
    }
}
