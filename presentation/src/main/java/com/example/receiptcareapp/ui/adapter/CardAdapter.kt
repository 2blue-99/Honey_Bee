package com.example.receiptcareapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.receive.DomainReceiveCardData
import com.example.receiptcareapp.databinding.CardItemBinding

/**
 * 2023-03-22
 * pureum
 */
class CardAdapter : RecyclerView.Adapter<CardAdapter.MyHolder>(){

    private lateinit var cardBinding: CardItemBinding
    var dataList = mutableListOf<DomainReceiveCardData>()
        set(value){
            field = value.reversed().toMutableList()
            notifyDataSetChanged()
        }
    inner class MyHolder(private val binding : CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DomainReceiveCardData) {
            Log.e("TAG", "bind: inin", )
            Log.e("TAG", "bind: cardName=${item.cardName}, amount=${item.cardAmount}", )
            binding.cardName = item.cardName
            binding.amount = item.cardAmount
            binding.billCheckDate = "10" + "일"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        cardBinding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
     holder.bind(dataList[position])
    }
    override fun getItemCount(): Int = dataList.size
}