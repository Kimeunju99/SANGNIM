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


data class LoginModel(
        @SerializedName("id")
        var id : Int,
        @SerializedName("pw")
        var pw : String,
        @SerializedName("name")
        var name : String,
        @SerializedName("age")
        var age : Int,
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


data class SubjectModel(
        @SerializedName("name")
        var title : String,
        @SerializedName("teacherid")
        var teacherid : Int,
        @SerializedName("studentid")
        var studentid : Int
)

data class HomeworkModel(
        @SerializedName("image")
        var image : String,
        @SerializedName("deadline")
        var deadline : String,
        @SerializedName("content")
        var content : String,
        @SerializedName("time")
        var time : String

)

object Retrofit {


    private val retrofit = Retrofit.Builder().baseUrl("http://118.67.131.137:3000").addConverterFactory(GsonConverterFactory.create()).build()

    private val service = retrofit.create(RetrofitService::class.java)

    fun joinReq(id: Int, pw: String, name: String, age: Int, callback: (ResultModel) -> Unit) {
        val sql = "insert into users values(${id}, '${pw}', '${name}', ${age})"

        service.joinReq(sql).enqueue(object: Callback<ResultModel>
        {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test","${response.body()}")
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test",t.message.toString())
            }
        })
    }


    fun loginReq(id: Int, pw:String, callback: (LoginModel) -> Unit) {
        var sql =" select * from users where id=${id} and pw='${pw}'"

        service.loginReq(sql).enqueue(object: Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                Log.d("test", "${response.body()}")
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Log.d("test",t.message.toString())
            }
        })
    }

    fun getUsersReq(id: Int, callback:(ArrayList<UserModel>) -> Unit){
        val sql ="select * from users where id = ${id}"

        service.getUsersReq().enqueue(object : Callback<ArrayList<UserModel>> {
            override fun onResponse(call: Call<ArrayList<UserModel>>, response:Response<ArrayList<UserModel>>){
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<ArrayList<UserModel>>, t: Throwable) {
                Log.d("test",t.message.toString())
            }
        })
    }



    //?????? ?????? ?????? ??????:: update -?????? ??????, ????????????
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

    fun teacheridReq(teacherid: Int,callback: (ResultModel) -> Unit){
        val sql="select exists ( select teacherid from teacher where teacherid=${teacherid}) as isChk"
        service.teacheridReq(sql).enqueue(object :Callback<ResultModel>{
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {

            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun studentidReq(studentid: Int,callback: (ResultModel) -> Unit){
        val sql="elect exists ( select studentid from student where studentid=${studentid}) as isChk"
        service.studentidReq(sql).enqueue(object :Callback<ResultModel>{
            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                TODO("Not yet implemented")
            }
        })
    }


        //?????? ?????? ??????
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

    //????????????_new
    fun newHomeworkReq(studentid: Int, deadline: String, content: String, callback: (ResultModel) -> Unit){
        val sql ="insert into homework values(${studentid},'${deadline}','${content}')"

        service.newHomeworkReq(sql).enqueue(object :Callback<ResultModel> {

            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test", "${response.body()}");
                //callback(response.body()!!)
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

    //?????? ??????????????? item ?????????
    //?????? ??????_???????????? ??????, ????????? ????????? ??????????????? ?????? ??? ??? ?????????/ ??????????????? ????????? ??? ??? ??????????
    fun getHomeworkReq(studentid: Int,callback: (ResultModel) -> Unit){
        val sql="select exists (select time from homework where subjectid" +
                " in (select subjectid from subject where studentid=${studentid})) " +
                " as isChk"
        service.getHomeworkReq(sql).enqueue(object :Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test", "${response.body()}");
                //callback(response.body()!!)
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

    //????????????_??????
    fun postHomeworkReq(image: String,studentid: Int,teacherid: Int,callback: (ResultModel) -> Unit){
        //?????? sql?????? ????????????, ???????????? ???????????? ??? ????????? ???????????? ??? ????????? ????????? ????????? ??? ????????? ??????????????? 
        //?????? ?????? ??????, ???????????? id??? ????????? id??? ?????? ????????? ????????? ????????? ????????? ?????? ?????? ????????? ??????????????? ?????????
        val sql="insert into homework values('${image}')"
        
        service.postHomeworkReq(sql).enqueue(object :Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test", "${response.body()}")
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
            
        })
    }

    //????????????_?????????
    fun delectHomeworkReq(teacherid: Int,studentid: Int,deadline: String,callback: (ResultModel) -> Unit){
        val sql="delete from homework where teacherid=${teacherid} and studentid=${studentid} and deadline='${deadline}'"

        service.deleteHomeworkReq(sql).enqueue(object :Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test", "${response.body()}")
                callback(response.body()!!)
            }
            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

    //????????????_newtuition
    fun newSubjectReq( title: String, teacherid: Int,studentid: Int,callback: (ResultModel) -> Unit){
        val sql="insert into subject values('${title}', ${teacherid}, ${studentid})"

        service.newSubjectReq(sql).enqueue(object :Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("test", "${response.body()}")
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }


    //?????? ??????_?????? id ???????????? ?????? ???????????? ????????? ???????????? ?????? ???????????? ?????????
    fun deleteSubjectReq(studentid: Int,callback: (ResultModel) -> Unit){
        val sql= "delete from subject where studentid=${studentid} "

        service.deleteSubjectReq(sql).enqueue(object :Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                Log.d("subject_delete","${response.body()}");
                callback(response.body()!!)
            }

            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                Log.d ("subject_delete",t.message.toString())
            }
        })

    }

}