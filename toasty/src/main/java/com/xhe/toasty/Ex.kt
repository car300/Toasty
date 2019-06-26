package com.xhe.toasty

import android.app.AppOpsManager
import android.app.NotificationManager
import android.content.Context
import android.os.Build

/**
 * Created by hsh on 2019-06-26 14:15
 */

/**
 * 检测是否有通知权限
 */
fun Context.areNotificationsEnabled(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        val notificationManager = this.getSystemService(NotificationManager::class.java)
        return notificationManager.areNotificationsEnabled()
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        val appOpsManager = this.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val uid = this.applicationInfo.uid
        return AppOpsManager.MODE_ALLOWED == appOpsManager.checkOpNoThrow("OP_POST_NOTIFICATION", uid, this.packageName)
    }
    return true
}