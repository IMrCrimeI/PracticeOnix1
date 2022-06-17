package com.onix.internship.ui.choice

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent

class ChoiceViewModel : BaseViewModel() {
    val initEvent = SingleLiveEvent<Boolean>()

    fun goToGame(player: Boolean) {
        initEvent.value = player
    }
}