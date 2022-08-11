package com.onix.internship.ui.editPhoto

import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import com.google.android.material.slider.Slider
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.data.storage.ImageStorage
import com.onix.internship.databinding.EditPhotoFragmentBinding
import com.onix.internship.ui.editPhoto.injector.DeviceGalleryInjector
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class EditPhotoFragment : BaseFragment<EditPhotoFragmentBinding>(R.layout.edit_photo_fragment) {
    override val viewModel: EditPhotoViewModel by viewModel()
    private val storage: ImageStorage by inject()
    private val galleryInjector: DeviceGalleryInjector by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.editableImage.setImageBitmap(storage.getImg())

        changeImageContrast()
        changeImageBrightness()
        changeImageSaturation()
        changeImageShade()
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.saveImageInFolder.observe(viewLifecycleOwner) {
            galleryInjector.saveImage(binding.editableImage, requireActivity())
        }

        viewModel.restoreImage.observe(viewLifecycleOwner) {
            binding.editableImage.setImageBitmap(storage.restoreImage())
        }
    }

    private fun changeImageContrast() {
        binding.contrastSlider.addOnChangeListener { rangeSlider, value, fromUser ->
            binding.editableImage.contrast = value
        }

        binding.contrastSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
            }

            override fun onStopTrackingTouch(slider: Slider) {
                storage.saveImage(binding.editableImage.drawable.toBitmap())
            }
        })
    }

    private fun changeImageBrightness() {
        binding.brightnessSlider.addOnChangeListener { rangeSlider, value, fromUser ->
            binding.editableImage.brightness = value
        }

        binding.brightnessSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
            }

            override fun onStopTrackingTouch(slider: Slider) {
                storage.saveImage(binding.editableImage.drawable.toBitmap())
            }
        })
    }

    private fun changeImageSaturation() {
        binding.saturationSlider.addOnChangeListener { rangeSlider, value, fromUser ->
            binding.editableImage.saturation = value
        }

        binding.saturationSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
            }

            override fun onStopTrackingTouch(slider: Slider) {
                storage.saveImage(binding.editableImage.drawable.toBitmap())
            }
        })
    }

    private fun changeImageShade() {
        binding.colorSeekBar.setOnColorChangeListener(object :
            ColorSeekBar.OnColorChangeListener {
            override fun onColorChangeListener(color: Int) {
                binding.editableImage.colorFilter = LightingColorFilter(color, Color.BLACK)
            }
        })
    }
}