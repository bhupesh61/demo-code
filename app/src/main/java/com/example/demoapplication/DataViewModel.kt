package com.example.demoapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapplication.model.DataModel
import com.example.demoapplication.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel constructor(private val repository: Repository) : ViewModel() {

    val dataList = MutableLiveData<List<DataModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getListData() {
        val response = repository.getListData()
        response.enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                dataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}