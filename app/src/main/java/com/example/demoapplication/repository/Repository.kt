package com.example.demoapplication.repository

import com.example.demoapplication.retrofit.RetrofitService

class Repository constructor(private val retrofitService: RetrofitService) {
    fun getUsersListData() = retrofitService.getUsersListData()
}