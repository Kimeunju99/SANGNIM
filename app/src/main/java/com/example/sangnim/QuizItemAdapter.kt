package com.example.sangnim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class QuizItemAdapter (private val Quizitem:ArrayList<Quizitem>) : BaseAdapter() {
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {
        var convertView = view

        var QuizOX = view?.findViewById<TextView>(R.id.state)
        var QuizName = view?.findViewById<TextView>(R.id.que)
        var QuizMain = view?.findViewById<TextView>(R.id.question)

        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.quiz_item, parent, false)
        val Quizitem = Quizitem[position]

        QuizOX?.text = Quizitem.OX
        QuizName?.text = Quizitem.Question
        QuizMain?.text = Quizitem.QuestionMain

        return convertView
    }

    override fun getItem(position: Int): Quizitem = Quizitem[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = Quizitem.size

}