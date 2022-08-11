package com.onix.internship.ui.editPhoto.injector

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.*
import android.provider.MediaStore
import android.view.PixelCopy
import androidx.annotation.RequiresApi
import androidx.constraintlayout.utils.widget.ImageFilterView
import com.google.android.material.snackbar.Snackbar
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class DeviceGalleryInjector(private val context: Context) {

    fun saveImage(filterImage: ImageFilterView, activity: Activity) {
        val fileExported =
            File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).path,
                "Image.png"
            )
        try {
            FileOutputStream(fileExported).use { out ->
                createFilteredImage(filterImage, activity)
                    .compress(Bitmap.CompressFormat.PNG, 100, out)
            }
            saveMediaIntoGallery(fileExported)
            Snackbar.make(filterImage, "Photo save", Snackbar.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Snackbar.make(filterImage, "Save error", Snackbar.LENGTH_SHORT).show()
        }
        fileExported.delete()
    }

    private fun createFilteredImage(view: ImageFilterView, activity: Activity): Bitmap {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
            val location = IntArray(2)
            view.getLocationInWindow(location)
            PixelCopy.request(
                activity.window,
                Rect(location[0], location[1], location[0] + view.width, location[1] + view.height),
                bitmap,
                {
                    if (it == PixelCopy.SUCCESS) {
                        val canvas = Canvas(bitmap)

                        val paint = Paint()
                        paint.colorFilter = view.colorFilter

                        canvas.drawBitmap(bitmap, 0f, 0f, paint)
                    }
                },
                Handler(Looper.getMainLooper())
            )
            return bitmap
        } else {
            val tBitmap = Bitmap.createBitmap(
                view.width, view.height, Bitmap.Config.RGB_565
            )
            val canvas = Canvas(tBitmap)

            val paint = Paint()
            paint.colorFilter = view.colorFilter
            canvas.drawBitmap(tBitmap, 0f, 0f, paint)
            return tBitmap
        }
    }

    private fun saveMediaIntoGallery(mediaPath: File) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            saveImageIntoGallerySdk29(context, mediaPath)
        } else {
            saveImageIntoGallery(context, mediaPath)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun saveImageIntoGallerySdk29(context: Context, mediaPath: File) {
        val imageFileName = "image_" + System.currentTimeMillis() + ".png"
        val imageValue = ContentValues().apply {
            put(
                MediaStore.Images.Media.RELATIVE_PATH,
                Environment.DIRECTORY_PICTURES + "/" + "Edited_photo"
            )
            put(MediaStore.Images.Media.TITLE, imageFileName)
            put(MediaStore.Images.Media.DISPLAY_NAME, imageFileName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            put(MediaStore.Images.Media.DATE_ADDED, System.currentTimeMillis() / 1000)
            put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis())
            put(MediaStore.Images.Media.IS_PENDING, 1)
        }

        val collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        val uriSavedImage = context.contentResolver.insert(collection, imageValue) ?: return

        context.contentResolver.openFileDescriptor(uriSavedImage, "w")
            .use { parcelFileDescription ->
                ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescription)
                    .write(mediaPath.readBytes())
            }

        imageValue.clear()
        imageValue.put(MediaStore.Images.Media.IS_PENDING, 0)
        context.contentResolver.update(
            uriSavedImage, imageValue, null, null
        )
    }

    private fun saveImageIntoGallery(context: Context, mediaFilePath: File) {
        val imageFileName = "image_" + System.currentTimeMillis() + ".png"

        val target = File(
            context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
            "${Environment.DIRECTORY_PICTURES}/Edited_photo/$imageFileName"
        )

        mediaFilePath.copyTo(target)

        val imageValue = ContentValues().apply {
            put(MediaStore.Images.Media.TITLE, imageFileName)
            put(MediaStore.Images.Media.DISPLAY_NAME, imageFileName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            put(MediaStore.Images.Media.DATA, target.path)
        }
        context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, imageValue)
    }
}