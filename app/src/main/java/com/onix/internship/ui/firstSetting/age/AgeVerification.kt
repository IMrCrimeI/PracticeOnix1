package com.onix.internship.ui.firstSetting.age

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.AgeVerificationFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgeVerification :
    BaseFragment<AgeVerificationFragmentBinding>(R.layout.age_verification_fragment) {
    override val viewModel: AgeVerificationViewModel by viewModel()

    private val sharedPref: SharedPreferences by inject()
    private val edit = sharedPref.edit()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.moveToFragment.observe(viewLifecycleOwner) {
            editSharedPref(it)
            navigate(it)
        }
    }

    private fun editSharedPref(it: Boolean) {
        edit.apply {
            putBoolean("age", it)
            commit()
        }
    }

    private fun navigate(it: Boolean) {
        if (it) {
            navigate(AgeVerificationDirections.actionAgeVerificationToSkillVerification())
        } else {
            Toast.makeText(
                context,
                "К сожалению, вы не можете использовать это приложение!!!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}