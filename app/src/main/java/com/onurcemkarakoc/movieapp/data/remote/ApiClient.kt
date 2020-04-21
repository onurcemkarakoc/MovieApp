package com.onurcemkarakoc.movieapp.data.remote

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