package com.onix.internship.ui.advanced_search

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.FragmentAdvancedSearchBinding
import com.onix.internship.network.NetworkStateManager
import com.onix.internship.ui.home.HomeFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdvancedSearchFragment :
    BaseFragment<FragmentAdvancedSearchBinding>(R.layout.fragment_advanced_search),
    AdapterView.OnItemSelectedListener {
    override val viewModel: AdvancedSearchViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        createSpinner()
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

    private fun createSpinner() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.countries_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.countrySpinner.adapter = adapter
            binding.countrySpinner.onItemSelectedListener = this
        }
    }

    private fun showMassage() {
        Snackbar.make(
            binding.searchButton,
            "The app needs internet to work!",
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private fun navigateToResult(searchQueue: String) {
        navigate(HomeFragmentDirections.actionHomeFragmentToResultFragment(searchQueue))
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val country = resources.getStringArray(R.array.countries_array)
        viewModel.model.cnt.set(country[position])
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}
