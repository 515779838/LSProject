package com.example.lsproject.activity.ycpx.xxda

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.lsproject.R
import com.example.lsproject.adapter.SelectAdapter
import com.example.lsproject.bean.SelectBean
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_xskq.*
import java.util.ArrayList

class XxdaActivity : BaseActivity(),View.OnClickListener {

    private var selectAdapter: SelectAdapter? = null
    private var list: ArrayList<SelectBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xxda)
        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))
        initView()
    }

    private fun initView() {

        initData()
    }

    /**
     * 数据加载
     */
    private fun initData() {
        //年份
        list = ArrayList()
        var model: SelectBean
        for (i in 1900..2019) {
            model = SelectBean()
            model.name = "" + i
            list!!.add(model)
        }
        list!!.reverse()
    }

    override fun onClick(view: View?) {

        when (view!!.id) {
            ll_select1.id -> {
                selectAdapter = SelectAdapter(this@XxdaActivity, list)
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
                showPopuptWindow(view, findViewById(R.id.view_shadow2), tv_select1)
            }

        }
    }
}
