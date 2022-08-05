package com.onix.internship.data.mapper

import com.onix.internship.data.storage.SensorIdProvider
import com.onix.internship.entity.DeviceData
import com.onix.internship.entity.SensorSubType
import com.onix.internship.entity.SensorType
import com.onix.internship.entity.network.ApiDeviceData

class SensorMapper(private val sensorIdProvider: SensorIdProvider) {
    fun map(apiDeviceData: ApiDeviceData): DeviceData {
        val type = when (apiDeviceData.type) {
            SENSOR -> SensorType.SENSOR
            CAMERA -> SensorType.CAMERA
            SOUND -> SensorType.SOUND
            LIGHT -> SensorType.LIGHT
            else -> SensorType.SENSOR
        }

        val subType = when (apiDeviceData.subtype) {
            SWITCH -> SensorSubType.SWITCH
            ONETIME -> SensorSubType.ONETIME
            LEVEL -> SensorSubType.LEVEL
            else -> SensorSubType.SWITCH
        }

        return DeviceData(
            id = sensorIdProvider.getApiSensorsId(),
            room = apiDeviceData.room,
            type = type,
            subType = subType,
            value = apiDeviceData.value
        )
    }

    companion object {
        //-----Sensor type-----//
        const val SENSOR = "Sensor"
        const val CAMERA = "Camera"
        const val SOUND = "Sound"
        const val LIGHT = "Light"

        //-----Sensor subType-----//
        const val SWITCH = "switch"
        const val ONETIME = "onetime"
        const val LEVEL = "level"
    }
}