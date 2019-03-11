package com.example.lsproject.activity.yxxx

import android.os.Bundle

import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity

/**
 * 课程描述
 */
class KcmsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kcms)
        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))
    }
}
