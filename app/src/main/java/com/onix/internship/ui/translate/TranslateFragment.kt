package com.onix.internship.ui.translate

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.TranslateFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TranslateFragment : BaseFragment<TranslateFragmentBinding>(R.layout.translate_fragment) {

    override val viewModel: TranslateViewModel by viewModel()
}