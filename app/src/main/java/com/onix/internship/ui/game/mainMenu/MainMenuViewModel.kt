package com.onix.internship.ui.game.mainMenu

import com.onix.internship.arch.BaseViewModel
import com.onix.internship.arch.lifecycle.SingleLiveEvent
import kotlin.system.exitProcess

class MainMenuViewModel : BaseViewModel(){

    val startGame = SingleLiveEvent<Boolean>()

    fun playGame(){
        startGame.value = true
    }

    fun exit(){
        exitProcess(0)
    }
}