package com.example.carpool.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.example.carpool.R
import com.example.carpool.databinding.FragmentLoginBinding
import com.example.carpool.ui.rent.RentFragment

class LoginFragment : Fragment(R.layout.fragment_login), LoginInterface {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(this, requireActivity().application)
        ).get(LoginViewModel::class.java)
        binding.viewModel = viewModel

        //TODO: Get rid of that Listener function
        binding.buttonLogin.setOnClickListener{
            addDataToDatabase()
        }
        setObservers()
        //binding.etEmailField test
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
            replace<RentFragment>(R.id.fragment_main_container)
        }
    }

    override fun addDataToDatabase() {
        val email = viewModel.email.toString()
        val password = viewModel.password.toString()
    }



}