package com.example.lsproject.activity.grjx

import android.os.Bundle

import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity

class GrjxDetailActivity : BaseActivity() {
    private var title = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grjx_detail)
        setLeftBtn(true)
        title = intent.getStringExtra("title")
        setTextTitle(title)
        initView()
    }

    private fun initView() {

    }
}
