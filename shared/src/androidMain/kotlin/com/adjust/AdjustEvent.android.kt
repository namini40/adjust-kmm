package com.adjust

import com.adjust.sdk.AdjustEvent as AdjustEventAndroid

actual class AdjustEvent actual constructor(eventToken: String) : AdjustEventAndroid(eventToken) {
    actual var orderId: String
        get() = getOrderId()
        set(value) = setOrderId(value)
    actual var deduplicationId: String
        get() = getDeduplicationId()
        set(value) = setDeduplicationId(value)

    actual var callbackId: String
        get() = getCallbackId()
        set(value) = setCallbackId(value)
    actual var productId: String
        get() = getProductId()
        set(value) = setProductId(value)
    actual var purchaseToken: String
        get() = getPurchaseToken()
        set(value) = setProductId(value)

    actual override fun isValid() = super.isValid()

    actual override fun setRevenue(revenue: Double, currency: String) =
        super.setRevenue(revenue, currency)

    actual override fun addCallbackParameter(key: String, value: String) =
        super.addCallbackParameter(key, value)

    actual override fun addPartnerParameter(key: String, value: String) =
        super.addPartnerParameter(key, value)

    actual override fun getCallbackParameters() = super.getCallbackParameters()
    actual override fun getPartnerParameters() = super.getPartnerParameters()

}