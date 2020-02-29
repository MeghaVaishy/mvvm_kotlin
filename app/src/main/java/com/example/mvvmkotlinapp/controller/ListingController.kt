package com.example.mvvmkotlinapp.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mvvmkotlinapp.R
import com.example.mvvmkotlinapp.databinding.HomeLayoutBinding
import com.example.mvvmkotlinapp.model.Result
import com.example.mvvmkotlinapp.viewmodel.ListViewModel
import work.beltran.conductorviewmodel.ViewModelController

class ListingController : ViewModelController() {


    lateinit var homeLayoutBinding: HomeLayoutBinding
    private lateinit var listViewModel: ListViewModel
    private val movieList: MutableList<Result> by lazy { mutableListOf<Result>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        retainViewMode = RetainViewMode.RETAIN_DETACH
        homeLayoutBinding = DataBindingUtil.inflate(
            inflater, R.layout.home_layout,
            container, false
        )

        listViewModel = viewModelProvider().get(ListViewModel::class.java)
        listViewModel.init()

        // api call
        listViewModel.getMovieList()


        // 3. Observe your LiveData
        listViewModel.getLiveData()?.observe(this, Observer {


            it?.results?.let { it1 -> movieList.addAll(it1) }

            movieList.size
        })

        return homeLayoutBinding.root
    }

}