package com.onix.internship.ui.wifi

import android.net.wifi.ScanResult
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DimenRes
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


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {
        if (it.containsValue(false)) {
            Toast.makeText(
                activity, getString(R.string.no_access_permission),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private var amountView = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        requestPermissionLauncher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
        viewModel.scanResult.observe(viewLifecycleOwner, ::addView)
    }

    private fun addView(data: List<ScanResult>) {
        val constraintLayout: ConstraintLayout = binding.mainContainer

        listId.forEach {
            constraintLayout.removeView(it)
        }
        listId.clear()

        binding.root.post {
            repeat(data.size) {
                val textView = addView(data, it, constraintLayout)
                changeViewParams(textView, data, it)
                listId.add(textView)
            }
            Log.d("wifi123", listId.toString())
        }
    }

    private fun addView(
        data: List<ScanResult>,
        it: Int,
        constraintLayout: ConstraintLayout
    ): TextView {
        val textView = TextView(context)

        textView.setPadding(PADDING, PADDING, PADDING, PADDING)
        textView.tag = data[it].level
        textView.gravity = Gravity.CENTER
        textView.height = HEIGHT
        textView.width = WIDTH
        textView.maxLines = MAX_LINE
        textView.ellipsize = TextUtils.TruncateAt.END
        textView.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.wifi_indicator)
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
        return textView
    }

    private fun changeViewParams(
        textView: TextView,
        data: List<ScanResult>,
        it: Int,
    ) {
        val params = textView.layoutParams as ConstraintLayout.LayoutParams
        params.circleConstraint = R.id.centerView
        params.circleAngle = amountView
        amountView += 360f / data.size.toFloat()

        params.circleRadius = when {
            data[it].level >= -50 -> getDimenPx(R.dimen.first_circle_radius) / 2
            data[it].level > -80 && data[it].level < -50 -> getDimenPx(R.dimen.second_circle_radius) / 2
            else -> getDimenPx(R.dimen.third_circle_radius) / 2
        }
        textView.layoutParams = params
    }

    private fun getDimenPx(@DimenRes resId: Int) = resources.getDimensionPixelSize(resId)

    companion object {
        const val PADDING = 10
        const val HEIGHT = 120
        const val WIDTH = 120
        const val MAX_LINE = 2
    }
}