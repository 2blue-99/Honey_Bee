package com.example.receiptcareapp.viewModel.fragmentViewModel

import android.app.Activity
import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.receiptcareapp.State.ShowType
import java.io.File
import java.io.FileOutputStream

/**
 * 2023-06-22
 * pureum
 */
class RecyclerViewModel: ViewModel() {

    private var _startGap = MutableLiveData<ShowType>()
    val startGap : LiveData<ShowType>
        get() = _startGap
    fun changeStartGap(type: ShowType){ _startGap.value = type }

    fun bitmapToUri(activity: Activity, bitmap: Bitmap): Uri {
        val file = File(activity.cacheDir, "temp_image.jpg")
        val outputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.flush()
        outputStream.close()
        return Uri.fromFile(file)
    }

}