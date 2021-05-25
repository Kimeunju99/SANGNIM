package com.example.sangnim

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @FormUrlEncoded
    @POST("/users")
    fun joinReq(@Field("sql") sql: String): Call<ResultModel>

    @FormUrlEncoded
    @POST("/users/get")
    fun getUsersReq(@Field("sql") sql: String):Call<ArrayList<UserModel>>

    @FormUrlEncoded
    @POST("/users/login")
    fun loginReq(@Field("sql") sql: String):Call<LoginModel>
}