package com.example.mvvmkotlinapp.network

import com.example.mvvmkotlinapp.model.TrendingResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiEndpoint {
    @GET("/repositories")
    @Headers("Accept: application/json", "Content-Type: application/json")
    fun getTrendingRepoList(
        @Query("language") language: String?,
        @Query("since") since: String?
    ): Observable<TrendingResponse>

}