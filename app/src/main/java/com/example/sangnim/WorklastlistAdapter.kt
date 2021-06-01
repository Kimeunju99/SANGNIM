package com.example.sangnim

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class WorklastlistAdapter(val worklastLast:ArrayList<Worklastlist>): RecyclerView.Adapter<WorklastlistAdapter.WorkLastListViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorklastlistAdapter.WorkLastListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.worklist_item, parent, false)
        return WorkLastListViewHolder(view).apply {

            //리스트클릭시 실행될 이벤트 등록
            itemView.setOnClickListener {
                //현재 리스트에서 클릭되는 위치(curPos)
                val curPos: Int = adapterPosition
                val worklastlist: Worklastlist = worklastLast.get(curPos)

                //지난 숙제 제출 정보 확인이 가능한 toast
                Toast.makeText(parent.context,"이름:${worklastlist.name}\n",Toast.LENGTH_SHORT).show()
                //item클릭시 숙제를 확인가능한 다이얼로그 연결
                //val dialog = Dialog(parent.context)
                //dialog.setContentView(R.layout.worklist_dialog)
            }
        }

    }

    override fun getItemCount(): Int {
        return worklastLast.size
    }

    override fun onBindViewHolder(holder: WorklastlistAdapter.WorkLastListViewHolder, position: Int) {
        holder.list.setImageResource(worklastLast.get(position).list)
        holder.date.text = worklastLast.get(position).date
        holder.name.text = worklastLast.get(position).name
        holder.tutor.text = worklastLast.get(position).tutor
    }

    class WorkLastListViewHolder(itemView: View):RecyclerView.ViewHolder (itemView){

        val list=itemView.findViewById<ImageView>(R.id.work_image) //앞에 이미지
        val date=itemView.findViewById<TextView>(R.id.student)   //과제제출기한
        val name=itemView.findViewById<TextView>(R.id.title)   //과외 이름
        val tutor=itemView.findViewById<TextView>(R.id.teacher)

    }

}