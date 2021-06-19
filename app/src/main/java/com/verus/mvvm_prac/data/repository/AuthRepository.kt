package com.verus.mvvm_prac.data.repository

import com.verus.mvvm_prac.data.network.AuthApi

class AuthRepository(
    private val api: AuthApi
) : BaseRepository() {
    suspend fun login(
        phone: String,
        password: String
    ) = safeApiCall {
        api.login(phone, password)
    }
}