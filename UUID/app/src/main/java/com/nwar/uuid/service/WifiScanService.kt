package com.nwar.uuid.service

import android.app.*
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.nwar.uuid.R
import com.nwar.uuid.extend.setWifiEnable
import com.nwar.uuid.extend.wifiScan
import com.nwar.uuid.receiver.WifiScanReceiver
import com.nwar.uuid.ui.lifecycle.LifecycleOwner
import com.nwar.uuid.util.intentFilter
import com.nwar.uuid.viewModel.viewModel.WifiScanViewModel
import dagger.android.DaggerIntentService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import okhttp3.internal.waitMillis
import org.jetbrains.anko.notificationManager
import javax.inject.Inject

class WifiScanService() : BaseService("WifiScanService") {

    private val channelId
        get() = "com.nwar.sharp"

    private val channelName
        get() = "Sharp"

    @Inject
    override lateinit var viewModel : WifiScanViewModel

    @Inject
    lateinit var receiver: WifiScanReceiver

    private val notification by lazy {
        NotificationCompat.Builder(applicationContext, channelId)
            .setContentTitle("Wifi 스캔 중..")
            .setContentText("Wifi를 스캔하고 있습니다.")
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setSmallIcon(R.drawable.logo)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    override fun onHandleIntent(intent: Intent?) {
        createNotifyChannelIfRequired()
        startNotification()
        registerReceiver(receiver, intentFilter)
        runBlocking {
            while (true) {
                delay(10000)
                setWifiEnable()
                wifiScan()
            }
        }
    }

    private fun createNotifyChannelIfRequired() =
        if (Build.VERSION.SDK_INT >= 26) notificationManager.createNotificationChannel(
            NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_MIN)
        ) else Unit

    private fun startNotification() {
        startForeground(13245, notification)
        notificationManager.notify(0, notification)
    }
}