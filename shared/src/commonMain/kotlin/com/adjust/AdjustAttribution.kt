package com.adjust

data class AdjustAttribution(
    var trackerToken: String? = null,
    var trackerName: String? = null,
    var network: String? = null,
    var campaign: String? = null,
    var adgroup: String? = null,
    var creative: String? = null,
    var clickLabel: String? = null,
    var costType: String? = null,
    var costAmount: Double? = null,
    var costCurrency: String? = null,
    var fbInstallReferrer: String? = null,
    )