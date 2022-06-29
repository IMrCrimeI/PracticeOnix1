package com.onix.internship.ui.translate

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.TranslateFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TranslateFragment :
    BaseFragment<TranslateFragmentBinding>(R.layout.translate_fragment),
    AdapterView.OnItemSelectedListener {

    override val viewModel: TranslateViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        fillSpinners()

        val translationsAdapter = HistoryAdapter()

        val recyclerView: RecyclerView = binding.historyRecycler
        recyclerView.adapter = translationsAdapter

        viewModel.translationLivaData.observe(viewLifecycleOwner) {
            translationsAdapter.submitList(it)
        }
    }

    private fun fillSpinners() {
        val spinner: Spinner = binding.spinSelectLanguage

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.language_selection,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

    }

    override fun setObservers() {
        super.setObservers()
        viewModel.initEvent.observe(viewLifecycleOwner) {
            navigate(TranslateFragmentDirections.actionTranslateFragmentToTranslationsListFragment())
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}