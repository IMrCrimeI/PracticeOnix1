package com.onix.internship.ui.bottomNavigation.points

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.data.point.PointItem
import com.onix.internship.databinding.PointsScreenFragmentBinding
import com.onix.internship.json.JsonFormatter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PointsScreen : BaseFragment<PointsScreenFragmentBinding>(R.layout.points_screen_fragment) {
    override val viewModel: PointsScreenViewModel by viewModel()
    private val jsonFormatter: JsonFormatter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        val pointsAdapter = PointsAdapter { pointsItem -> adapterOnClick(pointsItem) }

        val recyclerView: RecyclerView = binding.pointsRecycler
        recyclerView.adapter = pointsAdapter

        viewModel.pointsLiveData.observe(viewLifecycleOwner) {
            pointsAdapter.submitList(it)
        }
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.addPoint.observe(viewLifecycleOwner) {
            addPoint()
        }
    }

    private fun addPoint() {
        val clipBoardManager =
            requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val copiedString = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()

        copiedString?.let {
            val point = jsonFormatter.jsonToPointItem(it)
            viewModel.addItemInRecyclerItem(point)
        }
    }

    private fun adapterOnClick(item: PointItem) {
        viewModel.removeItemFromRecyclerItem(item)
    }
}