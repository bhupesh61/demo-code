package com.example.demoapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoapplication.model.UsersDataModel
import com.example.demoapplication.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersListViewModel constructor(private val repository: Repository) : ViewModel() {

    val dataList = MutableLiveData<List<UsersDataModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getUsersListData() {
        val response = repository.getUsersListData()
        response.enqueue(object : Callback<List<UsersDataModel>> {
            override fun onResponse(
                call: Call<List<UsersDataModel>>,
                response: Response<List<UsersDataModel>>
            ) {
                dataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UsersDataModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}