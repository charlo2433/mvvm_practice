package com.verus.mvvm_prac.data.network

import com.verus.mvvm_prac.data.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @FormUrlEncoded
    @POST("login/employee")
    suspend fun login(
        @Field("phone") username: String,
        @Field("password") password: String,
    ): LoginResponse
}