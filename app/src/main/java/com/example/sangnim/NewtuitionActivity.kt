package com.example.sangnim

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewtuitionActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tuition_new)


        val txt_tuition_name=findViewById<EditText>(R.id.txt_tuition_name)
        val txt_teach_id=findViewById<EditText>(R.id.txt_teach_id)
        val txt_std_id=findViewById<EditText>(R.id.txt_std_id)

        val btn_newtuition =findViewById<Button>(R.id.btn_newtuition)

        btn_newtuition.setOnClickListener {
            val txt_tuition_name = txt_tuition_name.getText().toString()
            val txt_teach_id = txt_teach_id.getText().toString().toInt()
            val txt_std_id = txt_std_id.getText().toString().toInt()

            Retrofit.newSubjectReq(txt_tuition_name,txt_teach_id,txt_std_id){

            }

        }

    }
}

