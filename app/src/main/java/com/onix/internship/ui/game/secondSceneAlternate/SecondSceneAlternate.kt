package com.onix.internship.ui.game.secondSceneAlternate

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SecondSceneAlternateFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondSceneAlternate :
    BaseFragment<SecondSceneAlternateFragmentBinding>(R.layout.second_scene_alternate_fragment) {
    override val viewModel: SecondSceneAlternateViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.goToHome.observe(viewLifecycleOwner) {
            goToHome()
        }
        viewModel.openSettingFragment.observe(viewLifecycleOwner){
            navigate(SecondSceneAlternateDirections.actionSecondSceneAlternateToSettingsDialogFragment())
        }
    }

    private fun goToHome() {
        navigate(SecondSceneAlternateDirections.actionSecondSceneAlternateToMainMenu2())
    }
}