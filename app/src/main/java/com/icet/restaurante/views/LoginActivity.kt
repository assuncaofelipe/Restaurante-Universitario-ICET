package com.icet.restaurante.views

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.icet.restaurante.databinding.ActivityLoginBinding
import com.icet.restaurante.models.LoginRequest
import com.icet.restaurante.models.UserSession
import com.icet.restaurante.repositories.UserRepository
import com.icet.restaurante.rest.RetrofitServiceLogin
import com.icet.restaurante.viewmodel.login.LoginViewModel
import com.icet.restaurante.viewmodel.login.LoginViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private val retrofitServiceLogin = RetrofitServiceLogin.getIntance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(UserRepository(retrofitServiceLogin))
        ).get(
            LoginViewModel::class.java
        )

        setupUi()

    }

    private fun setupUi() = _binding.apply {

        btnLogin.setOnClickListener {
            viewModel.login(
                LoginRequest(
                    editMatricula.text.toString(),
                    editSenha.text.toString()
                )
            )
            loadingView.show()

        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.success.observe(this, Observer {

            UserSession.setToken(it.token)
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()

        })

        viewModel.errorMessage.observe(this, Observer {
            _binding.loadingView.dismiss()
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }



}