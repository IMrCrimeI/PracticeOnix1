package com.onix.internship.ui.firstSetting.role

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.RoleVerificationFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoleVerification :
    BaseFragment<RoleVerificationFragmentBinding>(R.layout.role_verification_fragment) {
    override val viewModel: RoleVerificationViewModel by viewModel()

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
            navigate(RoleVerificationDirections.actionRoleVerificationToBottomNavigation())
        } else findNavController().popBackStack()
    }

}