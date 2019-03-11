package com.example.lsproject.activity.ycpx.pxjh

import android.content.Intent
import android.os.Bundle

import com.example.lsproject.R
import com.example.lsproject.adapter.PxjhAdapter
import com.example.lsproject.bean.PxjhBean
import com.handmark.pulltorefresh.library.PullToRefreshBase
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_pxjh.*
import java.util.ArrayList

/**
 * 培训计划
 */
class PxjhActivity : BaseActivity() {

    private var mAdapter: PxjhAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pxjh)
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
            mAdapter = PxjhAdapter(pxjhBeanList,this@PxjhActivity)
            pullToRefreshListView.setAdapter(mAdapter)
        }else{
            mAdapter!!.notifyDataSetChanged()
        }

        pullToRefreshListView.setOnItemClickListener { adapterView, view, i, l ->

            var intent = Intent(this@PxjhActivity,PxjhDetailActivity::class.java)
            intent.putExtra("id",pxjhBeanList[i-1].id)
            startActivity(intent)
        }
    }
}
