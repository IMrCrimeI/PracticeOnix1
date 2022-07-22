package com.onix.internship.ui.bottomNavigation.settings

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.SettingsScreenFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsScreen :
    BaseFragment<SettingsScreenFragmentBinding>(R.layout.settings_screen_fragment) {
    override val viewModel: SettingsScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        binding.levelSlider.addOnChangeListener { _, value, _ ->
            binding.fromToLevelText.text = "${value.toInt()} ${getString(R.string.from_5)}"
            viewModel.setIntInSharPref(value.toInt())
        }
    }
}