package com.adjust

class AdjustAppStoreSubscription(
    var price: Long,
    var currency: String,
    var transactionId: String,
    var transactionDate: String? = null,
    var salesRegion: String? = null,
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