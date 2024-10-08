package com.adjust

import com.adjust.utils.JSONObjectWrapper

data class AdjustSessionFailure(
    var adid: String? = null,
    var willRetry: Boolean? = null,
    var message: String? = null,
    var timestamp: String? = null,
    var jsonResponse: JSONObjectWrapper? = null,
)
