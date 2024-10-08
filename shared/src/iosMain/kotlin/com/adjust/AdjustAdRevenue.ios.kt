@file:OptIn(ExperimentalForeignApi::class, ExperimentalForeignApi::class)

package com.adjust

import cocoapods.Adjust.ADJAdRevenue
import kotlinx.cinterop.ExperimentalForeignApi

actual class AdjustAdRevenue actual constructor(source: String) {
    internal val adjAdRevenue = ADJAdRevenue(source)
    actual val revenue: Double
        get() = adjAdRevenue.revenue().doubleValue
    actual var adImpressionsCount: Int
        get() = adjAdRevenue.adImpressionsCount().intValue
        set(value) {
            adjAdRevenue.setAdImpressionsCount(value)
        }
    actual var adRevenueNetwork: String
        get() = adjAdRevenue.adRevenueNetwork()
        set(value) {
            adjAdRevenue.setAdRevenueNetwork(value)
        }
    actual var adRevenueUnit: String
        get() = adjAdRevenue.adRevenueUnit()
        set(value) {
            adjAdRevenue.setAdRevenueUnit(value)
        }
    actual var adRevenuePlacement: String
        get() = adjAdRevenue.adRevenuePlacement()
        set(value) {
            adjAdRevenue.setAdRevenuePlacement(value)
        }
    actual val callbackParameters: Map<String, String>
        get() = adjAdRevenue.callbackParameters().toMapofString()
    actual val partnerParameters: Map<String, String>
        get() = adjAdRevenue.partnerParameters().toMapofString()

    @OptIn(ExperimentalForeignApi::class)
    actual fun setRevenue(revenue: Double, currency: String) {
        adjAdRevenue.setRevenue(revenue, currency)
    }

    actual val currency: String
        get() = adjAdRevenue.currency()

    @OptIn(ExperimentalForeignApi::class)
    actual fun addCallbackParameter(key: String, value: String) {
        adjAdRevenue.addCallbackParameter(key, value)
    }

    actual fun addPartnerParameter(key: String, value: String) {
        adjAdRevenue.addPartnerParameter(key, value)
    }

}