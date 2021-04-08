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
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //supportActionBar?.setDisplayShowTitleEnabled(false) //기본 메뉴바 삭제
        setSupportActionBar(findViewById(R.id.toolbar))
    }
    //툴바
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tuition_menu, menu)

        var add_T = menu?.findItem(R.id.add_tui)
        //return false = 메뉴 숨김
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_tui) {
            // TODO: 2021-04-05 새 과외 만드는 페이지로 go
        }
        return super.onOptionsItemSelected(item)
    }

    fun go_tui(view: View) {

    }


}