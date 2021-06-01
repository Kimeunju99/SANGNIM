package com.example.sangnim

import retrofit2.Call
import retrofit2.http.*

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

    @FormUrlEncoded
    @POST("/users")
    fun updateUserReq(@Field("sql") sql: String):Call<ResultModel> //call 뒤는 보내려는 거

    @FormUrlEncoded
    @POST("/users")
    fun deleteUserReq(@Field("sql") sql: String):Call<ResultModel>
}