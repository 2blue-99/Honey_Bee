package com.example.receiptcareapp.ui.dialog

import com.example.receiptcareapp.base.BaseDialog
import com.example.receiptcareapp.databinding.DialogExitBinding

class ExitDialog : BaseDialog<DialogExitBinding>(DialogExitBinding::inflate) {
    override fun initData() {
    }

    override fun initUI() {
    }

    override fun initListener() {
        binding.exitBtnNegative.setOnClickListener{
            // 이어하기 클릭
            dismiss()
        }
        binding.exitBtnPositive.setOnClickListener{
            //앱 종료
            requireActivity().finish()
        }
    }

    override fun initObserver() {
    }

}