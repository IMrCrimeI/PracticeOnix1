package com.onix.internship.ui.result

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.FragmentResultBinding
import com.onix.internship.ui.result.adapter.RecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    override val viewModel: ResultViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listOfBird.observe(viewLifecycleOwner) {
            val notesAdapter = RecyclerViewAdapter(viewModel)

            binding.notesRecycler.adapter = notesAdapter

            viewModel.listOfBird.observe(viewLifecycleOwner) {
                notesAdapter.submitList(it)
                binding.requestProgress.isIndeterminate = false
            }
        }
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.goToDetails.observe(viewLifecycleOwner){
            navigateToDetailsFragment()
        }
    }

    private fun navigateToDetailsFragment() {
        navigate(ResultFragmentDirections.actionResultFragmentToDetailsFragment())
    }
}