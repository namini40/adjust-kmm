package com.adjust

data class GooglePlayInstallReferrerDetails(
    var installReferrer: String? = null,
    var referrerClickTimestampSeconds: Long? = null,
    var installBeginTimestampSeconds: Long? = null,
    var referrerClickTimestampServerSeconds: Long? = null,
    var installBeginTimestampServerSeconds: Long? = null,
    var installVersion: String? = null,
    var googlePlayInstant: Boolean? = null,
)
