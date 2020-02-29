package com.example.mvvmkotlinapp

import androidx.multidex.MultiDexApplication
import com.example.mvvmkotlinapp.injection.AppComponent

class TestApplication : MultiDexApplication() {
    companion object {
        @get: Synchronized
        lateinit var mInstance: TestApplication
        private set

        fun getInstance(): TestApplication {
            return mInstance
        }
    }


    override fun onCreate() {
        super.onCreate()
        mInstance = this

    }

}