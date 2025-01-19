package com.monstarcompany.monnawa.domain.usecase

import com.monstarcompany.monnawa.BuildConfig
import javax.inject.Inject

class GetWebViewUrlUseCase @Inject constructor(){
    operator fun invoke():String {
        return BuildConfig.WEBVIEW_URL
    }
}