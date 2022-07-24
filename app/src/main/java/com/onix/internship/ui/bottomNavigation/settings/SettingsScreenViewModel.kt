package com.onix.internship.ui.bottomNavigation.settings

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.data.role.RoleStates
import com.onix.internship.data.role.UserRole
import com.onix.internship.data.repository.AppSharedPreferences

class SettingsScreenViewModel(
    private val sharedPreferences: AppSharedPreferences,
    val roleStates: RoleStates
) : BaseViewModel() {

    val role = MutableLiveData<UserRole>()

    fun changeUserRole() {
        roleStates.setUserRole(role)
        sharedPreferences.setStringInSharPref(role.value.toString())
        Log.d("Debug", role.value.toString())
        Log.d("Debug", sharedPreferences.getStringFromSharPref().toString())
    }

    fun setIntInSharPref(it: Int) {
        sharedPreferences.setIntInSharPref(it)
    }
}