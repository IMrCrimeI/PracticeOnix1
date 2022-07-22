package com.onix.internship.ui.firstSetting.role

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import com.onix.internship.data.role.RoleStates
import com.onix.internship.data.role.UserRole
import com.onix.internship.data.repository.AppSharedPreferences

class RoleVerificationViewModel(
    private val sharedPreferences: AppSharedPreferences,
    val roleStates: RoleStates
) :
    BaseViewModel() {
    private val _moveToFragment = SingleLiveEvent<Boolean>()
    val moveToFragment: LiveData<Boolean> = _moveToFragment

    val role = MutableLiveData<UserRole>()

    fun goBack() {
        _moveToFragment.value = false
    }

    fun goToRoleFragment() {
        roleStates.setUserRole(role)
        sharedPreferences.setStringInSharPref(role.value.toString())
        _moveToFragment.value = true
    }
}