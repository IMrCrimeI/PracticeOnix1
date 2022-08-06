package com.onix.internship.ui.notesList

import android.os.Bundle
import android.view.View
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.NotesListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NotesListFragment : BaseFragment<NotesListFragmentBinding>(R.layout.notes_list_fragment) {
    override val viewModel: NotesListFragmentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        val notesAdapter = NotesAdapter(expandNote = { viewModel.expandNote(it) }, editNote = {})
        binding.notesRecycler.adapter = notesAdapter

        viewModel.updateNotesItem()

        viewModel.notesList.observe(viewLifecycleOwner) {
            notesAdapter.submitList(it)
        }
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.moveNext.observe(viewLifecycleOwner) {
            goToAddNoteFragment()
        }
    }

    private fun goToAddNoteFragment() {
        navigate(NotesListFragmentDirections.actionNotesListFragmentToAddNoteFragment())
    }
}