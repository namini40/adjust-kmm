package com.adjust

import com.adjust.utils.JSONObjectWrapper

data class AdjustSessionSuccess(
    var adid: String? = null,
    var message: String? = null,
    var timestamp: String? = null,
    var jsonResponse: JSONObjectWrapper? = null,
)
