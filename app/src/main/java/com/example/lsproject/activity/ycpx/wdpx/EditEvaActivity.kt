package com.example.lsproject.activity.ycpx.wdpx

import android.os.Bundle
import android.util.Log
import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_edit_eva.*

class EditEvaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_eva)

        setLeftBtn(true)
        setTextTitle(intent.getStringExtra("title"))

        btn_commit.setOnClickListener {

            Log.e("zj","rating11 = "+ ratingBar1.getRating())
            Log.e("zj","rating2 2= "+ ratingBar2.getRating())
        }

    }
}
