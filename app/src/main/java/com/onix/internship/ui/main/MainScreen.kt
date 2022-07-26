package com.onix.internship.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseActivity
import com.onix.internship.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreen : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModel()

    override val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.homeHostNavFragment) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.topAppBar)

        binding.navView.setupWithNavController(navController)
        setupActionBarWithNavController(this, navController, binding.drawerLayout)

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
//                R.id.sort ->
                else -> false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigateUp(
            navController,
            binding.drawerLayout
        )
    }
}