package com.example.sangnim

import android.app.ListActivity
import android.os.Bundle

public class TuitionActivity: ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tuition) //화면 UI: tuition.xml
        // 리스트() = 현재 진행 중인 과외 목록
        // 리스트 아이템 클릭 -> tuition_select 페이지로 이동 , 새 액티비티 필요
        //플로팅 버튼 = 새과외 추가 -> tuition_new 레이아웃, 새 액티비티 필요
    }
}