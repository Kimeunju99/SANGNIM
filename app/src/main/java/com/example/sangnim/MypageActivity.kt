package com.example.sangnim

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.mypage.*

class MypageActivity: AppCompatActivity() {
    var ID = ""
    var PN = ""
    var PW = "" //DB에서 가져온 값 저장할 변수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage) //화면 UI: mypage.xml

        //알림 스위치 상태 저장
        var sharedPreferences = getSharedPreferences("save", MODE_PRIVATE)
        btn_swich.setChecked(sharedPreferences.getBoolean("value", true))
    }

    fun initialization(){ //정보 초기화
        //TODO: 테이블 정보 가져오기

        set_id.setText(ID)
        set_pn.setText(PN)
    }

    fun mypage_btn_click(view: View) {
        when(view.id){
            R.id.btn_info_update -> { //회원 정보 수정
                //initialization() 불러오기
            }
            R.id.btn_leave -> { //회원 탈퇴 기능

            }
            R.id.btn_swich -> { //알림 제어 기능(야간 알림 차단)
                if (btn_swich.isChecked) { //스위치가 켜져있다(야간 알림을 안받는 상태)
                    //알림 스위치 상태 저장
                    var editor = getSharedPreferences("save", MODE_PRIVATE).edit()
                    editor.putBoolean("value", true)
                    editor.apply()
                    btn_swich.setChecked(true)
                    //TODO: 알림 차단 해제 작성
                    Toast.makeText(this.getApplicationContext(), "알림 차단 해제", Toast.LENGTH_SHORT)
                        .show()

                } else {//스위치가 꺼져있다(야간 알림을 받는 상태.)
                    var editor = getSharedPreferences("save", MODE_PRIVATE).edit()
                    editor.putBoolean("value", false)
                    editor.apply()
                    btn_swich.setChecked(false)
                    //TODO: 알림 차단 활성화 작성
                    Toast.makeText(this.getApplicationContext(), "알림 차단 활성화", Toast.LENGTH_SHORT)
                        .show()

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