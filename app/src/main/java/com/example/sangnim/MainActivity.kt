package com.example.sangnim

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var get_I: Int =0
    var get_A: Int =0
    lateinit var get_P: String
    lateinit var get_N: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setExpandableList() //메뉴바에 사용됨

        //사용자 이름 표시
        get_I = intent.getIntExtra("userInputID", 0)
        get_P = intent.getStringExtra("userInputPW").toString()
        get_N = intent.getStringExtra("userInputNAME").toString()
        get_A = intent.getIntExtra("userInputAGE", 0)
        user_name.text = get_N
        //홈 페이지에 과제진행률을 나타내주는 리스트 ; Worklist,WorklistAdapter
        val workList = arrayListOf(
            Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
            Worklist(R.drawable.work, "4.8 ~ 4.10", "비문학", "홍"),
            Worklist(R.drawable.work, "4.12 ~ 4.18", "오답노트", "홍길동"),
            Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
            Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
            Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동")
        )
        work_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        work_list.setHasFixedSize(true)
        work_list.adapter = WorklistAdapter(workList)
    }

    //홈에서 4개의 버튼 클릭 시 페이지 이동
    fun homebtn4_Click(view: View) {
        when (view.id) {
            R.id.btn_chat -> { //채팅 버튼 클릭 시 화면 이동
                val intent = Intent(this, ChatActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_work -> { //과외 버튼 클릭 시 화면 이동
                val intent = Intent(this, TuitionActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_quiz -> {//퀴즈 버튼 클릭 시 화면 이동
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_lastwork -> {//마이페이지 클릭 시 화면 이동
                val intent =Intent(this, MypageActivity::class.java)
                intent.putExtra("userInputID",get_I)
                intent.putExtra("userInputPW",get_P)
                intent.putExtra("userInputNAME",get_N)
                intent.putExtra("userInputAGE",get_A)
                startActivity(intent)
            }
        }
    }

    //메뉴 바 설정: ExpandableListView
    private fun setExpandableList() {
        val parentList = mutableListOf("과외", "숙제", "퀴즈", "채팅", "마이페이지")
        val childList = mutableListOf( //소분류
            mutableListOf("추가", "진행 중 과외"), //과외
            mutableListOf("이번 숙제","지난 숙제"), //숙제
            mutableListOf(), mutableListOf(), mutableListOf() // 퀴즈, 채팅, 마이페이지
        )
        val expandableAdapter = ExpandableListAdapter(this, parentList, childList)
        el_menu.setAdapter(expandableAdapter) //el_menu: 메인 레이아웃에서 ExpandableListView ID
        el_menu.setOnGroupClickListener { parent, v, groupPosition, id ->
            when (groupPosition) {
                2 -> { //퀴즈
                    dl_container.closeDrawer(nv_drawer)
                    val intent = Intent(this, QuizActivity::class.java)
                    startActivity(intent)
                }
                3 -> { //채팅
                    dl_container.closeDrawer(nv_drawer)
                    val intent = Intent(this, ChatActivity::class.java)
                    startActivity(intent)
                }
                4 -> {//마이페이지
                    dl_container.closeDrawer(nv_drawer)
                    val intent =Intent(this, MypageActivity::class.java)
                    intent.putExtra("userInputID", get_I)
                    intent.putExtra("userInputPW",get_P)
                    intent.putExtra("userInputNAME",get_N)
                    intent.putExtra("userInputAGE",get_A)
                    startActivity(intent)
                }
            }
            false
        }
        el_menu.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            when (groupPosition) {
                0 -> { //과외
                    when (childPosition) {
                        0 -> {//추가
                            dl_container.closeDrawer(nv_drawer)
                            //val intent = Intent(this, MypageActivity::class.java)
                            startActivity(intent)
                        }
                        1 -> {//진행 중 과외
                            dl_container.closeDrawer(nv_drawer)
                            val intent = Intent(this, TuitionActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
                1 -> { //숙제
                    when (childPosition) {
                        0 -> {//이번 숙제
                            dl_container.closeDrawer(nv_drawer)
                            //val intent = Intent(this, MypageActivity::class.java)
                            //startActivity(intent)
                        }
                        1 -> {//지난 숙제
                            dl_container.closeDrawer(nv_drawer)
                            //val intent = Intent(this, TuitionActivity::class.java)
                            //startActivity(intent)
                        }
                    }
                    dl_container.closeDrawer(nv_drawer)
                val intent = Intent(this, WorkActivity::class.java)
                startActivity(intent)
            }
            }
            false
        }
    }
    //메뉴 버튼 클릭 시 드로어 열기
    fun menubtn_Click(view: View) {
        dl_container.openDrawer(nv_drawer)
    }
    //뒤로가기 눌렀을 때
    override fun onBackPressed() {
        if (dl_container.isDrawerOpen(nv_drawer)) { //메뉴가 열려 있으면 닫음
            dl_container.closeDrawer(nv_drawer)
        } else
            super.onBackPressed()
    }



}