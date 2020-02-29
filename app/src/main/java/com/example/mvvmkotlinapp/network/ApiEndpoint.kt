package com.example.mvvmkotlinapp.network

import com.example.mvvmkotlinapp.model.MovieResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiEndpoint {


    //http://api.themoviedb.org/3/search/movie?api_key=7e588fae3312be4835d4fcf73918a95f&query=a%20&page=01

    @GET("/3/search/movie")
    @Headers("Accept: application/json", "Content-Type: application/json")
    fun getTrendingMovieList(
        @Query("api_key") api_key: String,
        @Query("query") query: String?, @Query("page") page: Int
    ): Observable<MovieResponse>

}