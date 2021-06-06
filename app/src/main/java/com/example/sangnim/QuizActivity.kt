package com.example.sangnim

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.quiz.*
import kotlinx.android.synthetic.main.quiz_add.*
import kotlinx.android.synthetic.main.quiz_teacher.*

class QuizActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_teacher)
        //리스트 아이템 클릭 시 과외 내 퀴즈 페이지(quiz_student/quiz_teacher)로 이동
        //사용자 아이디와 선생님/학생 아이디 비교 후 일치하는 페이지로 이동

        val Quizlist = arrayListOf(
            Quizlist("MathQuiz1","Kim","Park")
        )



        /*val QuizListAdapter = QuizlistAdapter(this,Quizlist)
        list_quitui.adapter = QuizListAdapter*/

        quiz_add_button.setOnClickListener{
            quiz_add_Popup()
        }


    }

    private fun quiz_add_Popup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.quiz_add,null)
        val textview: TextView = view.findViewById(R.id.add_quiz)

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("테스트용 퀴즈")
            .setPositiveButton("") { dialog, which ->
                Toast.makeText(applicationContext, "Pushed save", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("", null)
            .create()

        alertDialog.setView(view)
        alertDialog.show()

    }
}