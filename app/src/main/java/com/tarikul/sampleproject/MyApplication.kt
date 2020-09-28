package com.tos.android_retrofit_mvvm_jetpack_kotlin

import android.app.Application

/**
 *Created by tarikul on 9/9/20
 */
class MyApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}