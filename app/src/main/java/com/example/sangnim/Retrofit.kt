package com.example.sangnim

import android.util.Log
import android.widget.TextView
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


data class ResultModel(
    @SerializedName("result")
    var result: String
)

data class LoginModel( //주고 받고
    @SerializedName("id")
    var id: Int,
    @SerializedName("pw")
    var pw: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("age")
    var age: Int,
    @SerializedName("result")
    var result: String
)

data class UserModel( //줄 때
    @SerializedName("id")
    var id: Int,
    @SerializedName("pw")
    var pw: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("age")
    var age: Int
)

object Retrofit{
    private val retrofit = Retrofit.Builder().baseUrl("http://118.67.131.137:3000").addConverterFactory(GsonConverterFactory.create()).build()
    private val service = retrofit.create(RetrofitService::class.java)

    fun joinReq(id: Int, pw: String, name: String, age: Int, callback: (ResultModel) -> Unit) {
        val sql = "insert into users values(${id}, '${pw}', '${name}', ${age})"

        service.joinReq(sql).enqueue(object : Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test", "${response.body()}")
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

    fun loginReq(id: Int, pw: String, callback: (LoginModel) -> Unit) {
        var sql =" select * from users where id=${id} and pw='${pw}'"

        service.loginReq(sql).enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                Log.d("test", "${response.body()}")
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

    //로그인한 사용자의 정보 불러오기
    fun getUsersReq(id: Int, callback:(ArrayList<UserModel>) -> Unit){
        val sql ="select * from users where id = ${id}"

        service.getUsersReq(sql).enqueue(object : Callback<ArrayList<UserModel>> {
            override fun onResponse(call: Call<ArrayList<UserModel>>, response: Response<ArrayList<UserModel>>) {
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<ArrayList<UserModel>>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

    //회원 정보 수정 코드:: update -회원 이름, 비밀번호
    fun updateUserReq(case: Int, id: Int, name: String, pw: String, callback: (ResultModel) -> Unit){
        val sql: String
        if(case == 1) {
            sql = "UPDATE users SET name ='${name}', pw='${pw}' where id = ${id} "
        }else if(case ==2){
            sql = "UPDATE users SET name ='${name}' where id = ${id} "
        }else{
            sql = "UPDATE users SET pw ='${pw}' where id = ${id} "
        }
        service.updateUserReq(sql).enqueue(object : Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("user_update", "${response.body()}");
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("user_update", t.message.toString())
            }
        })
    }

    //회원 탈퇴 코드
    fun deleteUserReq(id: Int, callback: (ResultModel) -> Unit){
        val sql ="delete from users where id=${id} "

        service.deleteUserReq(sql).enqueue(object : Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("user_delete", "${response.body()}");
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("user_delete", t.message.toString())
            }
        })
    }
}