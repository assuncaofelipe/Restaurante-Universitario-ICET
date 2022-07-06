package com.icet.restaurante.rest

import com.icet.restaurante.models.DadosCardapio
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServiceCardapio {


    @GET("/cardapio")
    fun getAllCardapio(): Call<List<DadosCardapio>>


    companion object {
        private val retrofitServiceCardapio: RetrofitServiceCardapio by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api-ru-alunos-icet.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitServiceCardapio::class.java)
        }

        fun getIntance() : RetrofitServiceCardapio {
            return RetrofitServiceCardapio.retrofitServiceCardapio
        }

    }

}