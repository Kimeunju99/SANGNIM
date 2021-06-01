package com.example.sangnim

import android.app.AlertDialog
import android.app.Dialog
import android.app.NotificationManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mypage.*
import kotlinx.android.synthetic.main.mypage_del.*

class MypageActivity: AppCompatActivity() {
    var get_I: Int =0
    var get_A: Int =0
    lateinit var get_P: String
    lateinit var get_N: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage) //화면 UI: mypage.xml

        get_I = intent.getIntExtra("userInputID", 0)
        get_P = intent.getStringExtra("userInputPW").toString()
        get_N = intent.getStringExtra("userInputNAME").toString()
        get_A = intent.getIntExtra("userInputAGE", 0)
        set_id.setText(get_I.toString())
        set_name.setText(get_N)

        //알림 스위치 상태 저장
        val sharedPreferences = getSharedPreferences("save", MODE_PRIVATE)
        btn_swich.setChecked(sharedPreferences.getBoolean("value", true))
    }

    //정보 초기화
    fun initialization(){
        Retrofit.getUsersReq(get_I) {
            Log.d("initial", it.get(it.lastIndex).toString())
            get_I = it.get(it.lastIndex).id
            get_N = it.get(it.lastIndex).name
            set_id.setText(get_I.toString())
            set_name.setText(get_N)
        }
    }

    fun mypage_btn_click(view: View) {
        when(view.id){
            R.id.btn_info_update -> { //회원 정보 수정
                val builder = AlertDialog.Builder(this)
                val dialogView = layoutInflater.inflate(R.layout.mypage_up, null)
                val name = dialogView.findViewById<EditText>(R.id.name)
                val pass = dialogView.findViewById<EditText>(R.id.pass)

                builder.setView(dialogView).setPositiveButton("확인") { dialogInterface, i ->
                        if(name.length() != 0 && pass.length() != 0){ //이름,비밀번호 모두 변경
                            get_N = name.text.toString()
                            get_P = pass.text.toString()
                            //이름과 비번은 바뀌는 정보
                            Retrofit.updateUserReq(1, get_I, get_N, get_P){
                                    Log.d("update",it.toString())
                                    Toast.makeText(this, "정보 수정 완료", Toast.LENGTH_SHORT).show()
                            }

                            this.initialization() //정보 수정
                        }else if (name.length() != 0 && pass.length() == 0){//이름 변경
                            get_N = name.text.toString()
                            Retrofit.updateUserReq(2, get_I, get_N, get_P){
                                Log.d("update",it.toString())
                                Toast.makeText(this, "정보 수정 완료", Toast.LENGTH_SHORT).show()
                             }
                            initialization() //정보 수정
                        }else if (name.length() == 0 && pass.length() != 0){//비밀번호 변경
                            get_P = pass.text.toString()
                            Retrofit.updateUserReq(3, get_I, get_N, get_P){
                                    Log.d("update",it.toString())
                                    Toast.makeText(this, "정보 수정 완료", Toast.LENGTH_SHORT).show()
                            }
                            initialization() //정보 수정
                        }
                }.setNeutralButton("취소", null).show()
            }
            R.id.btn_leave -> { //회원 탈퇴 기능
                val builder = AlertDialog.Builder(this)
                val dialogView = layoutInflater.inflate(R.layout.mypage_del, null)
                val delpass = dialogView.findViewById<EditText>(R.id.delpass)

                builder.setView(dialogView).setPositiveButton("확인") { dialogInterface, i ->
                        if (delpass.length() == 0){ //비밀번호 미입력
                            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                        }
                        else if(delpass.text.toString().equals(get_P)){//비밀번호 일치
                            Retrofit.deleteUserReq(get_I) {
                                Log.d("delete",it.toString())
                                Toast.makeText(this, "탈퇴하셨습니다.", Toast.LENGTH_SHORT).show()
                            }
                            //탈퇴 시 로그인 홈으로 이동
                            var intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }else{//비밀번호 불일치
                            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                        }
                }.setNeutralButton("취소", null).show()
            }
            R.id.btn_swich -> { //알림 제어 기능(야간 알림 차단)
                if (btn_swich.isChecked) {
                    //알림 스위치 상태 저장
                    val editor = getSharedPreferences("save", MODE_PRIVATE).edit()
                    editor.putBoolean("value", true)
                    editor.apply()
                    btn_swich.setChecked(true)
                    //TODO: 알림 차단 활성화 작성




                    Toast.makeText(this.getApplicationContext(), "알림 차단 활성화", Toast.LENGTH_SHORT).show()
                } else {
                    val editor = getSharedPreferences("save", MODE_PRIVATE).edit()
                    editor.putBoolean("value", false)
                    editor.apply()
                    btn_swich.setChecked(false)
                    //TODO: 알림 차단 해제 작성





                    Toast.makeText(this.getApplicationContext(), "알림 차단 해제", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    //알림 채널 사용 가능 여부
    fun isNotificationChannelEnabled(context: Context, @Nullable channelId: String?): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!TextUtils.isEmpty(channelId)) {
                val manager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val channel = manager.getNotificationChannel(channelId)
                return channel.importance != NotificationManager.IMPORTANCE_NONE
            }
            false
        } else {
            NotificationManagerCompat.from(context).areNotificationsEnabled()
        }
    }

}