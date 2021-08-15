package com.example.carpool

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginViewModelFactory(val loginInterface: LoginInterface): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(loginInterface = loginInterface) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }

}