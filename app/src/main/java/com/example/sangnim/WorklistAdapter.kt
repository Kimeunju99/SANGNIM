package com.example.app_home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorklistAdapter (val workList:ArrayList<Worklist>): RecyclerView.Adapter<WorklistAdapter.WorkListViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorklistAdapter.WorkListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return WorkListViewHolder(view).apply {
            itemView.setOnClickListener {
                
            }
        }
    }

    override fun getItemCount(): Int {
        return workList.size
    }

    override fun onBindViewHolder(holder: WorklistAdapter.WorkListViewHolder, position: Int) {
        holder.list.setImageResource(workList.get(position).list)
        holder.date.text = workList.get(position).date
        holder.name.text = workList.get(position).name
        holder.tutor.text = workList.get(position).tutor
    }

    class WorkListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val list=itemView.findViewById<ImageView>(R.id.work_image) //앞에 이미지
        val date=itemView.findViewById<TextView>(R.id.work_date)   //과제제출기한
        val name=itemView.findViewById<TextView>(R.id.work_name)   //과외 이름
        val tutor=itemView.findViewById<TextView>(R.id.work_tutor)   //과외 선생님 이름

    }

}