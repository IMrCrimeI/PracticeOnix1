package com.onix.internship.data.mapper

import com.onix.internship.data.storage.SensorIdProvider
import com.onix.internship.entity.HomeInfo
import com.onix.internship.entity.network.ApiHomeInfo

class HomeInfoMapper(
    private val sensorMapper: SensorMapper,
    private val sensorIdProvider: SensorIdProvider
) {
    fun map(apiHomeInfo: ApiHomeInfo): HomeInfo {
        sensorIdProvider.clearApiSensorsId()
        return HomeInfo(
            version = apiHomeInfo.version,
            name = apiHomeInfo.name,
            house = apiHomeInfo.house.map { sensorMapper.map(it) }
        )
    }
}