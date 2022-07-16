package com.onix.internship.ui.calendarPicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.onix.internship.data.AppSettings
import com.onix.internship.databinding.CalendarDialogFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat


class CalendarDialogFragment : DialogFragment() {

    private lateinit var binding: CalendarDialogFragmentBinding
    private val viewModel: CalendarViewModel by viewModel()
    private val settings: AppSettings by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return CalendarDialogFragmentBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        val calendar = binding.calendarView
        val monthDate = SimpleDateFormat("MMMM")
        var selectedDate = ""
        calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val monthName = monthDate.format(month)
            selectedDate = "$dayOfMonth $monthName $year"
        }
        viewModel.backToFragment.observe(viewLifecycleOwner) {
            if (it) {
                settings.date.value = selectedDate
                findNavController().popBackStack()
            } else findNavController().popBackStack()
        }
    }
}

