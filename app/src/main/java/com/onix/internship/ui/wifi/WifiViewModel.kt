package com.onix.internship.ui.wifi

import android.net.wifi.ScanResult
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.onix.internship.arch.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WifiViewModel(private val wifiScanner: WifiScanner) : BaseViewModel() {
    private val _scanResult = MutableLiveData<List<ScanResult>>()
    val scanResult: LiveData<List<ScanResult>> = _scanResult

    init {
        viewModelScope.launch {
            while (true) {
                val wifiResult = wifiScanner.getWifiResult()
                _scanResult.value = wifiResult
                Log.d("wifi123", wifiResult.toString())
                delay(10000)
            }
        }
    }
}