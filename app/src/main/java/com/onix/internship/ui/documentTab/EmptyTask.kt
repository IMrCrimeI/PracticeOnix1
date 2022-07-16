package com.onix.internship.ui.documentTab

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.data.WeeksItem
import com.onix.internship.databinding.EmptyTaskFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmptyTask : BaseFragment<EmptyTaskFragmentBinding>(R.layout.empty_task_fragment) {

    override val viewModel: EmptyTaskViewModel by viewModel()

    private val test = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            Toast.makeText(requireContext(), "hello", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val weeksAdapter = WeeksAdapter { weeksItem -> adapterOnClick(weeksItem) }

        val recyclerView: RecyclerView = binding.calendarRecycler
        recyclerView.adapter = weeksAdapter

        requireActivity().onBackPressedDispatcher.addCallback(test)

        viewModel.weeksLiveData.observe(viewLifecycleOwner) {
            weeksAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        test.isEnabled = false
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.openCalendar.observe(viewLifecycleOwner) {
            navigate(R.id.calendarDialogFragment)
        }
    }

    private fun adapterOnClick(weeksItem: WeeksItem) {
        when (weeksItem.itemId) {
            2 -> {

            }
        }
    }
}