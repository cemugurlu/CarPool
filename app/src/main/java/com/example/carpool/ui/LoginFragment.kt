package com.example.carpool.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.example.carpool.LoginInterface
import com.example.carpool.LoginViewModel
import com.example.carpool.LoginViewModelFactory
import com.example.carpool.R
import com.example.carpool.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login), LoginInterface {
    private lateinit var viewModel: LoginViewModel
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(loginInterface = this)
        ).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        setObservers()
        //binding.etEmailField
        return binding.root
    }

    fun setObservers() {
        /*
        viewModel.email.observe(viewLifecycleOwner) {
            Log.d("TAG", it)
        }*/
    }

    override fun onNavigateToMainFragment() {
        parentFragmentManager.commit {
            replace<MainFragment>(R.id.fragment_main_container)
        }
    }

}