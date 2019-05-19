package com.example.kotlindemo.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.kotlindemo.mvvm.repository.ValidationRepository
import java.util.*

class LoginViewModel : AndroidViewModel {
    private var validationRepository:ValidationRepository

    constructor(application: Application) : super(application) {
        this.validationRepository= ValidationRepository(application)
    }

    fun validateCredentials(email:String,password:String):LiveData<String>{
      return  validationRepository.validateCredentials(email,password)
    }
}