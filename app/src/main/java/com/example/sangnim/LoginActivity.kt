package com.example.sangnim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

//로그인 페이지
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val et_id=findViewById<EditText>(R.id.et_id)
        val et_pass=findViewById<EditText>(R.id.et_pass)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_register = findViewById<Button>(R.id.btn_register)

        //회원가입버튼
        btn_register.setOnClickListener{
            //val intent :Intent = Intent(LoginActivity.this,RegisterActivity.class)


        }
        
        //로그인버튼
        btn_login.setOnClickListener{
            
        }
    }
}