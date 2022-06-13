package com.adamkobus.ble.structures

import android.bluetooth.BluetoothGattCharacteristic
import com.adamkobus.ble.structures.error.UnexpectedSdkValueException

enum class BleProperty(val sdkValue: Int) {

    /**
     * Characteristic is broadcastable.
     *
     * @see BluetoothGattCharacteristic.PROPERTY_BROADCAST
     */
    Broadcast(BluetoothGattCharacteristic.PROPERTY_BROADCAST),

    /**
     * Characteristic has extended properties
     *
     * @see BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS
     */
    ExtendedProps(BluetoothGattCharacteristic.PROPERTY_EXTENDED_PROPS),

    /**
     * Characteristic supports indication
     *
     * @see BluetoothGattCharacteristic.PROPERTY_INDICATE
     */
    Indicate(BluetoothGattCharacteristic.PROPERTY_INDICATE),

    /**
     * Characteristic supports notification
     *
     * @see BluetoothGattCharacteristic.PROPERTY_NOTIFY
     */
    Notify(BluetoothGattCharacteristic.PROPERTY_NOTIFY),

    /**
     * Characteristic is readable.
     *
     * @see BluetoothGattCharacteristic.PROPERTY_READ
     */
    Read(BluetoothGattCharacteristic.PROPERTY_READ),

    /**
     * Characteristic supports write with signature
     *
     * @see BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE
     */
    SignedWrite(BluetoothGattCharacteristic.PROPERTY_SIGNED_WRITE),

    /**
     * Characteristic can be written.
     *
     * @see BluetoothGattCharacteristic.PROPERTY_WRITE
     */
    Write(BluetoothGattCharacteristic.PROPERTY_WRITE),

    /**
     * Characteristic can be written without response.
     *
     * @see BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
     */
    WriteNoResponse(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE);

    override fun toString(): String =
        "$name(sdkValue=$sdkValue)"

    companion object {
        /**
         * Maps either [BluetoothGattCharacteristic.getProperties] to a list of [BleProperty]
         */
        fun fromSdkValue(value: Int): List<BleProperty> {
            if (value < 0) {
                throw UnexpectedSdkValueException(value)
            }
            return values().filter { value and it.sdkValue != 0 }
        }
    }
}
