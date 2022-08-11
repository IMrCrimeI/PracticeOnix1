package com.onix.internship.ui.cropPhoto

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.R
import com.onix.internship.arch.BaseFragment
import com.onix.internship.arch.ext.navigate
import com.onix.internship.data.storage.ImageStorage
import com.onix.internship.databinding.CropPhotoFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CropPhotoFragment : BaseFragment<CropPhotoFragmentBinding>(R.layout.crop_photo_fragment) {
    override val viewModel: CropPhotoViewModel by viewModel()
    private val storage: ImageStorage by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.imageCropView.setImageBitmap(storage.getImg())
        binding.imageCropView.setAspectRatio(1, 1)

    }

    override fun setObservers() {
        viewModel.ratioEvent.observe(viewLifecycleOwner) {
            changeRatioCrop(it)
        }

        viewModel.cropEvent.observe(viewLifecycleOwner) {
            cropImage()
        }

        viewModel.saveEvent.observe(viewLifecycleOwner) {
            saveImage()
        }

        viewModel.restoreEvent.observe(viewLifecycleOwner) {
            restoreImage()
        }
    }

    private fun restoreImage() {
        binding.imageCropView.setImageBitmap(storage.restoreImage())
    }

    private fun saveImage() {
        storage.saveCroppedImage(binding.imageCropView.croppedImage)
        navigate(CropPhotoFragmentDirections.actionCropPhotoFragmentToEditPhotoFragment())
    }

    private fun cropImage() {
        val croppedImage = binding.imageCropView.croppedImage
        binding.imageCropView.setImageBitmap(croppedImage)
        storage.saveImage(croppedImage)
    }

    private fun changeRatioCrop(it: Pair<Int, Int>) {
        val widthRatio = it.first
        val heightRatio = it.second
        if (isPossibleCrop(widthRatio, heightRatio)) {
            binding.imageCropView.setAspectRatio(widthRatio, heightRatio)
        } else {
            Snackbar.make(binding.imageCropView, "Error", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun isPossibleCrop(widthRatio: Int, heightRatio: Int): Boolean {
        val bitmap = binding.imageCropView.viewBitmap
        bitmap?.let {
            val width = it.width
            val height = it.height
            return !(width < widthRatio && height < heightRatio)
        }
        return false
    }
}