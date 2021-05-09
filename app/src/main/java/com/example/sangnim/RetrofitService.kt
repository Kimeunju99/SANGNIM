package com.example.sangnim

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @FormUrlEncoded
    @POST("/users")
    fun joinReq(@Field("sql") sql: String): Call<ResultModel>

    @GET("/users")
    fun getUsersReq():Call<ArrayList<UserModel>>
}