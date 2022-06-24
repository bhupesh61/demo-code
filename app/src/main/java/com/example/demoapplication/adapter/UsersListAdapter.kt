package com.example.demoapplication.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.databinding.AdapterListItemBinding
import com.example.demoapplication.model.UsersDataModel
import com.example.demoapplication.userdetails.UserDetailsActivity


class UsersListAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var usersListData = mutableListOf<UsersDataModel>()
    fun setUsersListDataItems(usersListDataItems: List<UsersDataModel>) {
        this.usersListData = usersListDataItems.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterListItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val usersListDataItem = usersListData[position]
        holder.binding.name.text = usersListDataItem.name
        holder.binding.designation.text = usersListDataItem.designation

        holder.binding.cardViewItem.setOnClickListener { v ->
            val activity = v!!.context as AppCompatActivity
            val intent = Intent(activity, UserDetailsActivity::class.java)
            intent.putExtra("Username", usersListDataItem.name)
            intent.putExtra("Designation", usersListDataItem.designation)
            intent.putExtra("Address", usersListDataItem.address)
            intent.putExtra("Contact", usersListDataItem.contact)
            intent.putExtra("Email", usersListDataItem.email)
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return usersListData.size
    }
}

class MainViewHolder(val binding: AdapterListItemBinding) : RecyclerView.ViewHolder(binding.root) {
}