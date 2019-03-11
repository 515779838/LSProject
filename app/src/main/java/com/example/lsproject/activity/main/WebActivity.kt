package com.example.lsproject.activity.main

import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView

import com.example.lsproject.R
import com.hhkj.highschool.base.BaseActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : BaseActivity() {

    private var title = ""
    private var url = ""//测试视频地址

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        initView()
    }

    private fun initView() {
        setLeftBtn(true)
        (findViewById<TextView>(R.id.tv_toolsbar_left) as TextView).text = "返回"+getString(R.string.app_name)
        if (intent.hasExtra("title")) {
            title = intent.getStringExtra("title")
        }
        setTextTitle(title)
        webView.settings.defaultTextEncodingName = "utf-8"//这句话去掉也没事。。只是设置了编码格式
        webView.settings.javaScriptEnabled = true  //这句话必须保留。。不解释
        webView.settings.domStorageEnabled = true//这句话必须保留。。否则无法播放优酷视频网页。。其他的可以
        webView.settings.databaseEnabled = true
        webView.settings.allowFileAccess = true
        webView.settings.setAppCacheEnabled(true)
        webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        // webView.settings.userAgentString = MyApp.getUserAgent()
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view!!.loadUrl(request!!.url.toString())
                } else {
                    view!!.loadUrl(request.toString())
                }
                return true
            }

        }
        if (intent.hasExtra("url")) {
            url = intent.getStringExtra("url")
        }
        webView.loadUrl(url)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()// 返回前一个页面
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
