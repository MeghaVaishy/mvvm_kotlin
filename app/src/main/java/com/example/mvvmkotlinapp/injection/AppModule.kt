package com.example.mvvmkotlinapp.injection

import android.util.Log
import com.example.mvvmkotlinapp.BuildConfig
import com.example.mvvmkotlinapp.network.ApiEndpoint
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.String
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun getDummyApiEndpoint(retrofit: Retrofit): ApiEndpoint {
        return retrofit.create<ApiEndpoint>(ApiEndpoint::class.java)
    }


    @Provides
    @Singleton
    fun providesHttpClient(): OkHttpClient {
        val httpClientBuilder = getOKHttpClientBuilder()
        httpClientBuilder.addInterceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val requestBuilder =
                original.newBuilder().addHeader("VersionName", BuildConfig.VERSION_NAME)
                    .addHeader(
                        "VersionCode",
                        String.valueOf(BuildConfig.VERSION_CODE)
                    )
            val request = requestBuilder.build()
            Log.i("api call  {} ", request.url().toString())
            chain.proceed(request)
        }
        return httpClientBuilder.build()
    }


    private fun getOKHttpClientBuilder(): OkHttpClient.Builder {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        httpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        return httpClientBuilder
    }


    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient?): Retrofit {
//        val jsonConverterFactory = JsonConverterFactory()
        return Retrofit.Builder().baseUrl("https://github-trending-api.now.sh")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(providesGson())).client(httpClient)
            .build()
    }


}