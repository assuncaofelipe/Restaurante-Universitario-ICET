package com.icet.restaurante.rest

import com.icet.restaurante.models.Cardapio
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServiceCardapio {


    @GET("/cardapio")
    fun getAllCardapio(): Call<List<Cardapio>>
}