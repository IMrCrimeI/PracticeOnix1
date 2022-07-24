package com.onix.internship.ui.bottomNavigation.map

import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.data.point.PointItem
import com.onix.internship.data.role.UserRole
import com.onix.internship.databinding.MapScreenFragmentBinding
import com.onix.internship.json.JsonFormatter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MapScreen : BaseFragment<MapScreenFragmentBinding>(R.layout.map_screen_fragment),
    OnMapReadyCallback {
    override val viewModel: MapScreenViewModel by viewModel()
    private val jsonFormatter: JsonFormatter by inject()

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var mMap: GoogleMap

    private var lastKnownLocation = Location(LocationManager.NETWORK_PROVIDER)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        val mapFragment = childFragmentManager.findFragmentById(
            R.id.google_map
        ) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.exportPosition.observe(viewLifecycleOwner) {
            exportUserData(viewModel.createPoint(lastKnownLocation))
        }

    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        mMap.isMyLocationEnabled = true
        getDeviceLocation(mMap)
        viewModel.mapPoints.observe(viewLifecycleOwner) {
            mMap.clear()
            it.forEach { point ->
                viewModel.createMapsPoint(
                    mMap,
                    point.location,
                    point,
                    getIcon(point)
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateMapsPoints()
    }

    private fun getDeviceLocation(map: GoogleMap) {
        val locationResult = fusedLocationProviderClient.lastLocation
        locationResult.addOnCompleteListener(requireActivity()) { task ->
            lastKnownLocation = task.result
            viewModel.showUserLocation(map, lastKnownLocation)
        }
    }

    private fun exportUserData(pointItem: PointItem) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, jsonFormatter.pointItemToJson(pointItem))
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun getIcon(point: PointItem): BitmapDescriptor {
        val icon: BitmapDescriptor = when (point.role) {
                UserRole.HERO -> BitmapDescriptorFactory.fromResource(R.drawable.ic_hero)
                UserRole.PLAYER -> BitmapDescriptorFactory.fromResource(R.drawable.ic_player)
                UserRole.MASTER -> BitmapDescriptorFactory.fromResource(R.drawable.ic_master)
                else -> BitmapDescriptorFactory.defaultMarker()
            }
        return icon
    }
}
