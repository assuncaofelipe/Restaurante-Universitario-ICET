package com.icet.restaurante.utils

object Validator {

    fun validateMatricula(matricula: String): Boolean {
        return !(matricula.isEmpty() || matricula.isBlank() || !matricula.contains("."))
    }

    fun validateSenha(senha: String): Boolean {
        return !(senha.isEmpty() || senha.isBlank())
    }

}