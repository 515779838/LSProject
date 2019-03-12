package com.example.lsproject.activity.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.lsproject.R
import com.example.lsproject.tools.MyCountTimer
import com.example.lsproject.tools.NetTools
import com.example.lsproject.tools.PhoneTools
import com.example.lsproject.url.Urls
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_change_phone.*
import org.jetbrains.anko.toast

class ChangePhoneActivity : BaseActivity(), View.OnClickListener {

    private var timeCount: MyCountTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_phone)
        initView()
    }

    private fun initView() {
        setLeftBtn(true)
        setTextTitle("修改手机号")
        timeCount = MyCountTimer(btn_sendcode, 0xffffffff.toInt(), 0xffffffff.toInt())//传入了文字颜色值
        et_phone.setText(intent.getStringExtra("phone"))
        // et_phone.enabled = false
        btn_sendcode.setOnClickListener(this)
        btn_next.setOnClickListener(this)
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
            btn_next.id -> {
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
                net_common_checkUserVerCode()
            }
        }
    }

    private fun net_common_verCode() {
//        val map = hashMapOf<String, String>()
//        map.put("phone", et_phone.text.toString())
//        map.put("type", "3")
//        NetTools.net(map, Urls().common_verCode, this) { response ->
//            timeCount!!.start()
//            toast(response.msg!!)
//        }
    }

    private fun net_common_checkUserVerCode() {

        val intent = Intent(this, ChangePhone2Activity::class.java)
            intent.putExtra("phone", et_phone.text.toString())
            intent.putExtra("verCode", et_code.text.toString())
            startActivity(intent)
//        val map = hashMapOf<String, String>()
//        map.put("phone", et_phone.text.toString())
//        map.put("verCode", et_code.text.toString())
//        NetTools.net(map, Urls().common_checkUserVerCode, this) { response ->
//            // toast(response.msg!!)
//            val intent = Intent(this, ChangePhone2Activity::class.java)
//            intent.putExtra("phone", et_phone.text.toString())
//            intent.putExtra("verCode", et_code.text.toString())
//            startActivity(intent)
//        }
    }
}

