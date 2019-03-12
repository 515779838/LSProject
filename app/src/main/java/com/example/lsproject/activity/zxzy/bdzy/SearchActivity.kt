package com.example.lsproject.activity.zxzy.bdzy

import android.os.Bundle

import com.example.lsproject.R
import com.example.lsproject.adapter.BdzyAdapter
import com.hhkj.highschool.base.BaseActivity

class SearchActivity : BaseActivity() {
    private val adapter: BdzyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))
        initView()
    }

    private fun initView() {

    }
}
