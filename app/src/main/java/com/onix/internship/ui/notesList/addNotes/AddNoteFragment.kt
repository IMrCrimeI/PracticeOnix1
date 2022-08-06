package com.onix.internship.ui.notesList.addNotes

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.databinding.AddNoteFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNoteFragment : BaseFragment<AddNoteFragmentBinding>(R.layout.add_note_fragment) {
    override val viewModel: AddNoteFragmentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.moveBack.observe(viewLifecycleOwner){
            findNavController().popBackStack()
        }
    }
}