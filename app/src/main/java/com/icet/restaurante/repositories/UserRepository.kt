package com.icet.restaurante.repositories

import com.icet.restaurante.models.LoginRequest
import com.icet.restaurante.models.User
import com.icet.restaurante.rest.RetrofitServiceLogin

class UserRepository constructor(private val retrofitService: RetrofitServiceLogin) {

    fun login(loginRequest: LoginRequest) = retrofitService.login(loginRequest)

}