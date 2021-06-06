package com.example.sangnim

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class QuizStudent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_student)

        //프로그레스 바
        val ProgCircle: ProgressBar = findViewById(R.id.hit_per)
        ProgCircle.setProgress(70);


    }
}