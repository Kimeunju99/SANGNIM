package com.example.sangnim

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tuition.*
import kotlinx.android.synthetic.main.tuition_select.*
import kotlinx.android.synthetic.main.work_lastlist.*

class SelecttuitionActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{
    
    //멤버변수 선언,지난 숙제도 만들때 여기 만들어 주면 된다
    private lateinit var worklist: Worklist
    private lateinit var worklastlist: Worklastlist
    
    companion object{
        const val TAG:String ="로그"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.tuition_select)




        val workList = arrayListOf(
                Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
                Worklist(R.drawable.work, "4.8 ~ 4.10", "비문학", "홍"),
                Worklist(R.drawable.work, "4.12 ~ 4.18", "오답노트", "홍길동"),
                Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
                Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
                Worklist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동")
        )
        //work_list.xml의 리사이클id명을 사용
        work_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        work_list.setHasFixedSize(true)
        work_list.adapter = WorklistAdapter(workList)

        val worklastList = arrayListOf(
                Worklastlist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
                Worklastlist(R.drawable.work, "4.8 ~ 4.10", "비문학", "홍"),
                Worklastlist(R.drawable.work, "4.12 ~ 4.18", "오답노트", "홍길동"),
                Worklastlist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
                Worklastlist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동"),
                Worklastlist(R.drawable.work, "4.4 ~ 4.8", "독해", "홍길동")
        )
        //work_lastlist.xml의 리사이클id명을 사용
        work_lastlist.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        work_lastlist.setHasFixedSize(true)
        work_lastlist.adapter = WorklastlistAdapter(worklastList)

        //삭제버튼
        btn_delect.setOnClickListener {
            val intent = Intent(this, DelectActivity::class.java)
            startActivity(intent)
        }
        
        Navi.setOnNavigationItemSelectedListener (this)

        //처음실행시 add 한번 실행시켜줘야하기 때문에 여기서 한번 실행되는 것
        worklist = Worklist.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.tuition_frame,worklist).commit()
    }

    
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG,"바텀바")
        
        //바텀바 클릭시 이동
        when(item.itemId){
            R.id.work_list->{
                worklist = Worklist.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.tuition_frame,worklist).commit()

            }
            R.id.lastwork_list->{
                //지난 숙제를 보여줈 수 있는 class 필요
                worklastlist = Worklastlist.newInstance()
                //변경 필요==> worklist->worklastlist
                supportFragmentManager.beginTransaction().replace(R.id.tuition_frame,worklastlist).commit()
            }
        }
        
        return true
    }
}