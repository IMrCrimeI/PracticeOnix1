package com.onix.internship.ui.addSensor

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.setupSpinner
import com.onix.internship.databinding.AddSensorFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddSensorFragment : BaseFragment<AddSensorFragmentBinding>(R.layout.add_sensor_fragment) {
    override val viewModel: AddSensorViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        setTypeSpinner()
        setSubTypeSpinner()
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.moveBack.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
    }

    private fun setTypeSpinner() {
        binding.typeSpinnerChoice.setupSpinner(R.array.type, object :OnSpinnerItemClick{
            override fun onItemClick(position: Int) {
                viewModel.setType(position)
            }
        })
    }

    private fun setSubTypeSpinner() {
        binding.subTypeSpinnerChoice.setupSpinner(R.array.sub_type, object :OnSpinnerItemClick{
            override fun onItemClick(position: Int) {
                viewModel.setSubType(position)
            }
        })
    }
}