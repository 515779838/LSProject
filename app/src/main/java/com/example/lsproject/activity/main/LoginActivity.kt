package com.example.lsproject.activity.main

import android.content.Intent
import android.os.Bundle
import com.cyf.nfcproject.tools.SPTools
import com.example.lsproject.R
import com.example.lsproject.bean.LoginBean
import com.example.lsproject.constant.Constant
import com.example.lsproject.tools.NetTools
import com.example.lsproject.url.Urls
import com.google.gson.Gson
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (SPTools[this, Constant.TOKEN, ""].toString() != "") {
            // 重新登录
//            et_username.setText(SPTools[this, Constant.ZHANGHAO, ""].toString())
//            et_password.setText(SPTools[this, Constant.MIMA, ""].toString())
//            net_login()
            // 直接跳转
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        initView()


    }

    private fun initView() {
        // window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        setTextTitle("登录")

        btn_login.setOnClickListener {

//            if (et_username.text.isEmpty()) {
//                toast("用户名不能为空")
//                return@setOnClickListener
//            }
//            if (et_password.text.isEmpty()) {
//                toast("密码不能为空")
//                return@setOnClickListener
//            }
//            net_login()

            startActivity(Intent(this@LoginActivity, MainActivity::class.java))

        }
    }

    private fun net_login() {
        val map = HashMap<String, String>()
        map["userName"] = et_username.text.toString().trim()
        map["password"] = et_password.text.toString()
        NetTools.net(map, Urls().loginApp, this) { response ->
            var loginBean = Gson().fromJson(response.data, LoginBean::class.java)
            getData(loginBean)
        }
    }

    private fun getData(loginBean: LoginBean) {
        if (loginBean != null) {

//            // 账号密码
//            SPTools.put(this, Constant.ZHANGHAO, et_username.text.toString().trim())
//            SPTools.put(this, Constant.MIMA, et_password.text.toString())
//
//            SPTools.put(this, Constant.TOKEN, "" + loginBean!!.token)
//            SPTools.put(this, Constant.USERNAME, "" + loginBean!!.userName)
//            SPTools.put(this, Constant.USERTYPE, "" + loginBean!!.userType)
//
//            SPTools.put(this, Constant.BUREAUNAME, "" + loginBean!!.bureauName)
//            SPTools.put(this, Constant.BUREAUID, "" + loginBean!!.bureauId)
//
//            SPTools.put(this, Constant.DISTRICTID, "" + loginBean!!.districtId)
//            SPTools.put(this, Constant.DISTRICTNAME, "" + loginBean!!.districtName)
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }
}
