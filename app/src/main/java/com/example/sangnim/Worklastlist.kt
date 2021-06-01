package com.example.sangnim

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Worklastlist (val list:Int, val date:String, val name:String, val tutor:String) : Fragment() {

    companion object{
        const val TAG: String ="로그"

        fun newInstance() : Worklastlist {
            return Worklastlist(2,"","","")
        }
    }

    //메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"Worklastlist - onCreate() called")
    }

    //프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"Worklastlist - onAttach() called")
    }

    //뷰가 생성되었을 때
    //프레그먼트와 레이아웃 연결 부분
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(R.layout.work_lastlist,container,false)

        return  view
    }


}