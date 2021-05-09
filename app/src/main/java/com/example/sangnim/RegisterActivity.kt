package com.example.sangnim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

//회원가입 페이지
class RegisterActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val et_id=findViewById<EditText>(R.id.et_id)
        val et_pass=findViewById<EditText>(R.id.et_pass)
        val et_name=findViewById<EditText>(R.id.et_name)
        val et_age=findViewById<EditText>(R.id.et_age)

        val btn_register = findViewById<Button>(R.id.btn_register)

        //현재 edittext에 입력되어있는 값을 가져온다
        btn_register.setOnClickListener{
            val userID =et_id.getText().toString().toInt()
            val userPass =et_pass.getText().toString()
            val userName =et_name.getText().toString()
            val userAge =et_age.getText().toString().toInt()

            //실제적인 회원가입 요청, Response.Listener <String> 이용
            Retrofit.joinReq(userID, userPass, userName, userAge){

            }

            }
        //서버로 volley를 이용해서 요청
        //val registerRequest= RegisterRequest(userID,userPass,UserName,userAge,listener)
        //val queue  = Volley.newRequestQueue(context)
        //queue.add(registerRequest)


        



        }

    }
