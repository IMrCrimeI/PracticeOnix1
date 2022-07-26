package com.onix.internship.ui.emergency.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.onix.internship.databinding.EmergencyDialogFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmergencyDialogFragment : DialogFragment() {

    private lateinit var binding: EmergencyDialogFragmentBinding
    private val viewModel: EmergencyDialogFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return EmergencyDialogFragmentBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        viewModel.moveBack.observe(viewLifecycleOwner) {
            backToEmergency(it)
        }
    }

    private fun backToEmergency(it: Boolean) {
        if (it) {
            viewModel.deleteAllNotes()
        }
        findNavController().popBackStack()
    }
}