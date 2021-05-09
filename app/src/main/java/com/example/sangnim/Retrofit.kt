package com.example.sangnim

import android.util.Log
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class ResultModel(
    @SerializedName("result")
    var result : String
)

data class UserModel(
    @SerializedName("id")
    var id : Int,
    @SerializedName("pw")
    var pw : String,
    @SerializedName("name")
    var name : String,
    @SerializedName("age")
    var age : Int
)

object Retrofit {


    private val retrofit = Retrofit.Builder().baseUrl("http://118.67.131.137:3000").addConverterFactory(GsonConverterFactory.create()).build()

    private val service = retrofit.create(RetrofitService::class.java)

    fun joinReq(id: Int, pw: String, name: String, age: Int, callback: (ResultModel) -> Unit) {
        val sql = "insert into users values(${id}, '${pw}', '${name}', ${age})"

        service.joinReq(sql).enqueue(object: Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test","${response.body()}")
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test",t.message.toString())
            }
        })
    }

    fun getUsersReq(callback: (ArrayList<UserModel>) -> Unit){
//        var sql ="select * from users"

        service.getUsersReq().enqueue(object : Callback<ArrayList<UserModel>> {
            override fun onResponse(call: Call<ArrayList<UserModel>>, response:Response<ArrayList<UserModel>>){
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<ArrayList<UserModel>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }
        })
    }
}