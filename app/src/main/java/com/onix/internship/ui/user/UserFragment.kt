package com.onix.internship.ui.user

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.FragmentUserBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment<FragmentUserBinding>(R.layout.fragment_user) {
    override val viewModel: UserViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.moveToResult.observe(viewLifecycleOwner) {
            moveToResult()
        }
    }

    private fun moveToResult() {
        navigate(UserFragmentDirections.actionUserFragmentToUserResultFragment())
    }
}