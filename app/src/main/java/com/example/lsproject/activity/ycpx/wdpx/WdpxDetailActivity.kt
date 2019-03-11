package com.example.lsproject.activity.ycpx.wdpx

import android.os.Bundle
import android.view.LayoutInflater

import com.example.lsproject.R
import com.example.lsproject.adapter.WdpxDetailAdapter
import com.example.lsproject.bean.WdpxBean
import com.handmark.pulltorefresh.library.PullToRefreshBase
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_wdpx_detail.*
import java.util.ArrayList

class WdpxDetailActivity : BaseActivity() {

    private var mAdapter: WdpxDetailAdapter? = null
    private var title = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wdpx_detail)
        initView()
    }

    private fun initView() {
        title = intent.getStringExtra("title")
        setTextTitle(title)
        setData()

    }

    private fun setData() {
        var pxjhBeanList =  ArrayList<WdpxBean>()

        val homeBean1 = WdpxBean("1", "2018年第四季度", "2018年")
        val homeBean2 = WdpxBean("2", "2018年第四季度", "2018年")
        val homeBean3 = WdpxBean("3", "2018年第四季度", "2018年")
        val homeBean4 = WdpxBean("4", "2018年第四季度", "2018年")

        pxjhBeanList.add(homeBean1)
        pxjhBeanList.add(homeBean2)
        pxjhBeanList.add(homeBean3)
        pxjhBeanList.add(homeBean4)

        var headView = LayoutInflater.from(this).inflate(R.layout.header_wdpx_detail, null)
        pullToRefreshListView.refreshableView.addHeaderView(headView)
        pullToRefreshListView.mode = PullToRefreshBase.Mode.DISABLED
        if (mAdapter == null){
            mAdapter = WdpxDetailAdapter(pxjhBeanList,this@WdpxDetailActivity,title)
            pullToRefreshListView.setAdapter(mAdapter)
        }else{
            mAdapter!!.notifyDataSetChanged()
        }

        pullToRefreshListView.setOnItemClickListener { adapterView, view, i, l ->

//            var intent = Intent(this@WdpxDetailActivity, PxjhDetailActivity::class.java)
//            intent.putExtra("id",pxjhBeanList[i-1].id)
//            startActivity(intent)
        }
    }
}