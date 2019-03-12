package com.example.lsproject.activity.zxzy.qszy.tbzy

import android.content.Intent
import android.os.Bundle
import com.example.lsproject.R
import com.example.lsproject.activity.zxzy.qszy.tszy.TszyDetailActivity
import com.example.lsproject.adapter.TbzyAdapter
import com.example.lsproject.bean.WdpxBean
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_search2.*
import java.util.*

class Search2Activity : BaseActivity() {
    private var mAdapter: TbzyAdapter? = null
    private var flag = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search2)
        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))
        if (intent.hasExtra("flag")){
            flag = intent.getStringExtra("title")
        }
        initView()
    }

    private fun initView() {
        setData()
    }

    private fun setData() {
        var pxjhBeanList =  ArrayList<WdpxBean>()

        val homeBean1 = WdpxBean("1", "2018年第四季度", "2018年")

        pxjhBeanList.add(homeBean1)



        if (mAdapter == null){
            mAdapter = TbzyAdapter(pxjhBeanList,this@Search2Activity,"1")
            listView.adapter = mAdapter
        }else{
            mAdapter!!.notifyDataSetChanged()
        }

        listView.setOnItemClickListener { _, _, i, _ ->

            if (flag == "tszy"){
                var intent = Intent(this@Search2Activity, TszyDetailActivity::class.java)
                intent.putExtra("id",pxjhBeanList[i-1].id)
                intent.putExtra("title",title)
                startActivity(intent)
            }else{
                var intent = Intent(this@Search2Activity, TbzyDetailActivity::class.java)
                intent.putExtra("id",pxjhBeanList[i-1].id)
                intent.putExtra("title",title)
                startActivity(intent)
            }

        }
    }
}
