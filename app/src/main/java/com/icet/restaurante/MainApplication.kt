package com.icet.restaurante

import android.app.Application
import com.icet.restaurante.rest.RetrofitProvider

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initRetrofit()
    }
     private fun initRetrofit() {
         RetrofitProvider()
     }
}