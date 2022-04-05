package com.example.demoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demoapplication.adapter.MainAdapter
import com.example.demoapplication.databinding.ActivityMainBinding
import com.example.demoapplication.repository.Repository
import com.example.demoapplication.retrofit.RetrofitService

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: DataViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(Repository(retrofitService))).get(DataViewModel::class.java)
        binding.recyclerview.adapter = adapter
        viewModel.dataList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setListDataItems(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getListData()
    }
}