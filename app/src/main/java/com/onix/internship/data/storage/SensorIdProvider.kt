package com.onix.internship.data.storage

class SensorIdProvider {
    private var apiSensorsId = 0
    private var localSensorsId = 0

    fun getApiSensorsId(): Int {
        return apiSensorsId.also {
            apiSensorsId++
            localSensorsId++
        }
    }

    fun getLocalSensorsId(): Int {
        return localSensorsId.also {
            localSensorsId++
        }
    }

    fun clearApiSensorsId() {
        apiSensorsId = 0
    }
}