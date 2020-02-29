package com.example.mvvmkotlinapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.example.mvvmkotlinapp.R
import com.example.mvvmkotlinapp.controller.ListingController
import com.example.mvvmkotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var routerContainer: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        routerContainer =
            Conductor.attachRouter(this, binding.listingContainer, savedInstanceState)

        launchHomeController()


    }

    private fun launchHomeController() {
        if (!routerContainer.hasRootController()) {
            var listingController = ListingController()
            routerContainer.setRoot(RouterTransaction.with(listingController))

        }
    }


    override fun onBackPressed() {
        if (routerContainer.hasRootController()) {
            routerContainer.handleBack()
        }
    }
}
