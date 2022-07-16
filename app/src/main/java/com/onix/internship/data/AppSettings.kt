package com.onix.internship.data

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData

class AppSettings {
    val sale = ObservableBoolean()
    val date = MutableLiveData<String>()
    val fromTime = MutableLiveData<String>()
    val toTime = MutableLiveData<String>()
}