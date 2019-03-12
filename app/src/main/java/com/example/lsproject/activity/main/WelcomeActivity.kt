package com.example.lsproject.activity.main

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.lsproject.R
import com.example.lsproject.tools.PermissionUtils

class WelcomeActivity : AppCompatActivity(), PermissionUtils.PermissionCallbacks {

    private val permissions = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private val REQUEST_PERMISSION_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        if (PermissionUtils.hasPermissions(this, *permissions)) {
            next()
        } else {
            PermissionUtils.requestPermissions(this, REQUEST_PERMISSION_CODE, permissions)
        }
    }

    fun next(){
        Handler().postDelayed({
            val intent = Intent(this@WelcomeActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        PermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsAllGranted(requestCode: Int, perms: MutableList<String>?, isAllGranted: Boolean) {
        if (isAllGranted) {
            next()
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>?) {

    }

}
