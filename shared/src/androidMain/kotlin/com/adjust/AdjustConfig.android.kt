package com.adjust

import com.adjust.listeners.AttributionChangedListener
import com.adjust.listeners.DeferredDeeplinkResponseListener
import com.adjust.listeners.EventTrackingFailedListener
import com.adjust.listeners.EventTrackingSucceededListener
import com.adjust.listeners.SessionTrackingFailedListener
import com.adjust.listeners.SessionTrackingSucceededListener
import com.adjust.utils.AppContext
import com.adjust.sdk.AdjustConfig as AdjustConfigAndroid


actual class AdjustConfig actual constructor(
    val context: AppContext,
    val appToken: String,
    val environment: String,
    allowSuppressLogLevel: Boolean,
) {
    internal val config =
        AdjustConfigAndroid(context.get(), appToken, environment, allowSuppressLogLevel)
    actual var processName: String? = config.processName
    actual var sdkPrefix: String? = config.sdkPrefix
    actual var defaultTracker: String? = config.defaultTracker
    actual var attributionChangedListener: AttributionChangedListener?
        get() = config.onAttributionChangedListener as AttributionChangedListener
        set(value) =
            config.setOnAttributionChangedListener { att ->
                value?.onAttributionChanged(att.toAdjustAttributino())
            }
    actual var eventTrackingSucceededListener: EventTrackingSucceededListener?
        get() = config.onEventTrackingSucceededListener as EventTrackingSucceededListener
        set(value) =
            config.setOnEventTrackingSucceededListener { eventSuccess ->
                value?.onEventTrackingSucceeded(eventSuccess.toAdjustEventSuccess())
            }

    actual var eventTrackingFailedListener: EventTrackingFailedListener?
        get() = config.onEventTrackingFailedListener as EventTrackingFailedListener
        set(value) =
            config.setOnEventTrackingFailedListener { eventFailure ->
                value?.onEventTrackingFailed(eventFailure.toAdjustEventFailure())
            }

    actual var sessionTrackingSucceededListener: SessionTrackingSucceededListener?
        get() = config.onSessionTrackingSucceededListener as SessionTrackingSucceededListener
        set(value) = config.setOnSessionTrackingSucceededListener { sessionSuccess ->
            value?.onSessionTrackingSucceeded(sessionSuccess.toAdjustSessionSuccess())
        }

    actual var sessionTrackingFailedListener: SessionTrackingFailedListener?
        get() = config.onSessionTrackingFailedListener as SessionTrackingFailedListener
        set(value) = config.setOnSessionTrackingFailedListener { sessionFailure ->
            value?.onSessionTrackingFailed(sessionFailure.toAdjustSessionFailure())
        }
    actual var isSendingInBackgroundEnabled: Boolean = config.isSendingInBackgroundEnabled
    actual var externalDeviceId: String? = config.externalDeviceId
    actual var isPreinstallTrackingEnabled: Boolean = config.isPreinstallTrackingEnabled
    actual var isCostDataInAttributionEnabled: Boolean = config.costDataInAttributionEnabled
    actual val urlStrategyDomains: List<String> = config.urlStrategyDomains
    actual var preinstallFilePath: String? = config.preinstallFilePath
    actual var coppaComplianceEnabled: Boolean
        get() = config.isCoppaComplianceEnabled
        set(value) {
            if (value) config.enableCoppaCompliance()
        }
    actual var playStoreKidsComplianceEnabled: Boolean
        get() = config.isPlayStoreKidsComplianceEnabled
        set(value) {
            if (value) config.enablePlayStoreKidsCompliance()
        }
    actual var fbAppId: String? = config.fbAppId
    actual var eventDeduplicationIdsMaxSize: Int = config.eventDeduplicationIdsMaxSize

    actual fun setUrlStrategy(
        domains: List<String>,
        useSubdomains: Boolean,
        isDataResidency: Boolean,
    ) = config.setUrlStrategy(domains, useSubdomains, isDataResidency)

    actual fun isValid(): Boolean = config.isValid

    actual fun enableCoppaCompliance() = config.enableCoppaCompliance()

    actual fun enablePlayStoreKidsCompliance() = config.enablePlayStoreKidsCompliance()
    actual fun setOnDeferredDeeplinkResponseListener(deferredDeeplinkResponseListener: DeferredDeeplinkResponseListener) {
        config.setOnDeferredDeeplinkResponseListener { deeplink ->
            deferredDeeplinkResponseListener.launchReceivedDeeplink(
                deeplink.toString()
            )
        }
    }

    actual fun setLogLevel(logLevel: LogLevel) = config.setLogLevel(logLevel.toAndroidLogLevel())
    actual val isIdfaReadingEnabled: Boolean = false
    actual val isIdfvReadingEnabled: Boolean = false
    actual val isDeviceIdsReadingOnceEnabled: Boolean = false
    actual val isAdServicesEnabled: Boolean = false
    actual val isSkanAttributionEnabled: Boolean=false
    actual val isLinkMeEnabled: Boolean = false
    actual val useSubdomains: Boolean = false

    actual fun enableLinkMe() {
        // do nothing
    }

    actual fun enableDeviceIdsReadingOnce() {
        // do nothgin
    }
}