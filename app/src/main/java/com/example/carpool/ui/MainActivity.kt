package com.example.carpool.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.carpool.R
import com.example.carpool.ui.login.LoginFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 

        supportFragmentManager.commit {
            replace<LoginFragment>(R.id.fragment_login_container)
            setReorderingAllowed(true)
            addToBackStack(null)
        }


    }
}