package com.example.mvvmkotlinapp.repository

import com.example.mvvmkotlinapp.model.MovieResponse
import com.example.mvvmkotlinapp.network.ApiEndpoint
import com.example.mvvmkotlinapp.network.RetrofitService
import com.example.mvvmkotlinapp.util.Constant
import io.reactivex.Observable

class MovieRepository {

    var apiEndpoint: ApiEndpoint = RetrofitService.createServeice()

    companion object {

        fun getInstance(): MovieRepository {
            return MovieRepository()
        }
    }


    fun getMovieList(): Observable<MovieResponse> {
        return apiEndpoint
            .getTrendingMovieList(Constant.API_KEY, Constant.QUERY, Constant.PAGE)
    }
}