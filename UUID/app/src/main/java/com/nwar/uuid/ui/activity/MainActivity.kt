package com.nwar.uuid.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.nwar.uuid.R
import com.nwar.uuid.databinding.ActivityMainBinding
import com.nwar.uuid.ui.base.BaseActivity
import com.tedpark.tedpermission.rx2.TedRx2Permission
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var wifiScanServiceIntent : Intent

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.ACCESS_WIFI_STATE)==PackageManager.PERMISSION_GRANTED) {
            startService()
        } else {
            requestPermission()
        }
    }

    private fun checkPermission(vararg permission : String) : Int {
        var result = PackageManager.PERMISSION_GRANTED
        permission.forEach { if(checkSelfPermission(it)==PackageManager.PERMISSION_DENIED) result = PackageManager.PERMISSION_DENIED }
        return result
    }

    private fun requestPermission() {
        TedRx2Permission.with(this)
            .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CHANGE_WIFI_STATE, Manifest.permission.ACCESS_WIFI_STATE)
            .request()
            .subscribe({
                if(it.isGranted) startService()
                else toast("권한요청 실패")
            }, {t: Throwable? -> })
    }

    private fun startService() = startService(wifiScanServiceIntent)
}
