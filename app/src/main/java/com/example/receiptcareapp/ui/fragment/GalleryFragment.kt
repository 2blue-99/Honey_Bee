package com.example.receiptcareapp.ui.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.receiptcareapp.R
import com.example.receiptcareapp.databinding.FragmentGalleryBinding
import com.example.receiptcareapp.viewModel.FragmentViewModel
import com.example.receiptcareapp.base.BaseFragment

class GalleryFragment : BaseFragment<FragmentGalleryBinding>(FragmentGalleryBinding::inflate) {

    private val GALLERY = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)

  // initListenr인지 initdata인지
    private val fragmentViewModel : FragmentViewModel by viewModels({requireActivity()})
    private val homeFragment : HomeFragment = HomeFragment()

    override fun initData() {}

    override fun initUI() {}

    override fun initListener() { CallGallery() }

    override fun initObserver() {}


    /** 갤러리 관련 코드 **/
    /* 갤러리 호출 */
    fun CallGallery() {
        Log.e("TAG", "CallGallery 실행", )
        if(homeFragment.checkPermission(requireContext(), GALLERY)){
            Log.e("TAG", "파일 권한 있음", )
            val intent = Intent(Intent.ACTION_PICK)
            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.type = "image/*"
            activityResult.launch(intent)
        }
    }

    /* 갤러리 사진 관련 함수 */
    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            Log.e("TAG", "onActivityResult: if 진입", )
            val imageUri: Uri? = it.data?.data
            Log.e("TAG", "my URI: $imageUri", )
            if (imageUri != null) {
                Log.e("TAG", "data 있음", )
                fragmentViewModel.takeImage(imageUri)
                NavHostFragment.findNavController(this).navigate(R.id.action_galleryFragment_to_showFragment)
            }
            else{ Log.e("TAG", "data 없음", ) }
        }
        else{
            Log.e("TAG", "RESULT_OK if: else 진입", )
            findNavController().navigate(R.id.action_galleryFragment_to_homeFragment)
        }
    }

}