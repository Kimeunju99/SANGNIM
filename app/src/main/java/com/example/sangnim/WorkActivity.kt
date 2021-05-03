package com.example.sangnim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_work.*

/*숙제페이지
* 목록은 기존에 있던 Worklist 사용
* Worklist 중 하나의 item 클릭시 숙제업로드가 가능하도록 worklist_dialog 사용
* 숙제등록 버튼 클릭시 db연결 필요 work_new
* 지난숙제 버튼 클릭시 work_lastlist*/

class WorkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        //숙제등록버튼 클릭시
        work_new.setOnClickListener{
            val intent = Intent(this, work_new::class.java)
            startActivity(intent)
        }

        //지난 숙제버튼 클릭시시
       work_lastlist.setOnClickListener{
            val intent = Intent(this, work_lastlist::class.java)
           startActivity(intent)
        }

    }
}