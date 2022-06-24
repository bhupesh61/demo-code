package com.example.demoapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoapplication.adapter.UsersListAdapter
import com.example.demoapplication.databinding.ActivityUsersListBinding
import com.example.demoapplication.repository.Repository
import com.example.demoapplication.retrofit.RetrofitService

class UsersListActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityUsersListBinding
    lateinit var viewModel: UsersListViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = UsersListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)
        binding = ActivityUsersListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, UsersListViewModelFactory(Repository(retrofitService))).get(
            UsersListViewModel::class.java
        )
        binding.recyclerview.adapter = adapter
        viewModel.dataList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setUsersListDataItems(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getUsersListData()
    }
}