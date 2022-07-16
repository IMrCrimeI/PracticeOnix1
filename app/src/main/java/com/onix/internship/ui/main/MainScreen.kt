package com.onix.internship.ui.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.onix.internship.R
import com.onix.internship.arch.BaseActivity
import com.onix.internship.arch.ext.changeTintAndDrawable
import com.onix.internship.data.AppSettings
import com.onix.internship.data.TabStates
import com.onix.internship.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreen : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val appSettings: AppSettings by inject()
    override val viewModel: MainViewModel by viewModel()


    override val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.homeHostNavFragment) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        setStartTab()
    }

    override fun onBackPressed() {

    }
    override fun setObservers() {
        super.setObservers()
        viewModel.goToHome.observe(this) {
            when (it) {
                TabStates.HOME -> {
                    changeHomeTab()
                    navController.navigate(R.id.homeTabFragment)
                }
                TabStates.DOCUMENT -> {
                    changeDocumentTab()
                    navController.navigate(R.id.emptyTaskFragment)
                }
                TabStates.ADD_TASK -> {
                    appSettings.sale.set(true)
                    navController.navigate(R.id.addTaskFragment)
                }
                TabStates.ACTIVITY -> {
                    changeActivityTab()
                    navController.navigate(R.id.activityTabFragment)
                }
                TabStates.FOLDER -> {
                    changeFolderTab()
                    navController.navigate(R.id.folderTabFragment)
                }
                else -> {

                }
            }
        }
    }

    private fun setStartTab() {
        binding.homeTab.changeTintAndDrawable(R.drawable.ic_home, R.drawable.ic_nothing)
        binding.documentTab.changeTintAndDrawable(R.drawable.ic_document_dark, R.drawable.ic_circle)
        binding.activityTab.changeTintAndDrawable(R.drawable.ic_activity, R.drawable.ic_nothing)
        binding.folderTab.changeTintAndDrawable(R.drawable.ic_folder, R.drawable.ic_nothing)
    }

    private fun changeFolderTab() {
        binding.folderTab.changeTintAndDrawable(R.drawable.ic_folder_dark, R.drawable.ic_circle)
        binding.homeTab.changeTintAndDrawable(R.drawable.ic_home, R.drawable.ic_nothing)
        binding.documentTab.changeTintAndDrawable(R.drawable.ic_document, R.drawable.ic_nothing)
        binding.activityTab.changeTintAndDrawable(R.drawable.ic_activity, R.drawable.ic_nothing)
    }

    private fun changeActivityTab() {
        binding.activityTab.changeTintAndDrawable(R.drawable.ic_activity_dark, R.drawable.ic_circle)
        binding.homeTab.changeTintAndDrawable(R.drawable.ic_home, R.drawable.ic_nothing)
        binding.documentTab.changeTintAndDrawable(R.drawable.ic_document, R.drawable.ic_nothing)
        binding.folderTab.changeTintAndDrawable(R.drawable.ic_folder, R.drawable.ic_nothing)
    }

    private fun changeDocumentTab() {
        binding.documentTab.changeTintAndDrawable(R.drawable.ic_document_dark, R.drawable.ic_circle)
        binding.homeTab.changeTintAndDrawable(R.drawable.ic_home, R.drawable.ic_nothing)
        binding.activityTab.changeTintAndDrawable(R.drawable.ic_activity, R.drawable.ic_nothing)
        binding.folderTab.changeTintAndDrawable(R.drawable.ic_folder, R.drawable.ic_nothing)
    }

    private fun changeHomeTab() {
        binding.homeTab.changeTintAndDrawable(R.drawable.ic_home_dark, R.drawable.ic_circle)
        binding.documentTab.changeTintAndDrawable(R.drawable.ic_document, R.drawable.ic_nothing)
        binding.activityTab.changeTintAndDrawable(R.drawable.ic_activity, R.drawable.ic_nothing)
        binding.folderTab.changeTintAndDrawable(R.drawable.ic_folder, R.drawable.ic_nothing)
    }
}