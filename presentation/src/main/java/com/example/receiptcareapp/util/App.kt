package com.example.receiptcareapp.util

import android.app.Application
import com.example.data.manager.PreferenceManager
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * 2023-01-31
 * pureum
 */
@HiltAndroidApp
// 액티비티 시작전에 작동함
class App:Application(
) {
//    companion object{
//        lateinit var preferenceManager: PreferenceManager
//    }
//
//    override fun onCreate() {
//        preferenceManager = PreferenceManager(applicationContext)
//        super.onCreate()
//    }
}