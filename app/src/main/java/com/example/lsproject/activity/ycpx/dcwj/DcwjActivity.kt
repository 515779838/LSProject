package com.example.lsproject.activity.ycpx.dcwj

import android.content.Intent
import android.os.Bundle
import com.example.lsproject.R
import com.example.lsproject.activity.ycpx.pxjh.PxjhDetailActivity
import com.example.lsproject.adapter.DcwjAdapter
import com.example.lsproject.adapter.PxjhAdapter
import com.example.lsproject.bean.PxjhBean
import com.handmark.pulltorefresh.library.PullToRefreshBase
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dcwj.*
import java.util.ArrayList

/**
 * 调查问卷
 */
class DcwjActivity : BaseActivity() {

    private var mAdapter: DcwjAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dcwj)
        initView()
    }

    private fun initView() {
        setTextTitle(intent.getStringExtra("title"))

        setData()

    }

    private fun setData() {
        var pxjhBeanList =  ArrayList<PxjhBean>()

        val homeBean1 = PxjhBean("1", "2018年第四季度", "2018年")
        val homeBean2 = PxjhBean("2", "2018年第四季度", "2018年")
        val homeBean3 = PxjhBean("3", "2018年第四季度", "2018年")
        val homeBean4 = PxjhBean("4", "2018年第四季度", "2018年")

        pxjhBeanList.add(homeBean1)
        pxjhBeanList.add(homeBean2)
        pxjhBeanList.add(homeBean3)
        pxjhBeanList.add(homeBean4)


        pullToRefreshListView.mode = PullToRefreshBase.Mode.DISABLED
        if (mAdapter == null){
            mAdapter = DcwjAdapter(pxjhBeanList,this@DcwjActivity)
            pullToRefreshListView.setAdapter(mAdapter)
        }else{
            mAdapter!!.notifyDataSetChanged()
        }

    }
}
