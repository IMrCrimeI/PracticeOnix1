package com.onix.internship.ui.bottomNavigation.points

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.PointsScreenFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PointsScreen : BaseFragment<PointsScreenFragmentBinding>(R.layout.points_screen_fragment) {
    override val viewModel: PointsScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val pointsAdapter = PointsAdapter { pointsItem -> adapterOnClick() }

        val recyclerView: RecyclerView = binding.pointsRecycler
        recyclerView.adapter = pointsAdapter

        viewModel.pointsLiveData.observe(viewLifecycleOwner) {
            pointsAdapter.submitList(it)
        }
    }

    private fun adapterOnClick() {

    }
}