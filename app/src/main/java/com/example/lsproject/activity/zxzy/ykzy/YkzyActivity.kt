package com.example.lsproject.activity.zxzy.ykzy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.AdapterView

import com.example.lsproject.R
import com.example.lsproject.activity.zxzy.bdzy.BdzyActivity
import com.example.lsproject.activity.zxzy.bdzy.SearchActivity
import com.example.lsproject.adapter.SelectAdapter
import com.example.lsproject.bean.SelectBean
import com.example.lsproject.fragment.YkzyFragment
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ykzy.*

import java.util.ArrayList

/**
 * 优课资源
 */
class YkzyActivity : BaseActivity(), View.OnClickListener {

    private var title = ""

    private val list = ArrayList<Fragment>()
    private var adapter: ViewPagerAdapter? = null
    private var mTabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    private val arr = arrayOf("热门资源", "最新资源", "校本资源")

    private var selectAdapter: SelectAdapter? = null
    private var list1: ArrayList<SelectBean>? = null
    private var list2: ArrayList<SelectBean>? = null
    private var list3: ArrayList<SelectBean>? = null
    private var list4: ArrayList<SelectBean>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ykzy)
        setLeftBtn(true)
        title = intent.getStringExtra("title")
        setTextTitle(title)

        setRightBtn(true, "搜索", View.OnClickListener {
            val intent = Intent(this@YkzyActivity, SearchActivity::class.java)
            intent.putExtra("title", title)
            startActivity(intent)
        })

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
        val y1 = YkzyFragment()
        y1.initData("0", "", "", title)
        val y2 = YkzyFragment()
        y2.initData("1", "", "", title)
        val y3 = YkzyFragment()
        y3.initData("2", "", "", title)

        list.add(y1)
        list.add(y2)
        list.add(y3)
        adapter = ViewPagerAdapter(this.supportFragmentManager, this, list, arr)
        viewPager!!.adapter = adapter
        mTabLayout!!.setupWithViewPager(viewPager)
        viewPager!!.offscreenPageLimit = 2//预加载


    }

    override fun onClick(view: View) {
        when (view.id) {
            ll_select1.id -> {
                selectAdapter = SelectAdapter(this@YkzyActivity, list1)
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
                selectAdapter = SelectAdapter(this@YkzyActivity, list2)
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

            ll_select3.id -> {
                selectAdapter = SelectAdapter(this@YkzyActivity, list3)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select3.text = list3!![position].name
//                    gradeId = list!![position].id
//                    classId = ""
//                    termId = ""
                    popupWindow!!.dismiss()
//                    getClassTerm()
                }
                showPopuptWindow(view, findViewById(R.id.view_shadow2), tv_select3)
            }

            ll_select4.id -> {
                selectAdapter = SelectAdapter(this@YkzyActivity, list4)
                gridView!!.adapter = selectAdapter

                gridView!!.numColumns = 1
                gridView!!.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    tv_select4.text = list4!![position].name
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
