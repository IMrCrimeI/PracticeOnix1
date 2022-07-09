package com.onix.internship.ui.game.mainMenu

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.MainMenuFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMenu : BaseFragment<MainMenuFragmentBinding>(R.layout.main_menu_fragment) {

    override val viewModel: MainMenuViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.startGame.observe(viewLifecycleOwner) {
            showGameScreen()
        }
    }

    private fun showGameScreen() {
        navigate(MainMenuDirections.actionMainMenuToFirstScene())
    }
}