package com.adjust

import android.net.Uri
import com.adjust.sdk.AdjustDeeplink as AdjustDeeplinkAndroid

actual class AdjustDeeplink actual constructor(uri: String) :
    AdjustDeeplinkAndroid(Uri.parse(uri)) {
    actual override fun isValid(): Boolean = super.isValid()
}