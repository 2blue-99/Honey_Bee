package com.example.receiptcareapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.remote.receive.card.CardData
import com.example.domain.model.ui.recycler.ServerRecyclerData
import com.example.receiptcareapp.R
import com.example.receiptcareapp.databinding.ItemHomeCardListBinding
import com.example.receiptcareapp.ui.botteomSheet.CardListBottomSheet

class HomeCardAdapter : RecyclerView.Adapter<HomeCardAdapter.MyHolder>(){

    private lateinit var binding: ItemHomeCardListBinding
    lateinit var onHomeCardItemClick : (CardData)->Unit

    var dataList = mutableListOf<CardData>()
        set(value){
            field = value.reversed().toMutableList()
            notifyDataSetChanged()
        }

    inner class MyHolder(private val binding : ItemHomeCardListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CardData, position:Int) {
            binding.cardData = item
            if(item.cardAmount=="-") binding.cardHomeList
            binding.root.setOnClickListener{ onHomeCardItemClick(item) }
            when(position) {
                1 -> binding.cardHomeIconImg.setImageResource(R.drawable.icon_card_1)
                2 -> binding.cardHomeIconImg.setImageResource(R.drawable.icon_card_2)
                3 -> binding.cardHomeIconImg.setImageResource(R.drawable.icon_card_3)
                else -> binding.cardHomeIconImg.setImageResource(R.drawable.icon_card_4)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        binding = ItemHomeCardListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(dataList[position], position%4 )
    }

    override fun getItemCount(): Int = dataList.size
}