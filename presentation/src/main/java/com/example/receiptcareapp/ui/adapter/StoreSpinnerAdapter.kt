package com.example.receiptcareapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.receiptcareapp.R
import com.example.receiptcareapp.databinding.SpinnerCustomItemLayoutBinding
import com.example.receiptcareapp.databinding.SpinnerCustomStoreItemLayoutBinding

/**
 * 2023-08-21
 * pureum
 */
class StoreSpinnerAdapter(context: Context, items: ArrayList<String>) : ArrayAdapter<String>(context, R.layout.spinner_custom_item_layout, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //TODO 여기를 바꾸면 Spinner UI 수정 성공할 수 있지 않을까?
        val binding = SpinnerCustomStoreItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.spinnerItem.height = 35 // 높이를 35dp로 설정합니다.
        val item = getItem(position)
        Log.e("TAG", "getView: $item", )
        binding.data = item
        return binding.root
    }
}