package com.example.demoapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoapplication.model.DataModel
import com.example.demoapplication.databinding.AdapterListItemBinding


class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var listData = mutableListOf<DataModel>()
    fun setListDataItems(listDataItems: List<DataModel>) {
        this.listData = listDataItems.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterListItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val listDataItem = listData[position]
        holder.binding.title.text = listDataItem.title
        holder.binding.desc.text = listDataItem.description
        Glide.with(holder.itemView.context).load(listDataItem.imageUrl).into(holder.binding.imageview)
    }
    override fun getItemCount(): Int {
        return listData.size
    }
}
class MainViewHolder(val binding: AdapterListItemBinding) : RecyclerView.ViewHolder(binding.root) {
}