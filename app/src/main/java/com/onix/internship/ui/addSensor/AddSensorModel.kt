package com.onix.internship.ui.addSensor

import androidx.databinding.ObservableField
import com.onix.internship.entity.SensorSubType
import com.onix.internship.entity.SensorType

data class AddSensorModel(
    val room: ObservableField<String> = ObservableField(),
    val type: ObservableField<SensorType> = ObservableField(),
    val subType: ObservableField<SensorSubType> = ObservableField()
)
