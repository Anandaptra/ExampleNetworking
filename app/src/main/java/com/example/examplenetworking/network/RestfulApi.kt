package com.example.examplenetworking.network

import com.example.examplenetworking.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {

    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>
}