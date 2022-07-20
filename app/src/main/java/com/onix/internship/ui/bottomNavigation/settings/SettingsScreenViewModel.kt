package com.onix.internship.ui.bottomNavigation.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.UserRole

class SettingsScreenViewModel : BaseViewModel() {

    private val _changeSettings = MutableLiveData<Unit>()
    val changeSettings : LiveData<Unit> = _changeSettings

    val role = MutableLiveData<UserRole>()

    fun setUserRole(it: UserRole) {
        when (it) {
            UserRole.HERO -> role.value = UserRole.HERO
            UserRole.PLAYER -> role.value = UserRole.PLAYER
            UserRole.MASTER -> role.value = UserRole.MASTER
        }
        _changeSettings.value = Unit
    }
}