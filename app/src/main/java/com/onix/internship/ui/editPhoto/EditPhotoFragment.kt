package com.onix.internship.ui.editPhoto

import android.graphics.*
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.PixelCopy
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.data.storage.DeviceGalleryInjector
import com.onix.internship.data.storage.ImageStorage
import com.onix.internship.databinding.EditPhotoFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException


class EditPhotoFragment : BaseFragment<EditPhotoFragmentBinding>(R.layout.edit_photo_fragment) {
    override val viewModel: EditPhotoViewModel by viewModel()
    private val storage: ImageStorage by inject()
    private val galleryInjector: DeviceGalleryInjector by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.editableImage.setImageBitmap(storage.getImg())

        editPhoto()
        changeImageShade()
    }

    override fun setObservers() {
        super.setObservers()

        viewModel.saveImageInFolder.observe(viewLifecycleOwner) {
            saveImage()
        }
    }

    private fun editPhoto() {
        binding.sliderEditor.addOnChangeListener { _, value, _ ->
            viewModel.onAttributeChanged(value)
        }
    }

    private fun changeImageShade() {
        binding.colorSeekBar.setOnColorChangeListener(object :
            ColorSeekBar.OnColorChangeListener {
            override fun onColorChangeListener(color: Int) {
                binding.editableImage.colorFilter = LightingColorFilter(color, Color.BLACK)
            }
        })
    }

    private fun saveImage() {
        try {
            galleryInjector.saveMediaIntoGallery(createFilteredImage())
            Snackbar.make(binding.editableImage, "Photo save", Snackbar.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Snackbar.make(binding.editableImage, "Save error", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun createFilteredImage(): Bitmap {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val bitmap = Bitmap.createBitmap(
                binding.editableImage.width,
                binding.editableImage.height,
                Bitmap.Config.ARGB_8888
            )
            val location = IntArray(2)
            binding.editableImage.getLocationInWindow(location)
            PixelCopy.request(
                requireActivity().window,
                Rect(
                    location[0],
                    location[1],
                    location[0] + binding.editableImage.width,
                    location[1] + binding.editableImage.height
                ),
                bitmap,
                {
                    if (it == PixelCopy.SUCCESS) {
                        val canvas = Canvas(bitmap)

                        val paint = Paint()
                        paint.colorFilter = binding.editableImage.colorFilter

                        canvas.drawBitmap(bitmap, 0f, 0f, paint)
                    }
                },
                Handler(Looper.getMainLooper())
            )
            return bitmap
        } else {
            val tBitmap = Bitmap.createBitmap(
                binding.editableImage.width, binding.editableImage.height, Bitmap.Config.RGB_565
            )
            val canvas = Canvas(tBitmap)

            val paint = Paint()
            paint.colorFilter = binding.editableImage.colorFilter
            canvas.drawBitmap(tBitmap, 0f, 0f, paint)
            return tBitmap
        }
    }
}