package com.example.kotlindemo.mvvm.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.kotlindemo.R
import com.example.kotlindemo.databinding.ActivitLoginBinding
import com.example.kotlindemo.mvvm.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    private lateinit var activityLoginBinder: ActivitLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindings(savedInstanceState)


    }

    private fun setupBindings(savedInstanceState: Bundle?) {
        activityLoginBinder = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        activityLoginBinder?.loginBtnId.setOnClickListener(View.OnClickListener {
            val email: String = activityLoginBinder.emailId.text.toString()
            val password = activityLoginBinder.passId.text.toString()

            loginViewModel.validateCredentials(email, password).observe(this, object : Observer<String> {
                override fun onChanged(t: String?) {
                    Toast.makeText(this@LoginActivity, t, Toast.LENGTH_LONG).show()
                }
            })
        })


    }
}
