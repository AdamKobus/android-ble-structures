package com.adamkobus.ble.structures.error

class UnexpectedSdkValueException(val value: Int) : IllegalArgumentException("Unexpected SDK value: $value")
