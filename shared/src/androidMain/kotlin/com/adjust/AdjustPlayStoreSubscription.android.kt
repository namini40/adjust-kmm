package com.adjust
import com.adjust.sdk.AdjustPlayStoreSubscription as AdjustPlayStoreSubscriptionAndroid
actual class AdjustPlayStoreSubscription actual constructor(
    val price: Long,
    val currency: String,
    val sku: String,
    val orderId: String,
    val signature: String,
    val purchaseToken: String,
    val purchaseTime: Long,
    val callbackParameter: Map<String, String>,
    val partnerParameter: Map<String, String>,
): AdjustPlayStoreSubscriptionAndroid(price,currency,sku,signature,orderId,purchaseToken) {

    actual override fun addCallbackParameter(key: String, value: String) = super.addCallbackParameter(key,value)

    actual override fun addPartnerParameter(key: String, value: String) = super.addPartnerParameter(key,value)
}