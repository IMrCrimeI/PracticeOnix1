package com.onix.internship.ui.game.firstScene

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.FirstSceneFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstScene : BaseFragment<FirstSceneFragmentBinding>(R.layout.first_scene_fragment) {

    override val viewModel: FirstSceneViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.goToNextFragment.observe(viewLifecycleOwner) {
            if (it) {
                showRightAwayFragment()
            } else showEndFragment()
        }
        viewModel.openSettingFragment.observe(viewLifecycleOwner) {
            navigate(FirstSceneDirections.actionFirstSceneToSettingsDialogFragment())
        }
    }

    private fun showRightAwayFragment() {
        navigate(FirstSceneDirections.actionFirstSceneToSecondScene())
    }

    private fun showEndFragment() {
        navigate(FirstSceneDirections.actionFirstSceneToSecondSceneAlternate())
    }
}