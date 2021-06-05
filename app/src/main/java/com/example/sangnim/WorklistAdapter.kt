package com.example.sangnim


import android.app.Dialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tuition_select_student.*

//리사이클러뷰 사용
class WorklistAdapter (val workList:ArrayList<Worklist>): RecyclerView.Adapter<WorklistAdapter.WorkListViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorklistAdapter.WorkListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.worklist_item, parent, false)
        return WorkListViewHolder(view).apply {

            //리스트클릭시 실행될 이벤트 등록
            itemView.setOnClickListener {
                //현재 리스트에서 클릭되는 위치(curPos)
                val curPos: Int = adapterPosition
                val worklist : Worklist = workList.get(curPos)

                val teacherid =itemView.findViewById<TextView>(R.id.teacher)
                val t_id = teacherid.getText().toString().toInt()
                val req=Retrofit.teacheridReq(t_id){}
                val ans =req.toString().toInt()

                if(ans==1){ //선생님 아이디가 선생님 테이블에 존재하는 경우_아이템 클릭시 과제 삭제다이얼로그
                    val deletewui = Dialog(parent.context)
                    deletewui.setContentView(R.layout.deletewui_dialog)
                }else{
                    val dialog = Dialog(parent.context)
                    dialog.setContentView(R.layout.worklist_dialog)
                }
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
        val date=itemView.findViewById<TextView>(R.id.student)   //과제제출기한
        val name=itemView.findViewById<TextView>(R.id.title)   //과외 이름
        val tutor=itemView.findViewById<TextView>(R.id.teacher)   //과외 선생님 이름

    }

}