package com.example.kotlindemo.mvvm.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.kotlindemo.BR

class LoginInfo : BaseObservable() {
    var userName: String? = null
        @Bindable get() = field
        set(userName) {
            field = userName
            notifyPropertyChanged(BR.userName)
        }

    var userPassword: String? = null

    @Bindable get() = field
    set(userPassword) {
        field=userPassword
        notifyPropertyChanged(BR.userPassword)
    }



}