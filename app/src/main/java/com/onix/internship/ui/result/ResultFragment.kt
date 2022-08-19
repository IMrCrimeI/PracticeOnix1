package com.onix.internship.ui.result

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.FragmentResultBinding
import com.onix.internship.entity.BirdInfo
import com.onix.internship.ui.result.adapter.RecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    override val viewModel: ResultViewModel by viewModel()
    private val navArgs: ResultFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBirdAdapter()

        viewModel.getBirdListFromApi(navArgs.searchQuery)
    }

    override fun onPause() {
        super.onPause()

        viewModel.stopMusic()
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.goToDetails.observe(viewLifecycleOwner) {
            navigateToDetailsFragment(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            showErrorMessage(it)
        }
    }

    private fun setBirdAdapter() {
        val notesAdapter = RecyclerViewAdapter(viewModel)

        binding.notesRecycler.adapter = notesAdapter

        viewModel.listOfBird.observe(viewLifecycleOwner) {
            notesAdapter.submitList(it)
            binding.requestProgress.isIndeterminate = false
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(binding.requestProgress, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun navigateToDetailsFragment(bird: BirdInfo) {
        navigate(ResultFragmentDirections.actionResultFragmentToDetailsFragment(bird))
    }
}