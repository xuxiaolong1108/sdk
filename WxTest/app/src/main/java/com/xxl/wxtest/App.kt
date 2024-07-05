package com.xxl.wxtest

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.tencent.mm.opensdk.constants.ConstantsAPI
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

class App : Application() {
    companion object {
        var sInstance: App? = null;
    }

    var api: IWXAPI? = null
    override fun onCreate() {
        super.onCreate()
        sInstance = this
        api = WXAPIFactory.createWXAPI(this, Constants.APP_ID, true)

        Log.i("nole","nole-------------------- 微信注册no")
        api?.registerApp(Constants.APP_ID)

        registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {

            }
        }, IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP))
    }
}