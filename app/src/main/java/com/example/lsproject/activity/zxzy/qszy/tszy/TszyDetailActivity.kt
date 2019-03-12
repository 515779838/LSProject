package com.example.lsproject.activity.zxzy.qszy.tszy

import android.os.Bundle
import android.view.View
import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.header_tbzy_detail.*

class TszyDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tszy_detail)

        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))
        initView()
    }

    private fun initView() {
        iv_love.visibility = View.GONE
    }
}
