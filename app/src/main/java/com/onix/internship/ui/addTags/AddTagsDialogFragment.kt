package com.onix.internship.ui.addTags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.onix.internship.databinding.AddTagsDialogFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddTagsDialogFragment : DialogFragment() {

    private lateinit var binding: AddTagsDialogFragmentBinding
    private val viewModel: AddTagsDialogViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return AddTagsDialogFragmentBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        viewModel.backToFragment.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
    }
}