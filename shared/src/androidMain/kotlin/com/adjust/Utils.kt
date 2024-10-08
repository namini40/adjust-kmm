package com.adjust

import android.net.Uri
import com.adjust.utils.JSONObjectWrapperAndroid
import com.adjust.sdk.AdjustAttribution as AdjustAttributionAndroid
import com.adjust.sdk.AdjustDeeplink as AdjustDeeplinkAndroid
import com.adjust.sdk.AdjustTestOptions as AdjustTestOptionsAndroid
import com.adjust.sdk.LogLevel as LogLevelAndroid
import com.adjust.sdk.AdjustSessionSuccess as AdjustSessionSuccessAndroid
import com.adjust.sdk.AdjustSessionFailure as AdjustSessionFailureAndroid
import com.adjust.sdk.AdjustEventFailure as AdjustEventFailureAndroid
import com.adjust.sdk.AdjustEventSuccess as AdjustEventSuccessAndroid
import com.adjust.sdk.GooglePlayInstallReferrerDetails as GooglePlayInstallReferrerDetailsAndroid
import com.adjust.sdk.AdjustPlayStorePurchase as AdjustPlayStorePurchaseAndroid
import com.adjust.sdk.AdjustPurchaseVerificationResult as AdjustPurchaseVerificationResultAndroid

fun AdjustDeeplink.toAdjustDeeplinkAndroid() = AdjustDeeplinkAndroid(this.url)

fun AdjustTestOptions.toAdjustTestOptionsAndroid(): AdjustTestOptionsAndroid {
    val testOptionsAndroid = AdjustTestOptionsAndroid()
    testOptionsAndroid.baseUrl = this.baseUrl
    testOptionsAndroid.gdprUrl = this.gdprUrl
    testOptionsAndroid.subscriptionUrl = this.subscriptionUrl
    testOptionsAndroid.purchaseVerificationUrl = this.purchaseVerificationUrl
    testOptionsAndroid.basePath = this.basePath
    testOptionsAndroid.gdprPath = this.gdprPath
    testOptionsAndroid.subscriptionPath = this.subscriptionPath
    testOptionsAndroid.purchaseVerificationPath = this.purchaseVerificationPath
    testOptionsAndroid.timerIntervalInMilliseconds = this.timerIntervalInMilliseconds
    testOptionsAndroid.timerStartInMilliseconds = this.timerStartInMilliseconds
    testOptionsAndroid.sessionIntervalInMilliseconds = this.subsessionIntervalInMilliseconds
    testOptionsAndroid.subsessionIntervalInMilliseconds = this.subsessionIntervalInMilliseconds
    testOptionsAndroid.teardown = this.teardownval
    testOptionsAndroid.tryInstallReferrer = this.tryInstallReferrer
    testOptionsAndroid.noBackoffWait = this.noBackoffWait
    testOptionsAndroid.ignoreSystemLifecycleBootstrap = this.ignoreSystemLifecycleBootstrap
    return testOptionsAndroid

}

fun LogLevel.toAndroidLogLevel(): LogLevelAndroid = when (this) {
    LogLevel.VERBOSE -> LogLevelAndroid.VERBOSE
    LogLevel.DEBUG -> LogLevelAndroid.DEBUG
    LogLevel.INFO -> LogLevelAndroid.INFO
    LogLevel.WARN -> LogLevelAndroid.WARN
    LogLevel.ERROR -> LogLevelAndroid.ERROR
    LogLevel.ASSERT -> LogLevelAndroid.ASSERT
    LogLevel.SUPRESS -> LogLevelAndroid.SUPPRESS
}

fun AdjustAttributionAndroid.toAdjustAttributino(): AdjustAttribution {
    return AdjustAttribution(
        trackerToken = this.trackerToken,
        trackerName = this.trackerName,
        network = this.network,
        campaign = this.campaign,
        adgroup = this.adgroup,
        creative = this.creative,
        clickLabel = this.clickLabel,
        costType = this.costType,
        costAmount = this.costAmount,
        costCurrency = this.costCurrency,
        fbInstallReferrer = this.fbInstallReferrer,
    )
}

fun AdjustSessionFailureAndroid.toAdjustSessionFailure(): AdjustSessionFailure {
    return AdjustSessionFailure(
        adid = this.adid,
        willRetry = this.willRetry,
        message = this.message,
        timestamp = this.timestamp,
        jsonResponse = JSONObjectWrapperAndroid(this.jsonResponse)
    )
}

fun AdjustSessionSuccessAndroid.toAdjustSessionSuccess(): AdjustSessionSuccess {
    return AdjustSessionSuccess(
        adid = this.adid,
        message = this.message,
        timestamp = this.timestamp,
        jsonResponse = JSONObjectWrapperAndroid(this.jsonResponse)
    )
}

fun AdjustEventFailureAndroid.toAdjustEventFailure(): AdjustEventFailure {
    return AdjustEventFailure(
        adid = this.adid,
        message = this.message,
        willRetry = this.willRetry,
        timestamp = this.timestamp,
        jsonResponse = JSONObjectWrapperAndroid(this.jsonResponse)
    )
}

fun AdjustEventSuccessAndroid.toAdjustEventSuccess(): AdjustEventSuccess {
    return AdjustEventSuccess(
        adid = this.adid,
        message = this.message,
        timestamp = this.timestamp,
        jsonResponse = JSONObjectWrapperAndroid(this.jsonResponse)
    )
}

fun GooglePlayInstallReferrerDetailsAndroid.toGooglePlayInstallReferrerDetails(): GooglePlayInstallReferrerDetails {
    return GooglePlayInstallReferrerDetails(
        installReferrer = this.installReferrer,
        referrerClickTimestampSeconds = this.referrerClickTimestampSeconds,
        installBeginTimestampSeconds = this.installBeginTimestampSeconds,
        referrerClickTimestampServerSeconds = this.referrerClickTimestampServerSeconds,
        installBeginTimestampServerSeconds = this.installBeginTimestampServerSeconds,
        installVersion = this.installVersion,
        googlePlayInstant = this.googlePlayInstant
    )
}

fun AdjustPlayStorePurchase.toAdjustPlayStorePurchaseAndroid(): AdjustPlayStorePurchaseAndroid {
    return AdjustPlayStorePurchaseAndroid(
        this.productId,
        this.purchaseToken
    )
}

fun AdjustPurchaseVerificationResultAndroid.toAdjustPurchaseVerificationResult():AdjustPurchaseVerificationResult{
    return AdjustPurchaseVerificationResult(
        verificationStatus = this.verificationStatus,
        code = this.code,
        message = this.message,
    )
}