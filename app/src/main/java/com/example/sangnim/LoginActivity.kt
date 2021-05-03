package com.example.sangnim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_work.*

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
            val intent = Intent(this,RegisterActivity::class.java)
            //val intent = Intent(this, work_new::class.java)
            startActivity(intent)

        }
        
        //로그인버튼
        //DB에서 회원확인시 MainActicity로 이동
        btn_login.setOnClickListener{
            val intent =Intent(this, MainActivity::class.java)
            startActivity(intent)
            
        }
    }
}