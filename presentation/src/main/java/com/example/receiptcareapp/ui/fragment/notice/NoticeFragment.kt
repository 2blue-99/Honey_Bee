package com.example.receiptcareapp.ui.fragment.notice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.receiptcareapp.R
import com.example.receiptcareapp.base.BaseFragment
import com.example.receiptcareapp.databinding.FragmentMenuBinding
import com.example.receiptcareapp.databinding.FragmentNoticeBinding
import com.example.receiptcareapp.ui.adapter.NoticeAdapter
import com.example.receiptcareapp.viewModel.fragmentViewModel.notice.NoticeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoticeFragment : BaseFragment<FragmentNoticeBinding>(
    FragmentNoticeBinding::inflate,"NoticeFragment"
) {
    private val viewModel: NoticeViewModel by viewModels()
    private val adapter: NoticeAdapter = NoticeAdapter()
    override fun initData() {
        viewModel.getNoticeList()
    }

    override fun initUI() {
        binding.noticeRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.noticeRecycler.adapter = adapter
    }

    override fun initListener() {
        binding.baseComponent.title.setOnLongClickListener {
            findNavController().navigate(R.id.action_noticeFragment_to_addNoticeFragment)
            true
        }
        binding.baseComponent.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_noticeFragment_to_homeFragment)
        }
    }

    override fun initObserver() {
        viewModel.response.observe(viewLifecycleOwner){
            adapter.dataList = it
        }
        viewModel.loading.observe(viewLifecycleOwner){
            if(it) binding. layoutLoadingProgress.root.visibility = View.VISIBLE
            else binding.layoutLoadingProgress.root.visibility = View.INVISIBLE
            checkDataList()
        }
    }

    fun checkDataList(){
        if(adapter.dataList.isEmpty()) binding.emptyText.visibility = View.VISIBLE
        else  binding.emptyText.visibility = View.INVISIBLE
    }


}