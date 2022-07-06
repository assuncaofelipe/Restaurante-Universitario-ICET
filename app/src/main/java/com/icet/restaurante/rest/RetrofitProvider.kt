package com.icet.restaurante.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    init {
        buildRetrofit()
    }

    companion object {

        private lateinit var retrofit: Retrofit

        private fun buildRetrofit(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl("https://api-ru-alunos-icet.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }


        @Suppress("NON_PUBLIC_CALL_FROM_PUBLIC_INLINE")
        inline fun <reified T> getInstance(): T {
            return retrofit.create(T::class.java)
        }
    }

}