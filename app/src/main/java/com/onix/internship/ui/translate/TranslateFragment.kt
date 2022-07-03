package com.onix.internship.ui.translate

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.TranslateFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TranslateFragment : BaseFragment<TranslateFragmentBinding>(R.layout.translate_fragment) {

    override val viewModel: TranslateViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        val historyAdapter = HistoryAdapter()

        val recyclerView: RecyclerView = binding.historyRecycler
        recyclerView.adapter = historyAdapter

        viewModel.translationLivaData.observe(viewLifecycleOwner) {
            Log.d("Debug", viewModel.languageChoice.toString())
            historyAdapter.submitList(it)
        }
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.initEvent.observe(viewLifecycleOwner) {
            navigate(TranslateFragmentDirections.actionTranslateFragmentToRusultsListFragment())
        }
    }
}