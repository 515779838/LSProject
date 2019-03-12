package com.example.lsproject.activity.ycpx.wdpx

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_edit_eva.*

/**
 * 编辑评价
 *
 * 同步资源
 * 课程评价
 */
class EditEvaActivity : BaseActivity() {
    private var flag = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_eva)

        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))

        if (intent.hasExtra("flag")){
            flag = intent.getStringExtra("flag")
        }

        if (flag == "tbzy") {//同步资源
            ll_2.visibility = View.GONE
            tv_1.text = "打星评价"
        }


        btn_commit.setOnClickListener {

            Log.e("zj", "rating11 = " + ratingBar1.getRating())
            Log.e("zj", "rating2 2= " + ratingBar2.getRating())
        }

    }
}
