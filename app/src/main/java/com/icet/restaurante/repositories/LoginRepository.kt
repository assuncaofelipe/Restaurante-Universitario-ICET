package com.icet.restaurante.repositories

import com.icet.restaurante.rest.RetrofitServiceLogin

class LoginRepository constructor(private val retrofitServiceLogin: RetrofitServiceLogin) {

    fun getAllAlunos() = retrofitServiceLogin.getAllAlunos()

}