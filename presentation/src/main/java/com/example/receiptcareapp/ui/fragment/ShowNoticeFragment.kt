package com.example.receiptcareapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.receiptcareapp.R
import com.example.receiptcareapp.base.BaseFragment
import com.example.receiptcareapp.databinding.FragmentShowNoticeBinding
import com.example.receiptcareapp.viewModel.fragmentViewModel.ShowNoticeViewModel


class ShowNoticeFragment : BaseFragment<FragmentShowNoticeBinding>(
    FragmentShowNoticeBinding::inflate, "ShowNoticeFragment"
) {
    private val viewModel: ShowNoticeViewModel by viewModels()


    override fun initData() {
//        viewModel.getNoticeData()
//        binding.title =
    }

    override fun initUI() {
    }

    override fun initListener() {
    }

    override fun initObserver() {
    }

}