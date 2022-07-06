package com.icet.restaurante.models

data class LoginRequest(
    val matricula: String,
    val senha: String
)