package com.example.receiptcareapp.ui.fragment

import android.content.Context
import android.content.Intent
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.receiptcareapp.R
import com.example.receiptcareapp.databinding.FragmentHomeBinding
import com.example.receiptcareapp.base.BaseFragment
import com.example.receiptcareapp.ui.botteomSheet.HomeCardBottomSheet
import com.example.receiptcareapp.viewModel.fragmentViewModel.HomeViewModel
import com.google.android.gms.oss.licenses.OssLicensesActivity
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

//메인 프레그먼트/
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate, "HomeFragment") {

    private lateinit var callback: OnBackPressedCallback

    override fun initData() {}

    override fun initUI() {
        with(binding){
            cameraBtn.setOnClickListener{ findNavController().navigate(R.id.action_homeFragment_to_cameraFragment) }
            galleryBtn.setOnClickListener{ findNavController().navigate(R.id.action_homeFragment_to_galleryFragment)}
            historyBtn.setOnClickListener{  findNavController().navigate(R.id.action_homeFragment_to_recyclerFragment)}
            settingBtn.setOnClickListener{ findNavController().navigate(R.id.action_homeFragment_to_menuFragment) }
        }
    }

    override fun initListener() {
    }

    override fun initObserver() {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                AlertDialog.Builder(requireActivity(), R.style.AppCompatAlertDialog)
                    .setTitle("종료")
                    .setMessage("꿀을 그만 빠시겠어요?")
                    .setPositiveButton("그만 빤다"){dialog, id->
                        requireActivity().finish()
                    }
                    .setNegativeButton("더 빤다"){dialog, id->

                    }.show()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onDetach() {
        super.onDetach()
        callback.remove()
    }
}