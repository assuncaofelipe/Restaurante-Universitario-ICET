package com.icet.restaurante.repositories

import com.icet.restaurante.rest.RetrofitServiceCardapio

class CardapioRepository constructor(private val retrofitServiceCardapio: RetrofitServiceCardapio) {

    fun getAllCardapio() = retrofitServiceCardapio.getAllCardapio()
}