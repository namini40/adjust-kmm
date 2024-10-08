package com.adjust

import com.adjust.listeners.AdidReadListener
import com.adjust.listeners.AttributionChangedListener
import com.adjust.listeners.AttributionReadListener
import com.adjust.listeners.DeeplinkResolvedListener
import com.adjust.listeners.DeferredDeeplinkResponseListener
import com.adjust.listeners.EventTrackingFailedListener
import com.adjust.listeners.EventTrackingSucceededListener
import com.adjust.listeners.SessionTrackingFailedListener
import com.adjust.listeners.SessionTrackingSucceededListener
import com.adjust.utils.AppContext

expect class AdjustConfig(
    context: AppContext,
    appToken: String,
    environment: String,
    allowSuppressLogLevel: Boolean = false,
) {
    var processName: String?
    var sdkPrefix: String?
    var defaultTracker: String?
    var attributionChangedListener:AttributionChangedListener?
    var eventTrackingSucceededListener: EventTrackingSucceededListener?
    var eventTrackingFailedListener: EventTrackingFailedListener?
    var sessionTrackingSucceededListener: SessionTrackingSucceededListener?
    var sessionTrackingFailedListener: SessionTrackingFailedListener?
    var isSendingInBackgroundEnabled: Boolean
    var externalDeviceId: String?
    var isPreinstallTrackingEnabled: Boolean
    var isCostDataInAttributionEnabled: Boolean
    val urlStrategyDomains: List<String>
    var preinstallFilePath: String?
    var coppaComplianceEnabled: Boolean
    var playStoreKidsComplianceEnabled: Boolean
    var fbAppId: String?
    var eventDeduplicationIdsMaxSize: Int
    val isIdfaReadingEnabled:Boolean
    val isIdfvReadingEnabled:Boolean
    val isDeviceIdsReadingOnceEnabled:Boolean
    val isAdServicesEnabled:Boolean
    val isSkanAttributionEnabled:Boolean
    val isLinkMeEnabled:Boolean
    val useSubdomains:Boolean

    fun setUrlStrategy(domains: List<String>, useSubdomains: Boolean, isDataResidency: Boolean)
    fun isValid(): Boolean
    fun enableCoppaCompliance()
    fun enablePlayStoreKidsCompliance()
    fun setOnDeferredDeeplinkResponseListener(deferredDeeplinkResponseListener: DeferredDeeplinkResponseListener)
    fun setLogLevel(logLevel: LogLevel)
    fun enableLinkMe()
    fun enableDeviceIdsReadingOnce()
}

