package com.example.sangnim

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.quiz_add.*
import kotlinx.android.synthetic.main.quiz_teacher.*
import kotlinx.android.synthetic.main.quiz_teacher.view.*

class QuizTeacher : AppCompatActivity() {

    private val DEFAULT_PATTERN = "%d%%"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_teacher)

        var quiz_count = et_id.num_que
        var quiz_answer = et_id.num_ans


        //퀴즈 추가
        add_button.setOnClickListener{
            val intent = Intent(this, add_quiz::class.java)
            startActivity(intent)

        }

        /* var quiz_all = quiz_answer / quiz_count * 100

        //프로그레스 바
        val ProgCircle: ProgressBar = findViewById(R.id.hit_per)
        ProgCircle.setProgress(quiz_all); // 퀴즈 계수에 따라 다르게*/
    }

}