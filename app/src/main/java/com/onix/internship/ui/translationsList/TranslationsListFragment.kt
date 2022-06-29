package com.onix.internship.ui.translationsList

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.TranslationsListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TranslationsListFragment :
    BaseFragment<TranslationsListFragmentBinding>(R.layout.translations_list_fragment) {
    override val viewModel: TranslationsListViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val translationsAdapter = TranslationsAdapter()

        val recyclerView: RecyclerView = binding.textRecycler
        recyclerView.adapter = translationsAdapter

        viewModel.translationLivaData.observe(viewLifecycleOwner) {
            translationsAdapter.submitList(it)
        }

    }
}