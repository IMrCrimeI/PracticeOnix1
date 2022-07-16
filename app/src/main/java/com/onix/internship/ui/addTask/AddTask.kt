package com.onix.internship.ui.addTask

import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.data.DataAndTimeStates
import com.onix.internship.data.TagsItem
import com.onix.internship.databinding.AddTaskFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddTask : BaseFragment<AddTaskFragmentBinding>(R.layout.add_task_fragment) {
    override val viewModel: AddTaskViewModel by viewModel()
    private val navArgs: AddTaskArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        updateList()

        val tagsAdapter = TagsAdapter { tagsItem -> adapterOnClick(tagsItem) }
        val recyclerView: RecyclerView = binding.tagsRecycler
        recyclerView.adapter = tagsAdapter

        viewModel.tagsLiveData.observe(viewLifecycleOwner) {
            tagsAdapter.submitList(it)
        }
    }

    override fun setObservers() {
        super.setObservers()
        val popUp = binding.popUpMenu
        viewModel.goToDocumentTab.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
        viewModel.openAddTagsFragment.observe(viewLifecycleOwner) {
            navigate(AddTaskDirections.actionAddTaskFragmentToAddTagsDialogFragment())
        }
        viewModel.openPopupMenu.observe(viewLifecycleOwner) {
            val popup = PopupMenu(context, popUp)
            popup.menuInflater.inflate(R.menu.pop_up_menu, popup.menu)
            popup.show()
        }
        viewModel.openDataOrTimePicker.observe(viewLifecycleOwner) {
            when (it) {
                DataAndTimeStates.DATA -> navigate(AddTaskDirections.actionAddTaskFragmentToCalendarDialogFragment())

                DataAndTimeStates.FROM_TIME -> navigate(
                    AddTaskDirections.actionAddTaskFragmentToTimeDialogFragment(
                        it
                    )
                )

                else -> navigate(AddTaskDirections.actionAddTaskFragmentToTimeDialogFragment(it))
            }
        }
    }

    fun updateList() {
        if (navArgs.tagsName != "default") {
            viewModel.updateRecyclerItem(navArgs.tagsName)
        }
    }

    private fun adapterOnClick(tagsItem: TagsItem) {
        when (tagsItem.tagsId) {
            0 -> {

            }
        }
    }
}