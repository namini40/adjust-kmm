package com.adjust

actual class AdjustPlayStoreSubscription actual constructor(
    price: Long,
    currency: String,
    sku: String,
    orderId: String,
    signature: String,
    purchaseToken: String,
    purchaseTime: Long,
    callbackParameter: Map<String, String>,
    partnerParameter: Map<String, String>,
) {
    actual fun addCallbackParameter(key: String, value: String) {
    }

    actual fun addPartnerParameter(key: String, value: String) {
    }
}