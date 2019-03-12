package com.example.lsproject.activity.zxxk

import android.app.AlertDialog
import android.os.Bundle
import com.example.lsproject.R
import com.example.lsproject.adapter.ZxxkAdapter
import com.example.lsproject.bean.WdpxBean
import com.handmark.pulltorefresh.library.PullToRefreshBase
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_zxxk.*

/**
 * 在线选课
 */
class ZxxkActivity : BaseActivity() {

    private var mAdapter: ZxxkAdapter? = null
    private var  title = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zxxk)
        setLeftBtn(true)
        title = intent.getStringExtra("title")
        setTextTitle(title)
        initView()
    }

    private fun initView() {
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


        pullToRefreshListView.mode = PullToRefreshBase.Mode.DISABLED
        if (mAdapter == null){
            mAdapter = ZxxkAdapter(pxjhBeanList,this@ZxxkActivity,title)
            pullToRefreshListView.setAdapter(mAdapter)
        }else{
            mAdapter!!.notifyDataSetChanged()
        }

        mAdapter!!.setOnIsApply { id, position ->

            var builder = AlertDialog.Builder(this@ZxxkActivity)

            builder.setTitle("提示")
            builder.setMessage("确定报名此课程么？")

            builder.setPositiveButton("确定") { dialog, which ->
                //                SPTools.put(this,Constant.SESSIONID,"1111");

                hideSoftInput()
                dialog.dismiss()
                finish()
            }
            builder.setNegativeButton("取消") { dialog, which ->
                dialog.dismiss()
            }
            builder.show()

        }

    }
}
