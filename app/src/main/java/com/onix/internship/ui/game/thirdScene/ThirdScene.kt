package com.onix.internship.ui.game.thirdScene

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.ThirdSceneFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdScene : BaseFragment<ThirdSceneFragmentBinding>(R.layout.third_scene_fragment) {

    override val viewModel: ThirdSceneViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.goToHome.observe(viewLifecycleOwner) {
            goToHome()
        }
        viewModel.openSettingFragment.observe(viewLifecycleOwner) {
            navigate(ThirdSceneDirections.actionThirdSceneToSettingsDialogFragment())
        }
    }

    private fun goToHome() {
        navigate(ThirdSceneDirections.actionThirdSceneToMainMenu())
    }
}