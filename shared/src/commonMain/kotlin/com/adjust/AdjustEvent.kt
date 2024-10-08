package com.adjust

expect class AdjustEvent(eventToken: String) {
    var orderId: String
    var deduplicationId: String
    var callbackId: String
    var productId: String
    var purchaseToken: String
    fun isValid(): Boolean
    fun getCallbackParameters(): Map<String, String>
    fun getPartnerParameters(): Map<String, String>
    fun setRevenue(revenue: Double, currency: String)
    fun addCallbackParameter(key: String, value: String)
    fun addPartnerParameter(key: String, value: String)
}