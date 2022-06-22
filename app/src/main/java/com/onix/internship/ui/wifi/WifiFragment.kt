package com.onix.internship.ui.wifi

import android.net.wifi.ScanResult
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.WifiFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class WifiFragment : BaseFragment<WifiFragmentBinding>(R.layout.wifi_fragment) {
    override val viewModel: WifiViewModel by viewModel()

    private var listId = mutableListOf<TextView>()

    private var amountView = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        viewModel.scanResult.observe(viewLifecycleOwner, ::addView)
    }

    private fun addView(data: List<ScanResult>) {
        val constraintLayout: ConstraintLayout = binding.mainContainer

        listId.forEach {
            constraintLayout.removeView(it)
        }
        listId = mutableListOf()

        binding.root.post {
            repeat(data.size) {
                val textView = TextView(context)

                textView.setPadding(10, 10, 10, 10)
                textView.gravity = Gravity.CENTER
                textView.height = 150
                textView.width = 150
                textView.background =
                    ContextCompat.getDrawable(requireContext(), R.drawable.online_indicator)
                textView.text = data[it].SSID
                textView.setOnClickListener { _ ->
                    navigate(
                        WifiFragmentDirections.actionWifiFragmentToWifiDetailDialogFragment(
                            data[it].SSID,
                            data[it].level
                        )
                    )
                }

                constraintLayout.addView(textView)

                val params = textView.layoutParams as ConstraintLayout.LayoutParams

                params.circleConstraint = R.id.centerView
                params.circleAngle = amountView

                amountView += 360f / data.size.toFloat()

                if (data[it].level > -50) params.circleRadius = constraintLayout.width / 7
                else if (data[it].level > -80 && data[it].level < -50) params.circleRadius =
                    constraintLayout.width / 5
                else params.circleRadius = constraintLayout.width / 3
                textView.layoutParams = params

                listId.add(textView)
            }
        }
    }
}