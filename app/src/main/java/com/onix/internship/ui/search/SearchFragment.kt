package com.onix.internship.ui.search

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.FragmentSearchBinding
import com.onix.internship.ui.home.HomeFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override val viewModel: SearchViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.goToResult.observe(viewLifecycleOwner) {
            navigateToResult()
        }
    }

    private fun navigateToResult() {
        navigate(HomeFragmentDirections.actionHomeFragmentToResultFragment())
    }
}