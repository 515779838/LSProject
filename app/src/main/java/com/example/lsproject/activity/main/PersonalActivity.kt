package com.example.lsproject.activity.main

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.lsproject.R
import com.example.lsproject.app.MyApp
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_personal.*

/**
 * 个人中心
 */
class PersonalActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        setLeftBtn(true)
        setTextTitle("个人中心")
    }

    override fun onClick(view: View) {
        when (view.id) {
            ll_head.id -> {
                val intent3 = Intent(this@PersonalActivity, ChangePwdActivity::class.java)
                startActivity(intent3)
            }
            ll_changpw.id -> {
                val intent3 = Intent(this@PersonalActivity, ChangePwdActivity::class.java)
                startActivity(intent3)
            }
            ll_changphone.id -> {
                val intent3 = Intent(this@PersonalActivity, ChangePhoneActivity::class.java)
                startActivity(intent3)
            }
            ll_email.id -> {
                val intent3 = Intent(this@PersonalActivity, ChangePwdActivity::class.java)
                startActivity(intent3)
            }
            ll_update.id -> {

            }
            tv_logout.id -> {
                var builder = AlertDialog.Builder(this@PersonalActivity)

                builder.setTitle("提示")
                builder.setMessage("确定退出当前账号？")

                builder.setPositiveButton("确定") { dialog, which ->
                    //                SPTools.put(this,Constant.SESSIONID,"1111");

                    hideSoftInput()
                    dialog.dismiss()
                    for (i in 0 until MyApp.getActivies().size) {
                        MyApp.getActivies()[i].finish()
                    }
                    startActivity(Intent(this@PersonalActivity,LoginActivity::class.java))

                }
                builder.setNegativeButton("取消") { dialog, which ->
                    dialog.dismiss()
                }
                builder.show()
            }

        }
    }
}
