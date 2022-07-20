package com.onix.internship.ui.firstSetting.skill

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SkillVerificationFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SkillVerification :
    BaseFragment<SkillVerificationFragmentBinding>(R.layout.skill_verification_fragment) {
    override val viewModel: SkillVerificationViewModel by viewModel()

    private val sharedPref: SharedPreferences by inject()
    private val edit = sharedPref.edit()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        binding.levelSlider.addOnChangeListener { _, value, _ ->
            binding.fromToLevelText.text = "${value.toInt()} from 5"
            editSharedPref(value.toInt())
        }
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.moveToFragment.observe(viewLifecycleOwner) {
            navigate(it)
        }
    }

    private fun editSharedPref(it: Int) {
        edit.apply {
            putInt("skill", it)
            commit()
        }
    }

    private fun navigate(it: Boolean) {
        if (it) {
            navigate(SkillVerificationDirections.actionSkillVerificationToRoleVerification())
        } else findNavController().popBackStack()
    }
}