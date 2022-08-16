package com.onix.internship.ui.selectPhoto

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.databinding.SelectPhotoFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.IOException


class SelectPhotoFragment :
    BaseFragment<SelectPhotoFragmentBinding>(R.layout.select_photo_fragment) {
    override val viewModel: SelectPhotoViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        requestPermissionLauncher.launch(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {

        }

    override fun setObservers() {
        super.setObservers()

        viewModel.fromGallery.observe(viewLifecycleOwner) {
            getImageFromGallery()
        }
        viewModel.fromCamera.observe(viewLifecycleOwner) {
            getImageFromCamera()
        }
    }

    private fun getImageFromGallery() {
        fromGallery.launch(
            Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
        )
    }

    private fun getImageFromCamera() {
        fromCamera.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
    }

    private val fromGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        createBitmapFromGallery(result)
    }

    private fun createBitmapFromGallery(result: ActivityResult) {
        try {
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.let { intent ->
                    intent.data?.let {
                        if (Build.VERSION.SDK_INT < 28) {
                            val bitmap = MediaStore.Images.Media.getBitmap(
                                requireActivity().contentResolver,
                                it
                            )
                            viewModel.saveImageToStorage(bitmap)
                        } else {
                            val source = ImageDecoder.createSource(
                                requireActivity().contentResolver,
                                it
                            )
                            viewModel.saveImageToStorage(ImageDecoder.decodeBitmap(source))
                        }
                        navigate(SelectPhotoFragmentDirections.actionSelectPhotoFragmentToCropPhotoFragment())
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    private val fromCamera = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        createBitmapFromCamera(result)
    }

    private fun createBitmapFromCamera(result: ActivityResult) {
        try {
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.let { intent ->
                    intent.extras?.let {
                        val imageBitmap = it.get("data") as Bitmap
                        viewModel.saveImageToStorage(imageBitmap)
                        navigate(SelectPhotoFragmentDirections.actionSelectPhotoFragmentToCropPhotoFragment())
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}