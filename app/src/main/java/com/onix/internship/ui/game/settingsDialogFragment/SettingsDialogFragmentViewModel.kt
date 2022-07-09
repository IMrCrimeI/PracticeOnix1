package com.onix.internship.ui.game.settingsDialogFragment

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import kotlin.system.exitProcess

class SettingsDialogFragmentViewModel : BaseViewModel() {

    val goToHome = SingleLiveEvent<Boolean>()

    fun goToHome(){
        goToHome.value = true
    }

    fun exit(){
        exitProcess(0)
    }
}