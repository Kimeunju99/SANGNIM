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

    @FormUrlEncoded
    @POST("/users/login")
    fun loginReq(@Field("sql") sql: String):Call<LoginModel>

    @GET("/users")
    fun getUsersReq():Call<ArrayList<UserModel>>

    @FormUrlEncoded
    @POST("/users/get")
    fun getUsersReq(@Field("sql") sql: String):Call<ArrayList<UserModel>>

    @FormUrlEncoded
    @POST("/users")
    fun updateUserReq(@Field("sql") sql: String):Call<ResultModel> //call 뒤는 보내려는 거

    @FormUrlEncoded
    @POST("/users")
    fun deleteUserReq(@Field("sql") sql: String):Call<ResultModel>

    @FormUrlEncoded
    @POST("/homework")
    fun newHomeworkReq(@Field("sql")sql: String):Call<ResultModel>

   // @GET("/homework")
   // fun getHomeworkReq():Call<ArrayList<UserModel>>

    @FormUrlEncoded
    @POST("/homework")
    fun getHomeworkReq(@Field("sql")sql:String):Call<ResultModel>

    @FormUrlEncoded
    @POST("/homework")
    fun postHomeworkReq(@Field("sql")sql:String):Call<ResultModel>

    @FormUrlEncoded
    @POST("/homework")
    fun deleteHomeworkReq(@Field("sql")sql:String):Call<ResultModel>

    @FormUrlEncoded
    @POST("/teacher")
    fun teacheridReq(@Field("sql")sql:String):Call<ResultModel>

    @FormUrlEncoded
    @POST("/student")
    fun studentidReq(@Field("sql")sql:String):Call<ResultModel>

    @FormUrlEncoded
    @POST("/subject")
    fun newSubjectReq(@Field("sql") sql: String):Call<ResultModel>

    @FormUrlEncoded
    @POST("/subject")
    fun deleteSubjectReq(@Field("sql") sql:String):Call<ResultModel>


}