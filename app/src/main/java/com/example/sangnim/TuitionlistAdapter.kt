package com.example.sangnim

import android.app.Dialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tuition.*

//class TuitionlistAdapter(val tuitionList:ArrayList<Tuitionlist>) : RecyclerView.Adapter<TuitionlistAdapter.TuitionListViewHolder>(), ListAdapter
class TuitionlistAdapter(val tuitionList:ArrayList<Tuitionlist>) : RecyclerView.Adapter<TuitionlistAdapter.TuitionListViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TuitionlistAdapter.TuitionListViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.tuition_item,parent,false)
        return TuitionListViewHolder(view).apply {

            itemView.setOnClickListener {

                //현재 리스트에서 클릭되는 위치(curPos)
                val curPos: Int = adapterPosition
                val tuitionlist: Tuitionlist = tuitionList.get(curPos)

                //val intent =Intent(this, SelecttuitionActivity::class.java)
                //startActivity(intent)
                // 리스트 아이템 클릭 -> tuition_select 페이지로 이동 , selecttuitionActivity

            }
        }
    }

    private fun Intent(tuitionListViewHolder: TuitionlistAdapter.TuitionListViewHolder, java: Class<SelecttuitionActivity>) {


    }

    override fun getItemCount(): Int {
        return tuitionList.size
    }

    override fun onBindViewHolder(holder: TuitionlistAdapter.TuitionListViewHolder, position: Int) {
        holder.category.text= tuitionList.get(position).category
        holder.title.text= tuitionList.get(position).title
        holder.teacher.text= tuitionList.get(position).teacher
        holder.student.text= tuitionList.get(position).student

        //item 클릭시 페이지 이동
        holder.itemView.setOnClickListener {
            val intent= android.content.Intent(holder.itemView?.context, SelecttuitionActivity::class.java)
            startActivity(holder.itemView.context,intent,null)
        }

    }

    //tuition_item의 id값
    class TuitionListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val category =itemView.findViewById<TextView>(R.id.category)
        val title=itemView.findViewById<TextView>(R.id.title)
        val teacher=itemView.findViewById<TextView>(R.id.teacher)
        val student=itemView.findViewById<TextView>(R.id.student)

    }

}