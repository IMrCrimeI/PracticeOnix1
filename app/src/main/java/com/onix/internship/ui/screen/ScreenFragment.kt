package com.onix.internship.ui.screen

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.ScreenFragmentBinding
import com.onix.internship.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScreenFragment: BaseFragment<ScreenFragmentBinding>(R.layout.screen_fragment) {
    override val viewModel: SplashViewModel by viewModel()

}