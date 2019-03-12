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
import org.jetbrains.anko.toast

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
        map["username"] = et_username.text.toString().trim()
        map["password"] = et_password.text.toString()
        NetTools.net(map, Urls().loginApp, this) { response ->
            if (response.code == "0") {
                var loginBean = Gson().fromJson(response.data, LoginBean::class.java)
                getData(loginBean)
            }
            toast("" + response.msg)
        }
    }

    private fun getData(loginBean: LoginBean) {
        SPTools.put(this, Constant.USERNAME, et_username.text.toString().trim())
        SPTools.put(this, Constant.PASSWORD, et_password.text.toString().trim())
        SPTools.put(this, Constant.TOKEN, loginBean.token)
        SPTools.put(this, Constant.YHXLH, loginBean.yhxlh)
        SPTools.put(this, Constant.YHTX, loginBean.yhtx)
        SPTools.put(this, Constant.YHMC, loginBean.yhmc)
        SPTools.put(this, Constant.USERTYPE, loginBean.usertype)
        SPTools.put(this, Constant.USERTYPENAME, loginBean.usertypeName)
        SPTools.put(this, Constant.SJHM, loginBean.sjhm)
        SPTools.put(this, Constant.EMAIL, loginBean.email)
        if (loginBean.usertype == "") {
            // 管理员
            startActivity(Intent(this@LoginActivity, Main2Activity::class.java))
        } else {
            // 教师/学生（家长）
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
        finish()
    }
}
