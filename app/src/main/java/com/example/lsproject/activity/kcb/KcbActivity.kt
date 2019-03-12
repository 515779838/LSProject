package com.example.lsproject.activity.kcb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import android.widget.AdapterView

import com.example.lsproject.R
import com.example.lsproject.adapter.MySchedulePageAdapter
import com.example.lsproject.adapter.SelectAdapter
import com.example.lsproject.bean.SelectBean
import com.example.lsproject.fragment.MyScheduleFragment
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_kcb.*
import java.util.ArrayList

/**
 * 课程表
 */
class KcbActivity : BaseActivity() , View.OnClickListener {
    private val mTitleList = ArrayList<String>()//页卡标题集合
    private val mViewList = ArrayList<Fragment>()//页卡视图集合
    private var week = 0
    private var mAdapter: MySchedulePageAdapter? = null

    private var selectAdapter: SelectAdapter? = null
    private var list: ArrayList<SelectBean>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kcb)
        initView()
        initData()
    }
    private fun initView() {
        setTextTitle("学生考勤")
        setLeftBtn(true)

        //设置tab模式，当前为系统默认模式
        mTabLayout.tabMode = TabLayout.MODE_FIXED
        //添加页卡标题
        mTitleList.add("周一")
        mTitleList.add("周二")
        mTitleList.add("周三")
        mTitleList.add("周四")
        mTitleList.add("周五")
        mTitleList.add("周六")
        mTitleList.add("周日")
//        //设置tab模式，当前为系统默认模式
//        mTabLayout.setTabMode(TabLayout.MODE_FIXED)
        //添加tab选项卡
        for (i in mTitleList.indices) {
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(i)))
        }
    }

    private fun initData() {
        for (i in mTitleList.indices) {
            val myScheduleFragment = MyScheduleFragment()
            myScheduleFragment.initData((i + 1).toString() + "")
            mViewList.add(myScheduleFragment)
        }
        //添加页卡视图
        if (mAdapter == null) {
            mAdapter = MySchedulePageAdapter(supportFragmentManager, mViewList, mTitleList)
            mViewPager.adapter = mAdapter//给ViewPager设置适配器
            // mViewPager.setOffscreenPageLimit(mTitleList.size());//预加载
            mTabLayout.setupWithViewPager(mViewPager)//将TabLayout和ViewPager关联起来。
            mTabLayout.setTabsFromPagerAdapter(mAdapter)//给Tabs设置适配器
        }
        setWeek(week)
    }

    fun setWeek(week: Int) {
        this.week = week
        if (mViewPager != null) {
            if (week == 1) {
                mViewPager.currentItem = 6
            } else {
                mViewPager.currentItem = week - 2
            }
        }
    }

    override fun onClick(view: View?) {

        when (view!!.id) {
            ll_select1.id -> {
                selectAdapter = SelectAdapter(this@KcbActivity, list)
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
