package com.onix.internship.ui.bottomNavigation.settings

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.SettingsScreenFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsScreen :
    BaseFragment<SettingsScreenFragmentBinding>(R.layout.settings_screen_fragment) {
    override val viewModel: SettingsScreenViewModel by viewModel()

    private val sharedPref: SharedPreferences by inject()
    private val edit = sharedPref.edit()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        binding.levelSlider.addOnChangeListener { _, value, _ ->
            binding.fromToLevelText.text = "${value.toInt()} from 5"
            editSkillSharedPref(value.toInt())
        }

    }

    override fun setObservers() {
        super.setObservers()
        viewModel.changeSettings.observe(viewLifecycleOwner) {
            editRoleSharedPref()
        }
    }

    private fun editSkillSharedPref(it: Int) {
        edit.apply {
            putInt("skill", it)
            commit()
        }
    }

    private fun editRoleSharedPref() {
        edit.apply {
            putString("role", viewModel.role.value.toString())
            commit()
        }
    }
}