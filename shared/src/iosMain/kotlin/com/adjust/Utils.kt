package com.adjust

import cocoapods.Adjust.*
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSDecimalNumber
import platform.Foundation.NSMutableDictionary
import platform.Foundation.NSNumber

fun Map<Any?, *>.toMapofString(): Map<String, String> {
    return this.mapNotNull { entry ->
        val key = entry.key?.toString() ?: return@mapNotNull null
        val value = entry.value?.toString() ?: return@mapNotNull null
        key to value
    }.toMap()
}

fun NSMutableDictionary.toNestedMapOfStrings(): Map<String, Map<String, String>> {
    val resultMap = mutableMapOf<String, Map<String, String>>()
// todo: needes implementation
    return resultMap
}

fun NSMutableDictionary.toNestedMapOfStringBoolean(): Map<String, Map<String, Boolean>> {
    val resultMap = mutableMapOf<String, Map<String, Boolean>>()
    // todo: needes implementation
    return resultMap
}

fun AdjustTestOptions.toMap(): Map<Any?, *> {
    return mapOf(
        "baseUrl" to baseUrl,
        "gdprUrl" to gdprUrl,
        "subscriptionUrl" to subscriptionUrl,
        "purchaseVerificationUrl" to purchaseVerificationUrl,
        "basePath" to basePath,
        "gdprPath" to gdprPath,
        "subscriptionPath" to subscriptionPath,
        "purchaseVerificationPath" to purchaseVerificationPath,
        "timerIntervalInMilliseconds" to timerIntervalInMilliseconds,
        "timerStartInMilliseconds" to timerStartInMilliseconds,
        "sessionIntervalInMilliseconds" to sessionIntervalInMilliseconds,
        "subsessionIntervalInMilliseconds" to subsessionIntervalInMilliseconds,
        "teardown" to teardown,
        "tryInstallReferrer" to tryInstallReferrer,
        "noBackoffWait" to noBackoffWait,
        "ignoreSystemLifecycleBootstrap" to ignoreSystemLifecycleBootstrap
    )
}

@OptIn(ExperimentalForeignApi::class)
fun AdjustAppStorePurchase.toADJAppStorePurchsae(): ADJAppStorePurchase {
    return ADJAppStorePurchase(transactionId = this.purchaseToken ?: "", productId = this.productId ?: "")
}

@OptIn(ExperimentalForeignApi::class)
fun ADJPurchaseVerificationResult.toAdjustPurchaseVerificationResult(): AdjustPurchaseVerificationResult {
    return AdjustPurchaseVerificationResult(
        this.verificationStatus(),
        this.code(),
        this.message()
    )
}

@OptIn(ExperimentalForeignApi::class)
fun AdjustAttribution.toADJAttribution(): ADJAttribution {
    val attribution = ADJAttribution()
    attribution.setTrackerName(this.trackerName)
    attribution.setTrackerToken(this.trackerToken)
    attribution.setNetwork(this.network)
    attribution.setCampaign(this.campaign)
    attribution.setCreative(this.creative)
    attribution.setAdgroup(this.adgroup)
    attribution.setClickLabel(this.clickLabel)
    this.costAmount?.let { attribution.setCostAmount(NSNumber(it)) }
    attribution.setCostCurrency(this.costCurrency)
    attribution.setCostType(this.costType)

    return attribution
}

@OptIn(ExperimentalForeignApi::class)
fun ADJAttribution.toAdjustAttribution(): AdjustAttribution {
    return AdjustAttribution(
        trackerName = this.trackerName(),
        trackerToken = this.trackerToken(),
        network = this.network(),
        adgroup = this.adgroup(),
        campaign = this.campaign(),
        creative = this.creative(),
        clickLabel = this.clickLabel(),
        costAmount = this.costAmount() as Double?,
        costCurrency = this.costCurrency(),
        costType = this.costType(),
    )
}

fun List<*>?.toStringList(): List<String> {
    return this?.map { it.toString() } ?: emptyList()
}

@OptIn(ExperimentalForeignApi::class)
fun LogLevel.toADJLogLevel(): ADJLogLevel = when (this) {
    LogLevel.ERROR -> ADJLogLevelError
    LogLevel.VERBOSE -> ADJLogLevelVerbose
    LogLevel.DEBUG -> ADJLogLevelDebug
    LogLevel.INFO -> ADJLogLevelInfo
    LogLevel.WARN -> ADJLogLevelWarn
    LogLevel.ASSERT -> ADJLogLevelAssert
    LogLevel.SUPRESS -> ADJLogLevelSuppress
}

@OptIn(ExperimentalForeignApi::class)
fun AdjustAppStoreSubscription.toADJAppStoreSubscription(): ADJAppStoreSubscription {
    val subscription = ADJAppStoreSubscription(
        price = NSDecimalNumber(this.price),
        currency = this.currency,
        transactionId = this.transactionId
    )

    this.transactionDate?.let { stringDate ->
        val dateFormatter = NSDateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd"
        val formatted = dateFormatter.dateFromString(stringDate)
        formatted?.let { date ->
            subscription.setTransactionDate(date)
        }
    }
    this.salesRegion?.let { subscription.setSalesRegion(it) }
    if (this.callbackParameter.isNotEmpty())
        this.callbackParameter.forEach { subscription.addCallbackParameter(it.key, it.value) }
    if (this.partnerParameter.isNotEmpty())
        this.partnerParameter.forEach { subscription.addPartnerParameter(it.key, it.value) }

    return subscription
}