package com.onix.internship.ui.homeTab

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.HomeTabFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeTab : BaseFragment<HomeTabFragmentBinding>(R.layout.home_tab_fragment) {

    override val viewModel: HomeTabViewModel by viewModel()
}