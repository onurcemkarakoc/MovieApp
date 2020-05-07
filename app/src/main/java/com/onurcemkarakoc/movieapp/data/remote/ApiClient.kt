package com.onurcemkarakoc.movieapp.data.remote

import com.onurcemkarakoc.movieapp.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getRetrofit(): ApiService {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(CustomInterceptor()).build())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}