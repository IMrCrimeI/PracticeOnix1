package com.onix.internship.ui.bottomNavigation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.UserRole

class SettingsScreenViewModel : BaseViewModel() {

    private val _changeSettings = MutableLiveData<Unit>()
    val changeSettings: LiveData<Unit> = _changeSettings

    val role = MutableLiveData<UserRole>()

    fun setUserRole(it: UserRole) {
        role.value = it
        _changeSettings.value = Unit
    }
}