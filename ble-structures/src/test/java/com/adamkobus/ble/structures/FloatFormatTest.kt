package com.adamkobus.ble.structures

import junit.framework.TestCase.assertEquals
import org.junit.Test

class FloatFormatTest {

    @Test
    fun `GIVEN proper sdk value WHEN fromSdkValue THEN expected FloatFormat is returned`() {
        // given
        val data = mapOf(
            50 to FloatFormat.SIGNED_FLOAT,
            52 to FloatFormat.FLOAT
        )
        assertEquals(data.size, FloatFormat.values().size) // sanity check

        data.forEach { sdkValue, expected ->

            // when
            val obtained = FloatFormat.fromSdkValue(sdkValue)

            // then
            assertEquals("Faield for $sdkValue", expected, obtained)
        }
    }
}
