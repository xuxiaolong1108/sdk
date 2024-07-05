package com.xxl.wxtest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.tencent.mm.opensdk.modelmsg.SendAuth

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textLogin =findViewById<TextView>(R.id.text_login)
        textLogin.setOnClickListener {
            Log.i("nole","nole-------------------- 开始登录")
            var req =  SendAuth.Req()
            req.scope = "snsapi_userinfo"; // 只能填 snsapi_userinfo
            req.state = "wechat_sdk_demo_test";
            App.sInstance?.api?.sendReq(req);
        }
    }
}