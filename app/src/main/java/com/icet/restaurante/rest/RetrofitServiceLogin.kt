package com.icet.restaurante.rest

import com.icet.restaurante.models.LoginRequest
import com.icet.restaurante.models.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitServiceLogin {

    @POST("/alunos")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    companion object {
        private val retrofitServiceLogin: RetrofitServiceLogin by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api-ru-alunos-icet.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitServiceLogin::class.java)
        }

        fun getIntance(): RetrofitServiceLogin {
            return retrofitServiceLogin
        }

    }

}