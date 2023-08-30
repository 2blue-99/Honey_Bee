package com.example.receiptcareapp.ui.fragment.notice

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.model.receive.notice.NoticeData
import com.example.receiptcareapp.base.BaseFragment
import com.example.receiptcareapp.databinding.FragmentNoticeShowBinding
import com.example.receiptcareapp.viewModel.activityViewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoticeShowFragment : BaseFragment<FragmentNoticeShowBinding>(
    FragmentNoticeShowBinding::inflate, "ShowNoticeFragment"
) {
    private val activityViewModel: MainActivityViewModel by activityViewModels()
    private lateinit var viewModelData: NoticeData

    override fun initData() {
        viewModelData = activityViewModel.selectedNoticeData
    }

    override fun initUI() {
        with(binding){
            //Todo 데이터클래스로 묶어 넘기고, viewModeldata로 한번 거쳐 가지말고 다이렉트로 담아주기
            title = viewModelData.title
            date = viewModelData.date
            content = viewModelData.content
        }
    }

    override fun initListener() {
        binding.baseComponent.backBtn.setOnClickListener { findNavController().popBackStack() }
    }

    override fun initObserver() {}

}