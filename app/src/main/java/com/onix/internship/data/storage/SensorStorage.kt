package com.onix.internship.data.storage

import com.onix.internship.entity.DeviceData

class SensorStorage {
    private val sensorsList = mutableListOf<DeviceData>()

    fun getSensorsList(): List<DeviceData> {
        return sensorsList
    }

    fun addNewSensorInList(sensor: List<DeviceData>) {
        if (sensorsList.isEmpty()) {
            sensorsList.addAll(sensor)
        } else {
            sensor.forEach {
                if (!sensorsList.contains(it)) {
                    sensorsList.add(it)
                }
            }
        }
    }

    fun addNewSensorInList(sensor: DeviceData) {
        sensorsList.add(sensor)
    }

    fun deleteSensorFromList(sensor: DeviceData) {
        sensorsList.remove(sensor)
    }
}