package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattService
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException

enum class GattServiceType(val sdkValue: Int) {

    /**
     * Primary service
     *
     * @see BluetoothGattService.SERVICE_TYPE_PRIMARY
     */
    Primary(BluetoothGattService.SERVICE_TYPE_PRIMARY),

    /**
     * Secondary service (included by primary services)
     *
     * @see BluetoothGattService.SERVICE_TYPE_SECONDARY
     */
    Secondary(BluetoothGattService.SERVICE_TYPE_SECONDARY);

    override fun toString(): String =
        "$name(sdkValue=$sdkValue)"

    companion object {
        fun fromSdkValue(value: Int): GattServiceType =
            values().find { it.sdkValue == value } ?: throw UnexpectedSdkValueException(value)
    }
}
