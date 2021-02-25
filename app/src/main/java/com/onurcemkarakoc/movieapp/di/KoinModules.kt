package com.onurcemkarakoc.movieapp.di

import com.onurcemkarakoc.movieapp.data.remote.ApiService
import com.onurcemkarakoc.movieapp.ui.main.MainRepository
import com.onurcemkarakoc.movieapp.ui.main.popular.PopularMoviesViewModel
import com.onurcemkarakoc.movieapp.ui.main.toprated.TopRatedMoviesViewModel
import com.onurcemkarakoc.movieapp.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { PopularMoviesViewModel(get()) }

    viewModel { TopRatedMoviesViewModel(get()) }

}

val repositoryModule = module {
    single {
        MainRepository(get())
    }
}

val apiModule = module {
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    single { provideApiService(get()) }
}

val retrofitModule = module {
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = Interceptor { chain ->
            val url = chain.request().url.newBuilder()
                .addQueryParameter("api_key", Constant.API_KEY)
                .build()
            val request = chain.request().newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}
