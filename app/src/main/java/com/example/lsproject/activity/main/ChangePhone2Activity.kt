package com.example.lsproject.activity.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lsproject.R
import com.example.lsproject.tools.MyCountTimer
import com.example.lsproject.tools.PhoneTools
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_change_phone2.*
import org.jetbrains.anko.toast

import org.jetbrains.anko.toast

class ChangePhone2Activity : BaseActivity(), View.OnClickListener {

    private var timeCount: MyCountTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_phone2)
        initView()
    }

    private fun initView() {
        setLeftBtn(true)
        setTextTitle("修改手机号")
        timeCount = MyCountTimer(btn_sendcode, 0xffffffff.toInt(), 0xffffffff.toInt())//传入了文字颜色值
        btn_sendcode.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            btn_sendcode.id -> {
                if (et_phone.text.toString() == "") {
                    toast("手机号不能为空")
                    return
                }
                if (!PhoneTools.isMobile(et_phone.text.toString())) {
                    toast("无效的手机号")
                    return
                }
                net_common_verCode()
            }
            btn_submit.id -> {
                if (et_phone.text.toString() == "") {
                    toast("手机号不能为空")
                    return
                }
                if (!PhoneTools.isMobile(et_phone.text.toString())) {
                    toast("无效的手机号")
                    return
                }
                if (et_code.text.toString() == "") {
                    toast("验证码不能为空")
                    return
                }
                net_auth_bindPhone()
            }
        }
    }

    private fun net_common_verCode() {
//        val map = hashMapOf<String, String>()
//        map.put("phone", et_phone.text.toString())
//        map.put("type", "4")
//        NetTools.net(map, Urls().common_verCode, this) { response ->
//            timeCount!!.start()
//            toast(response.msg!!)
//        }
    }

    private fun net_auth_bindPhone() {
//        val map = hashMapOf<String, String>()
//        map.put("phone", et_phone.text.toString())
//        map.put("verCode", et_code.text.toString())
//        map.put("oldPhone", intent.getStringExtra("phone"))
//        map.put("oldPhoneVerCode", intent.getStringExtra("verCode"))
//        NetTools.net(map, Urls().auth_bindPhone, this) { response ->
//            toast(response.msg!!)
////            var intent: Intent? = null
////            if (SPTools[this, Constant.USERTYPE, "1"].toString() == "1") {
////                // 教师
////                if (getIntent().getStringExtra("isSelectSch") == "0") {
////                    intent = Intent(this, SelectSchoolActivity::class.java)
////                    intent.putExtra("isFirst", true)
////                } else {
////                    intent = Intent(this, MainActivity::class.java)
////                }
////            } else if (SPTools.get(this, Constant.USERTYPE, "1").toString() == "3") {
////                // 家长
////                if (getIntent().getStringExtra("isSelectStu") == "0") {
////                    intent = Intent(this, SelectChildrenActivity::class.java)
////                    intent.putExtra("isFirst", true)
////                } else {
////                    intent = Intent(this, MainActivity::class.java)
////                }
////            }
////            startActivity(intent)
//            for (i in 0 until MyApp.getActivies().size) {
//                if (MyApp.getActivies()[i].localClassName.contains("ChangePhoneActivity")) {
//                    MyApp.getActivies()[i].finish()
//                }
//            }
//            finish()
//        }
    }

}

