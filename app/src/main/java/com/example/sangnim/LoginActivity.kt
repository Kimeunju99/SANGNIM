package com.example.sangnim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//로그인 페이지
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val et_id=findViewById<EditText>(R.id.et_id)
        val et_pass=findViewById<EditText>(R.id.et_pass)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_register = findViewById<Button>(R.id.btn_register)
        val textTest = findViewById<TextView>(R.id.text_test)
//
//        Retrofit.getUsersReq {
//            Log.d("test",it.get(it.lastIndex).toString())
//            textTest.text = it.get(it.lastIndex).name
//        }

        //회원가입버튼
        btn_register.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            //val intent = Intent(this, work_new::class.java)
            startActivity(intent)

        }


        //로그인버튼
        //DB에서 회원확인시 MainActicity로 이동
        btn_login.setOnClickListener{
//

            val userInputID =et_id.getText().toString().toInt()
            val userInputPass =et_pass.getText().toString()
            Retrofit.loginReq(userInputID, userInputPass){
                if(it.result=="fail"){
                    Log.d("test","not")
                    Toast.makeText(this, "가입정보가 없습니다.", Toast.LENGTH_SHORT).show()
                }else {
                    Log.d("test",it.toString())
                    val intent =Intent(this, MainActivity::class.java)
                    intent.putExtra("userInputID",it.id)
                    intent.putExtra("userInputPW",it.pw)
                    intent.putExtra("userInputNAME",it.name)
                    intent.putExtra("userInputAGE",it.age)
                    startActivity(intent)
                }
            }

        }
    }
}