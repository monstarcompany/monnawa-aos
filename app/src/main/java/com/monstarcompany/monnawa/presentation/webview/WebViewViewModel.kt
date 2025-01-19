package com.monstarcompany.monnawa.presentation.webview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.monstarcompany.monnawa.domain.usecase.GetWebViewUrlUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WebViewViewModel @Inject constructor(
    private val getWebViewUrlUseCase: GetWebViewUrlUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(WebViewUiState(isLoading = true))
    val uiState: StateFlow<WebViewUiState> = _uiState

    init {
        loadUrl()
    }

    private fun loadUrl(){
        viewModelScope.launch {
            try {
                val url = getWebViewUrlUseCase()
                _uiState.value = WebViewUiState(url = url, isLoading = false)
            }catch (e: Exception){
                _uiState.value = WebViewUiState(error = e.message, isLoading = false)
            }
        }
    }
}