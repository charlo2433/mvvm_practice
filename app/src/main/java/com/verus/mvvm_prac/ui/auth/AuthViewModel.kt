package com.verus.mvvm_prac.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.verus.mvvm_prac.data.network.Resource
import com.verus.mvvm_prac.data.repository.AuthRepository
import com.verus.mvvm_prac.data.response.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
): ViewModel(){
    private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>get() = _loginResponse
    fun login(
        username: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(username, password)
    }
}
