package com.onix.internship.ui.splash

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.data.repository.AppSharedPreferences
import com.onix.internship.databinding.SplashFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashFragmentBinding>(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModel()

    private val sharedPref: AppSharedPreferences by inject()

    override fun setObservers() {
        viewModel.initEvent.observe(this) {
            showAgeVerificationScreen()
        }
    }

    private fun showAgeVerificationScreen() {
        if (sharedPref.getBooleanFromSharPref()) {
            navigate(SplashFragmentDirections.actionSplashFragmentToBottomNavigation())
        } else navigate(SplashFragmentDirections.actionSplashFragmentToAgeVerification())
    }
}