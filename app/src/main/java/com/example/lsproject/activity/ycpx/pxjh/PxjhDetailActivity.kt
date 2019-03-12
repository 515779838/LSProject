package com.example.lsproject.activity.ycpx.pxjh

import android.os.Bundle
import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity

class PxjhDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pxjh_detail)
        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))
    }
}
