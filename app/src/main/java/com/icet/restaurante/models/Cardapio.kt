package com.icet.restaurante.models

data class Cardapio(
    val id: String? = null,
    var diaSemana: String,
    var desjejum: String,
    var almoco: String,
    var jantar: String,
)