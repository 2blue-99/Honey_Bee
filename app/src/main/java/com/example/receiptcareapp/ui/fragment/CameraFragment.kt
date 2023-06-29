package com.example.receiptcareapp.ui.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.receiptcareapp.R
import com.example.receiptcareapp.databinding.FragmentCameraBinding
import com.example.receiptcareapp.base.BaseFragment
import com.example.receiptcareapp.viewModel.fragmentViewModel.CameraViewModel
import com.example.receiptcareapp.viewModel.activityViewmodel.MainActivityViewModel

class CameraFragment : BaseFragment<FragmentCameraBinding>(
    FragmentCameraBinding::inflate,
    "CameraFragment"
) {
    private val CAMERA = arrayOf(android.Manifest.permission.CAMERA)
    private val CAMERA_CODE = 98
    private var photoURI : Uri? = null
  //예시코드 보면서 callcamera 함수 위치 보완 => 리스너인지 데이터인지
    private val activityViewModel : MainActivityViewModel by activityViewModels()
    private val viewModel : CameraViewModel by viewModels()

    override fun initData() {}

    override fun initUI() {}

    override fun initListener() { CallCamera() }

    override fun initObserver() {}

    /** 카메라 관련 코드 **/
    /* 카메라 호출 */
    fun CallCamera() {
        Log.e("TAG", "CallCamera", )
        if (viewModel.checkPermission(requireContext(), requireActivity(), CAMERA, CAMERA_CODE)) {  // 카메라 권한 있을 시 카메라 실행함
            Log.e("TAG", "카메라 권한 있음", )
            dispatchTakePictureIntentEx()
        }
    }

    private fun dispatchTakePictureIntentEx() {
        Log.e("TAG", "dispatchTakePictureIntentEx: ", )
        activityResult.launch(viewModel.dispatchTakePictureIntentExViewModel(requireActivity()))
    }

    //카메라 촬영 후 확인 시
    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        Log.e("TAG", "activityResult: ", )
        if (it.resultCode == Activity.RESULT_OK){
            Log.e("TAG", "onActivityResult: if 진입", )
            photoURI = viewModel.photoUri.value
            if(photoURI != null) {
                Log.e("TAG", "data 있음", )
                activityViewModel.takeImage(photoURI!!)
                photoURI = null
                findNavController().navigate(R.id.action_cameraFragment_to_showFragment)
            }
        }
        else {
            Log.e("TAG", "RESULT_OK if: else 진입", )
            findNavController().navigate(R.id.action_cameraFragment_to_homeFragment)
        }
    }
}
