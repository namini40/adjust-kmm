package com.adjust

import com.adjust.sdk.AdjustAdRevenue as AdjustAdRevenueAndroid

actual class AdjustAdRevenue actual constructor(source: String) : AdjustAdRevenueAndroid(source) {
    actual val revenue: Double = getRevenue()
    actual val currency: String = getCurrency()
    actual var adImpressionsCount: Int
        get() = getAdImpressionsCount()
        set(value) = setAdImpressionsCount(value)

    actual var adRevenueNetwork: String
        get() = getAdRevenueNetwork()
        set(value) = setAdRevenueNetwork(value)
    actual var adRevenueUnit: String
        get() = getAdRevenueUnit()
        set(value) = setAdRevenueUnit(value)
    actual var adRevenuePlacement: String
        get() = getAdRevenuePlacement()
        set(value) = setAdRevenuePlacement(value)
    actual val callbackParameters: Map<String, String> = getCallbackParameters()
    actual val partnerParameters: Map<String, String> = getPartnerParameters()

    actual override fun setRevenue(revenue: Double, currency: String) =
        super.setRevenue(revenue, currency)

    actual override fun addCallbackParameter(key: String, value: String) =
        super.addCallbackParameter(key, value)

    actual override fun addPartnerParameter(key: String, value: String) =
        super.addPartnerParameter(key, value)
}