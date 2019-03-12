package com.example.lsproject.activity.main

import android.os.Bundle
import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity

class ChangeEmailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_email)
        setLeftBtn(true)
        setTextTitle("修改邮箱")
    }
}
