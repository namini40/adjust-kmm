package com.adjust

import kotlinx.cinterop.ExperimentalForeignApi
import com.adjust.utils.AppContext
import cocoapods.Adjust.ADJConfig
import com.adjust.listeners.AttributionChangedListener
import com.adjust.listeners.DeferredDeeplinkResponseListener
import com.adjust.listeners.EventTrackingFailedListener
import com.adjust.listeners.EventTrackingSucceededListener
import com.adjust.listeners.SessionTrackingFailedListener
import com.adjust.listeners.SessionTrackingSucceededListener

@OptIn(ExperimentalForeignApi::class)
actual class AdjustConfig actual constructor(
    val context: AppContext,
    val appToken: String,
    val environment: String,
    val allowSuppressLogLevel: Boolean,
) {
    internal val adjustConfig = ADJConfig(appToken, environment, allowSuppressLogLevel)

    actual var sdkPrefix: String?
        get() = adjustConfig.sdkPrefix()
        set(value) {
            adjustConfig.setSdkPrefix(value)
        }
    actual var defaultTracker: String?
        get() = adjustConfig.defaultTracker()
        set(value) {
            adjustConfig.setDefaultTracker(value)
        }
    actual var isSendingInBackgroundEnabled: Boolean
        get() = adjustConfig.isSendingInBackgroundEnabled()
        set(value) {
            if (value) adjustConfig.enableSendingInBackground()
        }
    actual var externalDeviceId: String?
        get() = adjustConfig.externalDeviceId()
        set(value) {
            adjustConfig.setExternalDeviceId(value)
        }
    actual var isCostDataInAttributionEnabled: Boolean
        get() = adjustConfig.isCostDataInAttributionEnabled()
        set(value) {
            if (value) adjustConfig.enableCostDataInAttribution()
        }
    actual val urlStrategyDomains: List<String>
        get() = adjustConfig.urlStrategyDomains().toStringList()
    actual var coppaComplianceEnabled: Boolean
        get() = adjustConfig.isCoppaComplianceEnabled()
        set(value) {
            if (value) adjustConfig.enableCoppaCompliance()
        }
    actual var playStoreKidsComplianceEnabled: Boolean = false
    actual var eventDeduplicationIdsMaxSize: Int
        get() = adjustConfig.eventDeduplicationIdsMaxSize().toInt()
        set(value) {
            adjustConfig.setEventDeduplicationIdsMaxSize(value.toLong())
        }

    actual fun setUrlStrategy(
        domains: List<String>,
        useSubdomains: Boolean,
        isDataResidency: Boolean,
    ) {
        adjustConfig.setUrlStrategy(domains, useSubdomains, isDataResidency)
    }

    actual fun enableCoppaCompliance() {
        adjustConfig.enableCoppaCompliance()
    }

    actual fun enablePlayStoreKidsCompliance() {
        // do nothing
    }

    actual fun setOnDeferredDeeplinkResponseListener(deferredDeeplinkResponseListener: DeferredDeeplinkResponseListener) {
        // do nothing
    }

    actual fun setLogLevel(logLevel: LogLevel) {
        adjustConfig.setLogLevel(logLevel.toADJLogLevel())
    }

    actual fun isValid(): Boolean {
        return adjustConfig.isValid()
    }

    actual var processName: String? = null
    actual var attributionChangedListener: AttributionChangedListener? = null
    actual var eventTrackingSucceededListener: EventTrackingSucceededListener? = null
    actual var eventTrackingFailedListener: EventTrackingFailedListener? = null
    actual var sessionTrackingSucceededListener: SessionTrackingSucceededListener? = null
    actual var sessionTrackingFailedListener: SessionTrackingFailedListener? = null
    actual var isPreinstallTrackingEnabled: Boolean = false
    actual var preinstallFilePath: String? = null
    actual var fbAppId: String? = null
    actual fun enableLinkMe() {
        adjustConfig.enableLinkMe()
    }
    actual fun enableDeviceIdsReadingOnce() {
        adjustConfig.enableDeviceIdsReadingOnce()
    }
    actual val isIdfaReadingEnabled: Boolean
        get() = adjustConfig.isIdfaReadingEnabled()

    actual val isIdfvReadingEnabled: Boolean
        get() = adjustConfig.isIdfvReadingEnabled()
    actual val isDeviceIdsReadingOnceEnabled: Boolean
        get() = adjustConfig.isDeviceIdsReadingOnceEnabled()
    actual val isAdServicesEnabled: Boolean
        get() = adjustConfig.isAdServicesEnabled()
    actual val isSkanAttributionEnabled: Boolean
        get() = adjustConfig.isSkanAttributionEnabled()
    actual val isLinkMeEnabled: Boolean
        get() = adjustConfig.isLinkMeEnabled()
    actual val useSubdomains: Boolean
        get() = adjustConfig.isLinkMeEnabled()


}