package com.monstarcompany.monnawa.presentation.webview

data class WebViewUiState(
    val url: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)