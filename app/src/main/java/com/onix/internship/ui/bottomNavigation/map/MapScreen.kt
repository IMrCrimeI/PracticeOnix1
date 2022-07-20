package com.onix.internship.ui.bottomNavigation.map

import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.MapScreenFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapScreen : BaseFragment<MapScreenFragmentBinding>(R.layout.map_screen_fragment) {
    override val viewModel: MapScreenViewModel by viewModel()

}