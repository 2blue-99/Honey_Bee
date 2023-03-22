package com.example.receiptcareapp.fragment.homeFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.receiptcareapp.databinding.CardItemBinding
import com.example.receiptcareapp.dto.ServerCardData

/**
 * 2023-03-22
 * pureum
 */
class HomeCardAdapter : RecyclerView.Adapter<HomeCardAdapter.MyHolder>(){

    lateinit var onLocalSaveClic : (ServerCardData)->Unit
    private lateinit var cardBinding: CardItemBinding
    var dataList = listOf<ServerCardData>()
        set(value){
            field = value.reversed()
            notifyDataSetChanged()
        }
    inner class MyHolder(private val binding : CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServerCardData) {
            Log.e("TAG", "bind: inin", )
            binding.cardName.text = item.name
            binding.amount.text = item.amount.toString()
            binding.body.setOnClickListener{ onLocalSaveClic(item) }
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