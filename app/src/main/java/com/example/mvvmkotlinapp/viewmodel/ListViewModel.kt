package com.example.mvvmkotlinapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkotlinapp.model.MovieResponse
import com.example.mvvmkotlinapp.repository.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ListViewModel : ViewModel() {

    lateinit var movieRepository: MovieRepository
    private lateinit var compositeDisposable: CompositeDisposable
    fun init() {
        movieRepository = MovieRepository.getInstance()
        compositeDisposable = CompositeDisposable()
    }

    private var mutableLiveData: MutableLiveData<MovieResponse> = MutableLiveData()

    fun getMovieList() {
        compositeDisposable.add(
            movieRepository.getMovieList().subscribeOn(Schedulers.io()).observeOn(
                io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            ).subscribe({

                mutableLiveData.value = it
            }, {

                Log.i("Error", it.message)
            })
        )
    }


    override fun onCleared() {
        super.onCleared()

    }


    fun getLiveData(): LiveData<MovieResponse?>? {
        return mutableLiveData
    }


}