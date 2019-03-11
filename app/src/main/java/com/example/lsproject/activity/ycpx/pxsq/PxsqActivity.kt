package com.example.lsproject.activity.ycpx.pxsq

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import com.example.lsproject.R
import com.example.lsproject.activity.ycpx.wdpx.WdpxDetailActivity
import com.example.lsproject.adapter.PxsqAdapter
import com.example.lsproject.adapter.WdpxAdapter
import com.example.lsproject.bean.WdpxBean
import com.handmark.pulltorefresh.library.PullToRefreshBase
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_pxsq.*
import java.util.ArrayList

/**
 * 培训申请
 */
class PxsqActivity : BaseActivity() {
    private var mAdapter:  PxsqAdapter? = null

    private var title = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pxsq)
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


        pullToRefreshListView.mode = PullToRefreshBase.Mode.DISABLED
        if (mAdapter == null){
            mAdapter = PxsqAdapter(pxjhBeanList,this@PxsqActivity,title)
            pullToRefreshListView.setAdapter(mAdapter)
        }else{
            mAdapter!!.notifyDataSetChanged()
        }

        mAdapter!!.setOnIsApply { id, position ->

                var builder = AlertDialog.Builder(this@PxsqActivity)

                builder.setTitle("提示")
                builder.setMessage("确定申请此课程么？")

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
        pullToRefreshListView.setOnItemClickListener { adapterView, view, i, l ->

            var intent = Intent(this@PxsqActivity, WdpxDetailActivity::class.java)
            intent.putExtra("id",pxjhBeanList[i-1].id)
            intent.putExtra("flag","0")
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }
}
