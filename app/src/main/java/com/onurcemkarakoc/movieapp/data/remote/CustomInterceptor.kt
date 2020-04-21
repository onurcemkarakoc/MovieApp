package com.onurcemkarakoc.movieapp.data.remote


import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var url = chain.request().url.newBuilder()
            .addQueryParameter("api_key", Constant.API_KEY)
            .build()
        val request = chain.request().newBuilder()
            .url(url)
            .build()
        return chain.proceed(request)
    }
}