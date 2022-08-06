package com.onix.internship.data.storage

import com.onix.internship.entity.DeviceData
import com.onix.internship.entity.SensorSubType
import com.onix.internship.entity.SensorType
import kotlin.random.Random

class SensorProvider {
    fun createSensor(
        id: Int,
        room: String,
        type: SensorType,
        subType: SensorSubType
    ): DeviceData {
        return DeviceData(
            id,
            room,
            type,
            subType,
            createRandomValue(subType)
        )
    }

    private fun createRandomValue(subType: SensorSubType): String {
        return when (subType) {
            SensorSubType.SWITCH -> {
                if (Random.nextBoolean()) "OFF"
                else "ON"
            }
            SensorSubType.ONETIME -> {
                when (Random.nextInt(0, 2)) {
                    0 -> "https://th.bing.com/th/id/OIP.yMs1Vsh5TGUxRsO-4I3ybgHaEK?pid=ImgDet&rs=1"
                    1 -> "https://th.bing.com/th/id/OIP.vODlsBQh4ViNiHG3ubN0YAHaEK?pid=ImgDet&rs=1"
                    2 -> "https://th.bing.com/th/id/OIP.2telEFX5XYwyCIDcZsETSAHaE7?pid=ImgDet&rs=1"
                    else -> "https://th.bing.com/th/id/OIP.yMs1Vsh5TGUxRsO-4I3ybgHaEK?pid=ImgDet&rs=1"
                }
            }
            SensorSubType.LEVEL -> {
                if (Random.nextBoolean())
                    Random.nextInt(1, 10).toString()
                else
                    Random.nextDouble(0.0, 10.0).toString()
            }
        }
    }
}