package com.adjust

class AdjustPlayStoreSubscription(
    var price: Long,
    var currency: String,
    var sku: String,
    var orderId: String,
    var signature: String,
    var purchaseToken: String,
    var purchaseTime: Long = -1,
    var callbackParameter: MutableMap<String, String> = hashMapOf(),
    var partnerParameter: MutableMap<String, String> = hashMapOf(),
) {
    fun addCallbackParameter(key: String, value: String) {
        callbackParameter[key] = value
    }

    fun addPartnerParameter(key: String, value: String) {
        partnerParameter[key] = value
    }
}