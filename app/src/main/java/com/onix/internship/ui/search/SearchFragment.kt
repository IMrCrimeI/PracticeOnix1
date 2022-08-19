package com.onix.internship.ui.search

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.FragmentSearchBinding
import com.onix.internship.network.NetworkStateManager
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
            val internetState = NetworkStateManager.getInstance(requireContext())
            if (internetState.isOnline) {
                navigateToResult(it)
            } else {
                showMassage()
            }
        }
    }

    private fun showMassage() {
        Snackbar.make(
            binding.searchInputText,
            "The app needs internet to work!",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun navigateToResult(searchQuery: String) {
        navigate(HomeFragmentDirections.actionHomeFragmentToResultFragment(searchQuery))
    }
}