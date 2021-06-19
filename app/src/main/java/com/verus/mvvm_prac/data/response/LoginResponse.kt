package com.verus.mvvm_prac.data.response

data class LoginResponse(
    val access_token: String,
    val account_type: String,
    val email: String,
    val expires_in: Int,
    val first_name: String,
    val last_name: String,
    val phone: String,
    val refresh_token: String,
    val token_type: String,
    val user_id: Int
)