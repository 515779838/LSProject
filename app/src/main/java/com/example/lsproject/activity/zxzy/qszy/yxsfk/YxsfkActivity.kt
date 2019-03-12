package com.example.lsproject.activity.zxzy.qszy.yxsfk

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.lsproject.R
import com.example.lsproject.activity.zxzy.bdzy.SearchActivity
import com.example.lsproject.activity.zxzy.qszy.tszy.TszyDetailActivity
import com.example.lsproject.adapter.SelectAdapter
import com.example.lsproject.adapter.TbzyAdapter
import com.example.lsproject.bean.SelectBean
import com.example.lsproject.bean.WdpxBean
import com.handmark.pulltorefresh.library.PullToRefreshBase
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_yxsfk.*
import java.util.*

/**
 * 优秀示范课
 */
class YxsfkActivity : BaseActivity() , View.OnClickListener{
    private var title = ""
    private var mAdapter: TbzyAdapter? = null

    private var selectAdapter: SelectAdapter? = null
    private var list: ArrayList<SelectBean>? = null
    private var list2: ArrayList<SelectBean>? = null
    private var list3: ArrayList<SelectBean>? = null
    private var list4: ArrayList<SelectBean>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yxsfk)


        title = intent.getStringExtra("title")
        setTextTitle(title)

        setRightBtn(true, "搜索", View.OnClickListener {
            val intent = Intent(this@YxsfkActivity, SearchActivity::class.java)
            intent.putExtra("title",title)
            startActivity(intent)
        })

        initView()
    }

    private fun initView() {
        setData()
    }

    private fun setData() {
        var pxjhBeanList =  ArrayList<WdpxBean>()

        val homeBean1 = WdpxBean("1", "2018年第四季度", "2018年")

        pxjhBeanList.add(homeBean1)


        pullToRefreshListView.mode = PullToRefreshBase.Mode.DISABLED
        if (mAdapter == null){
            mAdapter = TbzyAdapter(pxjhBeanList,this@YxsfkActivity,"1")
            pullToRefreshListView.setAdapter(mAdapter)
        }else{
            mAdapter!!.notifyDataSetChanged()
        }

        pullToRefreshListView.setOnItemClickListener { _, _, i, _ ->

            var intent = Intent(this@YxsfkActivity, TszyDetailActivity::class.java)
            intent.putExtra("id",pxjhBeanList[i-1].id)
            startActivity(intent)
        }
    }


    override fun onClick(view: View) {
        when (view!!.id) {
            ll_select1.id -> {
                selectAdapter = SelectAdapter(this@YxsfkActivity, list)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select1.text = list!![position].name
//                    gradeId = list!![position].id
//                    classId = ""
//                    termId = ""
                    popupWindow!!.dismiss()
//                    getClassTerm()
                }
                showPopuptWindow(view, findViewById(R.id.view_shadow), tv_select1)
            }

            ll_select2.id -> {
                selectAdapter = SelectAdapter(this@YxsfkActivity, list2)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select1.text = list!![position].name
//                    gradeId = list!![position].id
//                    classId = ""
//                    termId = ""
                    popupWindow!!.dismiss()
//                    getClassTerm()
                }
                showPopuptWindow(view, findViewById(R.id.view_shadow), tv_select2)
            }

            ll_select3.id -> {
                selectAdapter = SelectAdapter(this@YxsfkActivity, list3)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select1.text = list!![position].name
//                    gradeId = list!![position].id
//                    classId = ""
//                    termId = ""
                    popupWindow!!.dismiss()
//                    getClassTerm()
                }
                showPopuptWindow(view, findViewById(R.id.view_shadow2), tv_select3)
            }

            ll_select4.id -> {
                selectAdapter = SelectAdapter(this@YxsfkActivity, list4)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select1.text = list!![position].name
//                    gradeId = list!![position].id
//                    classId = ""
//                    termId = ""
                    popupWindow!!.dismiss()
//                    getClassTerm()
                }
                showPopuptWindow(view, findViewById(R.id.view_shadow2), tv_select4)
            }


        }
    }
}
