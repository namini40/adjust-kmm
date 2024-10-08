package com.adjust

import com.adjust.utils.JSONObjectWrapper

data class AdjustEventSuccess(
    var adid: String?=null,
    var message: String?=null,
    var timestamp: String?=null,
    var eventToken: String?=null,
    var callbackId: String?=null,
    var jsonResponse: JSONObjectWrapper?=null,
)