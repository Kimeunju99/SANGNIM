package com.example.sangnim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workList = arrayListOf(
            Worklist(R.drawable.work,"4.4 ~ 4.8","독해","홍길동"),
            Worklist(R.drawable.work,"4.8 ~ 4.10","비문학","홍"),
            Worklist(R.drawable.work,"4.12 ~ 4.18","오답노트","홍길동"),
            Worklist(R.drawable.work,"4.4 ~ 4.8","독해","홍길동"),
            Worklist(R.drawable.work,"4.4 ~ 4.8","독해","홍길동"),
            Worklist(R.drawable.work,"4.4 ~ 4.8","독해","홍길동")
        )
        work_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        work_list.setHasFixedSize(true)
        work_list.adapter = WorklistAdapter(workList)
    }

}