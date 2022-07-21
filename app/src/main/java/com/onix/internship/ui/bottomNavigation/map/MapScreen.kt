package com.onix.internship.ui.bottomNavigation.map

import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.MapScreenFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapScreen : BaseFragment<MapScreenFragmentBinding>(R.layout.map_screen_fragment),
    OnMapReadyCallback {
    override val viewModel: MapScreenViewModel by viewModel()

    override fun onMapReady(map: GoogleMap) {

    }

}