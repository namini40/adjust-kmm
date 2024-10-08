package com.adjust

import cocoapods.Adjust.ADJEvent
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual class AdjustEvent actual constructor(eventToken: String) {

    val event = ADJEvent(eventToken)
    actual var orderId: String
        get() = event.transactionId()
        set(value) {
            event.setTransactionId(value)
        }
    actual var deduplicationId: String
        get() = event.transactionId()
        set(value) {
            event.setTransactionId(value)
        }
    actual var callbackId: String
        get() = event.callbackId()
        set(value) {
            event.setCallbackId(value)
        }
    actual var productId: String
        get() = event.productId()
        set(value) {
            event.setProductId(value)
        }
    actual var purchaseToken: String
        get() = event.callbackId
        set(value) {
            event.setCallbackId(value)
        }

    actual fun isValid(): Boolean {
        return event.isValid()
    }

    actual fun getCallbackParameters(): Map<String, String> {
        return event.callbackParameters() as Map<String, String>
        // todo: check casting
    }

    actual fun getPartnerParameters(): Map<String, String> {
        return event.partnerParameters() as Map<String, String>
        // todo: check casting

    }

    actual fun setRevenue(revenue: Double, currency: String) {
        event.setRevenue(revenue, currency)
    }

    actual fun addCallbackParameter(key: String, value: String) {
        event.addCallbackParameter(key, value)
    }

    actual fun addPartnerParameter(key: String, value: String) {
        event.addPartnerParameter(key, value)
    }

}