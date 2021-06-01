package com.example.sangnim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class QuizActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)
        //리스트 아이템 클릭 시 과외 내 퀴즈 페이지(quiz_student/quiz_teacher)로 이동
        //사용자 아이디와 선생님/학생 아이디 비교 후 일치하는 페이지로 이동

    }
}