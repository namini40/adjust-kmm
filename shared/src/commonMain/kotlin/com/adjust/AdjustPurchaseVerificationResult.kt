package com.adjust

data class AdjustPurchaseVerificationResult(
    var verificationStatus: String? = null,
    var code: Int? = null,
    var message: String? = null,
)