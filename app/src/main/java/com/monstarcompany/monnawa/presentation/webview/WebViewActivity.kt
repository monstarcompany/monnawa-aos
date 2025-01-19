package com.monstarcompany.monnawa.presentation.webview

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.monstarcompany.monnawa.core.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme{
                WebViewScreen()
            }
        }
    }

    @Composable
    fun WebViewScreen(viewModel: WebViewViewModel = hiltViewModel()){
        val uiState by viewModel.uiState.collectAsState()

        if (uiState.isLoading){
//            loading 처리
        }else if(uiState.error != null){
//            show error message
        }else {
            AndroidView(factory = {
                WebView(it).apply {
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    webViewClient = CustomWebViewClient()
                    loadUrl(uiState.url)
                }
            })
        }
    }
}