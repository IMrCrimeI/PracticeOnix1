package com.onix.internship.ui.game.secondScene

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SecondSceneFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondScene :
    BaseFragment<SecondSceneFragmentBinding>(R.layout.second_scene_fragment) {

    override val viewModel: SecondSceneViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.goToNextFragment.observe(viewLifecycleOwner) {
            goToMerryFragment()
        }
        viewModel.openSettingFragment.observe(viewLifecycleOwner){
            navigate(SecondSceneDirections.actionSecondSceneToSettingsDialogFragment())
        }
    }

    private fun goToMerryFragment() {
        navigate(SecondSceneDirections.actionSecondSceneToThirdScene())
    }
}