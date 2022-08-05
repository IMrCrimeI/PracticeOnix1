package com.onix.internship.ui.sensors

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.arch.network.onFailure
import com.onix.internship.arch.network.onSuccess
import com.onix.internship.data.repository.SensorRepository
import com.onix.internship.data.storage.SensorStorage
import com.onix.internship.entity.DeviceData
import com.onix.internship.ui.sensors.adapter.OnSensorClickListener
import kotlinx.coroutines.launch

class SensorsListViewModel(
    private val sensorStorage: SensorStorage,
    private val repository: SensorRepository
) : BaseViewModel(),
    OnSensorClickListener {

    private val _listOfSensors = MutableLiveData(sensorStorage.getSensorsList())
    val listOfSensors: LiveData<List<DeviceData>> = _listOfSensors

    private val _moveToAddFragment = SingleLiveEvent<Unit>()
    val moveToAddFragment: LiveData<Unit> = _moveToAddFragment

    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: LiveData<String> = _errorMessage

    init {
        getDataFromApi()
    }

    fun addNewSensor() {
        _moveToAddFragment.value = Unit
    }

    fun updateListItem() {
        _listOfSensors.value = sensorStorage.getSensorsList().toList()
        Log.d("Debug1", _listOfSensors.value.toString())
    }

    override fun deleteSensor(item: DeviceData) {
        sensorStorage.deleteSensorFromList(item)
        updateListItem()
    }

    fun getDataFromApi() {
        viewModelScope.launch {
            repository.getSensors()
                .onSuccess {
                    sensorStorage.addNewSensorInList(it)
                    updateListItem()
                }
                .onFailure {
                    _errorMessage.postValue(it.message)
                }
        }
    }
}