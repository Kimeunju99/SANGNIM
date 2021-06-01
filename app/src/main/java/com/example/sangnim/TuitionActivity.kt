package com.example.sangnim

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tuition.*

public class TuitionActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tuition)
        // 리스트() = 현재 진행 중인 과외 목록


        // 리스트 아이템 클릭 -> tuition_select 페이지로 이동 , selecttuitionActivity==> TuitionlistAdapter.kt에서 연결
        val tuitionList = arrayListOf(
            Tuitionlist("카테고리","타이틀","선생님","학생"),
            Tuitionlist("카테고리2","타이틀2","선생님2","학생2")
        )
        // 데이터값을 tuition.xml 리스트에 뿌려준다
        list_tui.layoutManager =LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        list_tui.setHasFixedSize(true)
        list_tui.adapter =TuitionlistAdapter(tuitionList)



        //플로팅 버튼 = 새과외 추가 -> tuition_new 레이아웃, 새 액티비티 필요
        addtui_button.setOnClickListener {
            val intent = Intent(this, NewtuitionActivity::class.java)
            startActivity(intent)
        }


    }
}