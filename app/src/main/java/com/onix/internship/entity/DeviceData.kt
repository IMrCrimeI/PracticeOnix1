package com.onix.internship.entity

data class DeviceData(
    val id: Int,
    val room: String,
    val type: SensorType,
    val subType: SensorSubType,
    val value: Any
)
