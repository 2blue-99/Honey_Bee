package com.example.receiptcareapp.ui.dialog

import androidx.navigation.fragment.findNavController
import com.example.receiptcareapp.R
import com.example.receiptcareapp.base.BaseDialog
import com.example.receiptcareapp.databinding.DialogAddBinding

class ChoiceDialog : BaseDialog<DialogAddBinding>(DialogAddBinding::inflate) {

    override fun initData() {

    }

    override fun initUI() {

    }

    override fun initListener() {
        with(binding){
            addCameraBtn.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_cameraFragment)
                dismiss()
            }
            addGalleryBtn.setOnClickListener{
                findNavController().navigate(R.id.action_homeFragment_to_galleryFragment)
                dismiss()
            }
        }

    }

    override fun initObserver() {

    }

}