package com.example.lsproject.activity.yxxx

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView

import com.example.lsproject.R
import com.example.lsproject.activity.ycpx.wdpx.LessionEvaActivity
import com.example.lsproject.adapter.MenuAdapter
import com.example.lsproject.tools.ScreenTools
import com.example.lsproject.view.ListViewPopupWindow
import com.hhkj.highschool.base.BaseActivity

class YxxxDetailActivity : BaseActivity() {

    private var mPopupWindow: ListViewPopupWindow? = null
    private val mMenuItems =ArrayList<String>()
    private var mMenuAdapter: MenuAdapter? = null
    private var iv_right: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yxxx_detail)
        setTextTitle("研修学习")
        setLeftBtn(true)
        initView()
        iv_right = findViewById(R.id.iv_right)

        setRightButton(true, R.mipmap.ic_btn_more, View.OnClickListener {
            mPopupWindow!!.show(iv_right, 0, 0, false)
        })


        initPopWindow()
    }

    private fun initView() {

    }

    private fun initPopWindow() {
        val width = ScreenTools.dip2px(this, 150f)
        var height = 0
        mMenuItems.clear()
        height = ScreenTools.dpToPx(this, 3 * 100f)
        mMenuItems.add("课程描述")
        mMenuItems.add("课程目录")
        mMenuItems.add("课程评价")
        mMenuAdapter = MenuAdapter(mMenuItems, this)
        mPopupWindow = ListViewPopupWindow.newInstance(this,
                R.layout.pop_win_menu, width, height, false,
                mMenuAdapter) { _, _, position, _ ->


                    if (mMenuItems[position] == "课程描述") {
                        val intent = Intent(this, KcmsActivity::class.java)
                        intent.putExtra("title",mMenuItems[position])
                        startActivity(intent)
                    } else if (mMenuItems[position] == "课程目录") {
                        val intent = Intent(this, KcmlActivity::class.java)
                        intent.putExtra("title",mMenuItems[position])
                        startActivity(intent)
                    }else if (mMenuItems[position] == "课程评价") {
                        val intent = Intent(this, LessionEvaActivity::class.java)
                        intent.putExtra("title",mMenuItems[position])
                        startActivity(intent)
                    }

                    mPopupWindow!!.dismiss()
                }
        mMenuAdapter!!.notifyDataSetChanged()
    }
}
