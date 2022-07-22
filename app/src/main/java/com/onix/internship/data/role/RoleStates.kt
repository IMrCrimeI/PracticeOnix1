package com.onix.internship.data.role

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData

data class RoleStates(
    val roleHero: ObservableBoolean = ObservableBoolean(false),
    val rolePlayer: ObservableBoolean = ObservableBoolean(false),
    val roleMaster: ObservableBoolean = ObservableBoolean(false)
) {
    fun setUserRole(role: MutableLiveData<UserRole>) {
        if (roleHero.get()) {
            role.value = UserRole.HERO
        } else if (rolePlayer.get()) {
            role.value = UserRole.PLAYER
        } else role.value = UserRole.MASTER
    }
}
