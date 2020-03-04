package com.example.mvvmkotlinapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//https://medium.com/@elye.project/in-and-out-type-variant-of-kotlin-587e4fa2944c
class RetroViewModelFactory : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}