package com.onix.internship.ui.display

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.DisplayFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DisplayFragment : BaseFragment<DisplayFragmentBinding>(R.layout.display_fragment) {

    override val viewModel: DisplayViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


    }

    override fun setObservers() {
        viewModel.initEvent.observe(this) {
            showChoiceFragment()
        }
    }

    private fun showChoiceFragment() {
        navigate(DisplayFragmentDirections.actionDisplayFragmentToChoiceFragment())
    }
}