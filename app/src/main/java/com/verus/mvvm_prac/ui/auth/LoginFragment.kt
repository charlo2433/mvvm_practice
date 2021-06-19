package com.verus.mvvm_prac.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.verus.mvvm_prac.data.network.AuthApi
import com.verus.mvvm_prac.data.network.Resource
import com.verus.mvvm_prac.data.repository.AuthRepository

import com.verus.mvvm_prac.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.button.setOnClickListener{
            val phone = binding.editTextTextPersonName.text.toString().trim()
            val password = binding.editTextTextPersonName2.text.toString().trim()

            Log.e("phone",phone)
            Log.e("pass",password)
            viewModel.login(phone, password)

        }
    }

    override fun getViewModel()  = AuthViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater,container, false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))


}