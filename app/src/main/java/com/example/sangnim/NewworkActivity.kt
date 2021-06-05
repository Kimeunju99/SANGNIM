package com.example.sangnim

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.work_new.*

class NewworkActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.work_new)

        val txt_std_id =findViewById<EditText>(R.id.txt_std_id)
        val txt_date =findViewById<EditText>(R.id.txt_date)
        val txt_content =findViewById<EditText>(R.id.txt_date)

        val btn_newwork =findViewById<Button>(R.id.btn_newwork)

        btn_newwork.setOnClickListener {
            val stdid=txt_std_id.getText().toString().toInt()
            val date = txt_date.getText().toString()
            val content = txt_content.getText().toString()

            Retrofit.newHomeworkReq(stdid,date,content){

            }
        }


    }
}