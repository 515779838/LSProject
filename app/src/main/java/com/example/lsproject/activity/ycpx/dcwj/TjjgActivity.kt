package com.example.lsproject.activity.ycpx.dcwj

import android.os.Bundle
import com.example.lsproject.R
import com.example.lsproject.adapter.DcwjAdapter
import com.example.lsproject.adapter.TjjgAdapter
import com.example.lsproject.bean.PxjhBean
import com.handmark.pulltorefresh.library.PullToRefreshBase
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_dcwj.*
import java.util.ArrayList

/**
 * 统计结果
 */
class TjjgActivity : BaseActivity() {

    private var mAdapter: TjjgAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tjjg)
        initView()
    }

    private fun initView() {
        setTextTitle(intent.getStringExtra("title"))
//        setData()
    }

//    private fun setData() {
//        var pxjhBeanList =  ArrayList<PxjhBean>()
//
//        val homeBean1 = PxjhBean("1", "2018年第四季度", "2018年")
//        val homeBean2 = PxjhBean("2", "2018年第四季度", "2018年")
//        val homeBean3 = PxjhBean("3", "2018年第四季度", "2018年")
//        val homeBean4 = PxjhBean("4", "2018年第四季度", "2018年")
//
//        pxjhBeanList.add(homeBean1)
//        pxjhBeanList.add(homeBean2)
//        pxjhBeanList.add(homeBean3)
//        pxjhBeanList.add(homeBean4)
//
//
//        pullToRefreshListView.mode = PullToRefreshBase.Mode.DISABLED
//        if (mAdapter == null){
//            mAdapter = TjjgAdapter(pxjhBeanList,this@TjjgActivity)
//            pullToRefreshListView.setAdapter(mAdapter)
//        }else{
//            mAdapter!!.notifyDataSetChanged()
//        }
//
//    }
}
