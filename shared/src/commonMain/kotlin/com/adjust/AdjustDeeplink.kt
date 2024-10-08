package com.adjust

expect class AdjustDeeplink(uri: String) {
    fun isValid(): Boolean
}