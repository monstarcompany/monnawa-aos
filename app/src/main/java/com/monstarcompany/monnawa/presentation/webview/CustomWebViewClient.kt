package com.monstarcompany.monnawa.presentation.webview

import android.webkit.WebView
import android.webkit.WebViewClient

class CustomWebViewClient : WebViewClient() {


    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return if (url != null){
            view?.loadUrl(url)
            true
        }else{
            false
        }
    }
}