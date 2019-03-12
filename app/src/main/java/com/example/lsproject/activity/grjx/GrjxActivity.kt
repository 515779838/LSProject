package com.example.lsproject.activity.grjx

import android.content.Intent
import android.os.Bundle

import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_grjx.*

/**
 * 个人绩效
 */
class GrjxActivity : BaseActivity() {

    private var title = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grjx)
        setLeftBtn(true)
        title = intent.getStringExtra("title")
        setTextTitle(title)
        initView()
    }

    private fun initView() {
        tv_detail.setOnClickListener {
            var intent = Intent(this@GrjxActivity,GrjxDetailActivity::class.java)
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }
}
