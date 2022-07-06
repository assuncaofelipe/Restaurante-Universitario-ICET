package com.icet.restaurante.rest

import retrofit2.http.GET
import com.icet.restaurante.models.DadosLogin
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface  RetrofitServiceLogin {

    @GET("/alunos")
    fun getAllAlunos(): Call<List<DadosLogin>>

    companion object {
        private val retrofitServiceLogin : RetrofitServiceLogin by lazy{

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api-ru-alunos-icet.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitServiceLogin::class.java)
        }

        fun getIntance() : RetrofitServiceLogin {
            return retrofitServiceLogin
        }

    }

}