package com.example.receiptcareapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.receive.DomainReceiveCardData
import com.example.domain.model.send.DomainAddNoticeData
import com.example.domain.model.send.DomainGetNoticeListData
import com.example.receiptcareapp.R
import com.example.receiptcareapp.databinding.ItemNoticeBinding

/**
 * 2023-08-13
 * pureum
 */
class NoticeAdapter : RecyclerView.Adapter<NoticeAdapter.MyHolder>(){

    lateinit var onNoticeClic: (DomainGetNoticeListData)-> Unit
    private lateinit var binding: ItemNoticeBinding
    var dataList = mutableListOf<DomainGetNoticeListData>()
        set(value){
            field = value.reversed().toMutableList()
            notifyDataSetChanged()
        }

    inner class MyHolder(private val binding : ItemNoticeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DomainGetNoticeListData) {
            binding.noticeItemTitle.text = item.title
            binding.noticeItemDate.text = item.date.toString()
            binding.noticeLayout.setOnClickListener { onNoticeClic(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        binding = ItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) { holder.bind(dataList[position]) }

    override fun getItemCount(): Int = dataList.size
}