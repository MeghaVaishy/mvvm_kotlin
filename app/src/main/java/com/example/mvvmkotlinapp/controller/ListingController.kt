package com.example.mvvmkotlinapp.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmkotlinapp.R
import com.example.mvvmkotlinapp.adapter.ListAdapter
import com.example.mvvmkotlinapp.databinding.HomeLayoutBinding
import com.example.mvvmkotlinapp.model.Result
import com.example.mvvmkotlinapp.viewmodel.ListViewModel
import work.beltran.conductorviewmodel.ViewModelController

class ListingController : ViewModelController() {


    private lateinit var homeLayoutBinding: HomeLayoutBinding
    private lateinit var listViewModel: ListViewModel
    private val movieList: MutableList<Result> by lazy { mutableListOf<Result>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        retainViewMode = RetainViewMode.RETAIN_DETACH
        homeLayoutBinding = DataBindingUtil.inflate(
            inflater, R.layout.home_layout,
            container, false
        )

        setAdapter(movieList)

        listViewModel = viewModelProvider().get(ListViewModel::class.java)
        listViewModel.init()

        // api call
        listViewModel.getMovieList()


        // 3. Observe your LiveData
        listViewModel.getLiveData()?.observe(this, Observer {


            it?.results?.let { it1 -> movieList.addAll(it1) }
            setAdapter(movieList)

        })


        return homeLayoutBinding.root
    }

    private fun setAdapter(movieList: MutableList<Result>) {

        homeLayoutBinding.listMovie.layoutManager = LinearLayoutManager(activity)

        val adapter = ListAdapter(movieList)

        val horizontalDecoration = DividerItemDecoration(
            homeLayoutBinding.listMovie.context,
            DividerItemDecoration.VERTICAL
        )
        homeLayoutBinding.listMovie.addItemDecoration(horizontalDecoration)
        homeLayoutBinding.listMovie.adapter = adapter

    }

}