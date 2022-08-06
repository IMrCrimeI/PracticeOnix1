package com.onix.internship.ui.addSensor

import androidx.lifecycle.LiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.storage.SensorIdProvider
import com.onix.internship.data.storage.SensorProvider
import com.onix.internship.data.storage.SensorStorage
import com.onix.internship.entity.SensorSubType
import com.onix.internship.entity.SensorType

class AddSensorViewModel(
    private val sensorStorage: SensorStorage,
    private val sensorProvider: SensorProvider,
    private val sensorIdProvider: SensorIdProvider
) : BaseViewModel() {

    private val _moveBack = SingleLiveEvent<Unit>()
    val moveBack: LiveData<Unit> = _moveBack

    val model = AddSensorModel()

    fun addSensor() {
        val sensor =
            sensorProvider.createSensor(
                sensorIdProvider.getLocalSensorsId(),
                model.room.get() ?: "Default room",
                model.type.get() ?: SensorType.SENSOR,
                model.subType.get() ?: SensorSubType.SWITCH
            )
        sensorStorage.addNewSensorInList(sensor)
        _moveBack.value = Unit
    }

    fun setType(position: Int) {
        model.type.set(
            when (position) {
                0 -> {
                    SensorType.SENSOR
                }
                1 -> {
                    SensorType.CAMERA
                }
                2 -> {
                    SensorType.SOUND
                }
                3 -> {
                    SensorType.LIGHT
                }
                else -> {
                    SensorType.SENSOR
                }
            }
        )
    }

    fun setSubType(position: Int) {
        model.subType.set(
            when (position) {
                0 -> {
                    SensorSubType.SWITCH
                }
                1 -> {
                    SensorSubType.ONETIME
                }
                2 -> {
                    SensorSubType.LEVEL
                }
                else -> {
                    SensorSubType.SWITCH
                }
            }
        )
    }
}