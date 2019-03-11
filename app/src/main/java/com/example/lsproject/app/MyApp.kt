package com.example.lsproject.app

import android.app.Activity
import android.app.Application
import android.util.Log
import java.util.*

class MyApp : Application() {

    companion object {
        // activity管理
        private var activities: ArrayList<Activity>? = null
//
        fun getActivies() = activities!!
//        // 学区管理
//        var districtBeanList: ArrayList<SelectBean>? = null
//        // 学期管理
//        var termBeanList: ArrayList<SelectBean>? = null
//        // 首页列表
//        var homeModels: List<HomeBean>? = null
    }

    override fun onCreate() {
        super.onCreate()
//        // 初始化bugly异常监听
//        CrashReport.initCrashReport(this)
        // 初始化activity数组
        activities = ArrayList()
//        districtBeanList = ArrayList()
//        termBeanList = ArrayList()
//        homeModels = ArrayList()
//
//        //初始化X5内核
//        QbSdk.initX5Environment(this, object : QbSdk.PreInitCallback {
//            override fun onCoreInitFinished() {
//                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。
//                Log.e("cyf77", "加载内核是否成功")
//            }
//
//            override fun onViewInitFinished(b: Boolean) {
//                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
//                Log.e("cyf77", "加载内核是否成功:" + b)
//            }
//        })
    }

}
