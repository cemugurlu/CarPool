package com.example.carpool

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(val loginInterface: LoginInterface): ViewModel() {
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun onClickButtonMain(view: View) {
        if (email.value.equals("cem") && password.value.equals("1234")) {

            loginInterface.onNavigateToMainFragment()
        }
    }
}