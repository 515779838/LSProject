package com.example.lsproject.activity.ycpx.xxda

import android.os.Bundle
import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity

class XxdaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xxda)
        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))
    }
}
