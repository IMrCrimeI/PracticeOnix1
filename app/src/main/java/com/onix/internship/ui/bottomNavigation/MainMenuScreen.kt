package com.onix.internship.ui.bottomNavigation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.MainMenuScreenFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainMenuScreen :
    BaseFragment<MainMenuScreenFragmentBinding>(R.layout.main_menu_screen_fragment) {
    override val viewModel: MainMenuScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost =
            childFragmentManager.findFragmentById(R.id.bottomHostNavFragment) as NavHostFragment
        val navController = navHost.navController
        binding.bottomNavigation.setupWithNavController(navController)
    }
}