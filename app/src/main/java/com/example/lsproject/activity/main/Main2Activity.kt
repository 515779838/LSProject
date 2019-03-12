package com.example.lsproject.activity.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import com.example.lsproject.R
import com.example.lsproject.activity.dsjfx.DsjfxActivity
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()
        net_getData()
    }

    private fun initView() {
        setTextTitle(getString(R.string.app_name))
        setRightButton(true, R.mipmap.ic_launcher_round, View.OnClickListener { Log.e("zj", "setRightButton") })

        setLeftButton(true, R.mipmap.ic_launcher_round, View.OnClickListener { Log.e("zj", "setLeftButton") })
        ll_1.setOnClickListener {
            if (ll_main1.visibility == View.VISIBLE) {
                ll_main1.visibility = View.GONE
                iv_1.setImageResource(R.mipmap.ic_r_arr)
            } else {
                ll_main1.visibility = View.VISIBLE
                iv_1.setImageResource(R.mipmap.ic_d_arr)
            }
        }
        ll_2.setOnClickListener {
            if (ll_main2.visibility == View.VISIBLE) {
                ll_main2.visibility = View.GONE
                iv_2.setImageResource(R.mipmap.ic_r_arr)
            } else {
                ll_main2.visibility = View.VISIBLE
                iv_2.setImageResource(R.mipmap.ic_d_arr)
            }
        }
        ll_3.setOnClickListener {
            if (ll_main3.visibility == View.VISIBLE) {
                ll_main3.visibility = View.GONE
                iv_3.setImageResource(R.mipmap.ic_r_arr)
            } else {
                ll_main3.visibility = View.VISIBLE
                iv_3.setImageResource(R.mipmap.ic_d_arr)
            }
        }
        ll_s11.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "1")
            intent.putExtra("type2", "1")
            startActivity(intent)
        }
        ll_s12.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "1")
            intent.putExtra("type2", "2")
            startActivity(intent)
        }
        ll_s13.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "1")
            intent.putExtra("type2", "3")
            startActivity(intent)
        }
        ll_s21.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "2")
            intent.putExtra("type2", "1")
            startActivity(intent)
        }
        ll_s22.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "2")
            intent.putExtra("type2", "2")
            startActivity(intent)
        }
        ll_s23.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "2")
            intent.putExtra("type2", "3")
            startActivity(intent)
        }
        ll_s31.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "3")
            intent.putExtra("type2", "1")
            startActivity(intent)
        }
        ll_s32.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "3")
            intent.putExtra("type2", "2")
            startActivity(intent)
        }
        ll_s33.setOnClickListener {
            val intent = Intent(this, DsjfxActivity::class.java)
            intent.putExtra("type1", "3")
            intent.putExtra("type2", "3")
            startActivity(intent)
        }
    }

    private fun net_getData() {

    }

}
