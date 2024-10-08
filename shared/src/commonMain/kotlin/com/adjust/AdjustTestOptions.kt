package com.adjust

data class AdjustTestOptions(
    var baseUrl: String? = null,
    var gdprUrl: String? = null,
    var subscriptionUrl: String? = null,
    var purchaseVerificationUrl: String? = null,
    var basePath: String? = null,
    var gdprPath: String? = null,
    var subscriptionPath: String? = null,
    var purchaseVerificationPath: String? = null,
    var timerIntervalInMilliseconds: Long? = null,
    var timerStartInMilliseconds: Long? = null,
    var sessionIntervalInMilliseconds: Long? = null,
    var subsessionIntervalInMilliseconds: Long? = null,
    var teardown: Boolean? = null,
    var tryInstallReferrer: Boolean? = null,
    var noBackoffWait: Boolean? = null,
    var ignoreSystemLifecycleBootstrap: Boolean? = null,
)