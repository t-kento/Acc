package com.example.okhttp3

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.acc.R

class WebActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qiita_article)
        WebView()
    }

    private fun WebView(){
        val url = intent?.getStringExtra("url")
        val webView:WebView=findViewById(R.id.webView)

        println("$url")
        webView.loadUrl("$url")
    }
}