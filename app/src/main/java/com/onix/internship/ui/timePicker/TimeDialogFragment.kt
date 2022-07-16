package com.onix.internship.ui.timePicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.onix.internship.data.AppSettings
import com.onix.internship.data.DataAndTimeStates
import com.onix.internship.databinding.TimePickerFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class TimeDialogFragment : DialogFragment() {

    private lateinit var binding: TimePickerFragmentBinding
    private val viewModel: TimeDialogViewModel by viewModel()
    private val navArgs: TimeDialogFragmentArgs by navArgs()
    private val settings: AppSettings by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return TimePickerFragmentBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val time = binding.timePicker
        var selectedTime = ""
        time.setIs24HourView(true)
        time.setOnTimeChangedListener { _, hourOfDay, minute ->
            selectedTime = "${hourOfDay.toLong()} : ${minute.toLong()}"
        }

        viewModel.backToFragment.observe(viewLifecycleOwner) {
            if (it) {
                when (navArgs.states) {
                    DataAndTimeStates.FROM_TIME -> {
                        settings.fromTime.value = selectedTime
                    }
                    else -> {
                        settings.toTime.value = selectedTime
                    }
                }
                findNavController().popBackStack()
            } else findNavController().popBackStack()
        }
    }
}