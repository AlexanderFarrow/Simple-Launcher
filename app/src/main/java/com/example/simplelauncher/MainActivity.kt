package com.example.simplelauncher

import android.content.Context
import android.content.pm.LauncherActivityInfo
import android.content.pm.LauncherApps
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getInstalledApps()
    }

    private fun getInstalledApps() {
        val userManager = getSystemService(Context.USER_SERVICE) as UserManager
        val launcher = getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps

        val apps: List<LauncherActivityInfo> = launcher.getActivityList(null, userManager.userProfiles[0])

        for (app in apps) {
            val appName = app.label.toString()
            Log.i("Alex", appName)
        }

    }

}
