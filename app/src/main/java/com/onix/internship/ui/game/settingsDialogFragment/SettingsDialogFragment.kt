package com.onix.internship.ui.game.settingsDialogFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SettingsDialogFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsDialogFragment : DialogFragment() {

    private lateinit var binding: SettingsDialogFragmentBinding
    private val viewModel: SettingsDialogFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return SettingsDialogFragmentBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        viewModel.goToHome.observe(viewLifecycleOwner) {
            navigate(SettingsDialogFragmentDirections.actionSettingsDialogFragmentToMainMenu())
        }
    }
}