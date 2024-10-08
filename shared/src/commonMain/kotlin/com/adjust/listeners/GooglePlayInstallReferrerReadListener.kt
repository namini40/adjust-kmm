package com.adjust.listeners

import com.adjust.GooglePlayInstallReferrerDetails

interface GooglePlayInstallReferrerReadListener {
    fun onInstallReferrerRead(referrerDetails: GooglePlayInstallReferrerDetails)
    fun onFail(message: String)

}