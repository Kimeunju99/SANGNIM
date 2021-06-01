package com.example.sangnim

import android.os.Handler;
import android.os.Message;
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro)

        var handler = Handler()
            handler . postDelayed ({
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }, 3000)
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}