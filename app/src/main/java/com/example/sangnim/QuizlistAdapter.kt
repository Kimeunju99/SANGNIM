package com.example.sangnim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class QuizlistAdapter(Quizlist1: QuizActivity, private val Quizlist: ArrayList<Quizlist>) : BaseAdapter() {
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View? {
        var convertView = view

        var QuizTitle = view?.findViewById<TextView>(R.id.title)
        var QuizTeacher = view?.findViewById<TextView>(R.id.teacher)
        var QuizStudent = view?.findViewById<TextView>(R.id.student)

        if (convertView == null) convertView = LayoutInflater.from(parent?.context).inflate(R.layout.quiz_item, parent, false)
        val Quizlist = Quizlist[position]

        QuizTitle?.text = Quizlist.title
        QuizTeacher?.text = Quizlist.Teacher
        QuizStudent?.text = Quizlist.Student

        return convertView
    }

    override fun getItem(position: Int): Quizlist = Quizlist[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = Quizlist.size

}