package com.example.lsproject.activity.main

import android.os.Bundle

import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity

class ChangePwdActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_pwd)
        setLeftBtn(true)
        setTextTitle("修改密码")
    }
}
