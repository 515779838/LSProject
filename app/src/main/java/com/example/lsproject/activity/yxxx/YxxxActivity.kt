package com.example.lsproject.activity.yxxx

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView

import com.example.lsproject.R
import com.example.lsproject.adapter.SelectAdapter
import com.example.lsproject.bean.SelectBean
import com.example.lsproject.fragment.YxxxFragment
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_yxxx.*

import java.util.ArrayList

/**
 * 研修学习
 */
class YxxxActivity : BaseActivity(), View.OnClickListener {
    private val list = ArrayList<Fragment>()
    private var adapter: ViewPagerAdapter? = null
    private var mTabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    private val arr = arrayOf("全部", "正在进行", "即将开始", "已结束")
    private var title = ""

    private var selectAdapter: SelectAdapter? = null
    private var list1: ArrayList<SelectBean>? = null
    private var list2: ArrayList<SelectBean>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yxxx)

        setLeftBtn(true)
        title = intent.getStringExtra("title")
        setTextTitle(title)
        initView()
    }

    private fun initView() {


        mTabLayout = findViewById<View>(R.id.sliding_tabs) as TabLayout
        mTabLayout!!.tabMode = TabLayout.MODE_SCROLLABLE
        viewPager = findViewById<View>(R.id.viewpager) as ViewPager
        mTabLayout!!.tabMode = TabLayout.MODE_FIXED
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText(arr[0]))
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText(arr[1]))
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText(arr[2]))
        mTabLayout!!.addTab(mTabLayout!!.newTab().setText(arr[3]))
        val y1 = YxxxFragment()
        y1.initData("0", "", "", title)
        val y2 = YxxxFragment()
        y1.initData("1", "", "", title)
        val y3 = YxxxFragment()
        y1.initData("2", "", "", title)
        val y4 = YxxxFragment()
        y1.initData("3", "", "", title)
        list.add(y1)
        list.add(y2)
        list.add(y3)
        list.add(y4)
        adapter = ViewPagerAdapter(this.supportFragmentManager, this, list, arr)
        viewPager!!.adapter = adapter
        mTabLayout!!.setupWithViewPager(viewPager)
        viewPager!!.offscreenPageLimit = 2//预加载


    }

    override fun onClick(view: View) {
        when (view.id) {
            ll_select1.id -> {
                selectAdapter = SelectAdapter(this@YxxxActivity, list1)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select1.text = list1!![position].name
//                    gradeId = list!![position].id
//                    classId = ""
//                    termId = ""
                    popupWindow!!.dismiss()
//                    getClassTerm()
                }
                showPopuptWindow(view, findViewById(R.id.view_shadow), tv_select1)
            }

            ll_select2.id -> {
                selectAdapter = SelectAdapter(this@YxxxActivity, list2)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select1.text = list2!![position].name
//                    gradeId = list!![position].id
//                    classId = ""
//                    termId = ""
                    popupWindow!!.dismiss()
//                    getClassTerm()
                }
                showPopuptWindow(view, findViewById(R.id.view_shadow), tv_select2)
            }
        }
    }

    inner class ViewPagerAdapter(fm: FragmentManager, context: Context, private val fragmentList: List<Fragment>, private val tabTitles: Array<String>) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return tabTitles[position]
        }
    }
}
