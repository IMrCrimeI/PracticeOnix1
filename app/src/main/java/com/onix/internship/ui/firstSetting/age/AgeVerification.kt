package com.onix.internship.ui.firstSetting.age

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.AgeVerificationFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AgeVerification :
    BaseFragment<AgeVerificationFragmentBinding>(R.layout.age_verification_fragment) {
    override val viewModel: AgeVerificationViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.moveToFragment.observe(viewLifecycleOwner) {
            navigate(it)
        }
    }

    private fun navigate(it: Boolean) {

        if (it) {
            navigate(AgeVerificationDirections.actionAgeVerificationToSkillVerification())
        } else {
            Snackbar.make(
                binding.mainContainer,
                getString(R.string.age_error),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}