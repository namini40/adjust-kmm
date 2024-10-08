package com.adjust

import cocoapods.Adjust.ADJDeeplink
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSURL

@OptIn(ExperimentalForeignApi::class)
actual class AdjustDeeplink actual constructor(uri: String): ADJDeeplink(NSURL(uri)) {
    actual fun isValid(): Boolean {
        TODO("Not yet implemented")
    }
}