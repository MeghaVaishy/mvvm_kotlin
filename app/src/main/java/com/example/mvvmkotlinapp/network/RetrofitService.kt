package com.example.mvvmkotlinapp.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {

        fun providesGson(): Gson {
            return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        }


        val retrofitApi: Retrofit = Retrofit.Builder().baseUrl("http://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create(providesGson())).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

       fun createServeice() :ApiEndpoint{
            return retrofitApi.create<ApiEndpoint>(ApiEndpoint::class.java)
        }
    }

}