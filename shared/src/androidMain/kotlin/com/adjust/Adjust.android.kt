package com.adjust

import com.adjust.listeners.*
import com.adjust.utils.AppContext
import com.adjust.sdk.OnGooglePlayInstallReferrerReadListener as OnGooglePlayInstallReferrerReadListenerAndroid
import com.adjust.sdk.GooglePlayInstallReferrerDetails as GooglePlayInstallReferrerDetailsAndroid
import com.adjust.sdk.Adjust as AdjustAndroid

actual object Adjust {
    actual fun initSdk(config: AdjustConfig) = AdjustAndroid.initSdk(config.config)

    actual fun trackEvent(event: AdjustEvent) = AdjustAndroid.trackEvent(event)

    fun onResume() = AdjustAndroid.onResume()


    fun onPause() = AdjustAndroid.onPause()

    actual fun enable() = AdjustAndroid.enable()

    actual fun disable() = AdjustAndroid.disable()

    actual fun isEnabled(appContext: AppContext, isEnabledListener: IsEnabledReadListener) {
        AdjustAndroid.isEnabled(
            appContext.get()
        ) { isEnabled -> isEnabledListener.onIsEnabledRead(isEnabled) }
    }

    actual fun isAdjustUninstallDetectionPayload(payload: Map<String, String>): Boolean =
        AdjustAndroid.isAdjustUninstallDetectionPayload(payload)

    actual fun processDeeplink(deeplink: AdjustDeeplink, appContext: AppContext) {
        AdjustAndroid.processDeeplink(deeplink.toAdjustDeeplinkAndroid(), appContext.get())
    }

    actual fun processAndResolveDeeplink(
        deeplink: AdjustDeeplink,
        appContext: AppContext,
        deeplinkResolvedListener: DeeplinkResolvedListener,
    ) {
        AdjustAndroid.processAndResolveDeeplink(
            deeplink,
            appContext.get()
        ) { resolvedDeeplink ->
            resolvedDeeplink?.let {
                deeplinkResolvedListener.onDeeplinkResolved(it)
            }
        }
    }

    actual fun setReferrer(referrer: String, appContext: AppContext) {
        AdjustAndroid.setReferrer(referrer, appContext.get())
    }

    actual fun switchToOfflineMode() {
        AdjustAndroid.switchToOfflineMode()
    }

    actual fun switchBackToOnlineMode() {
        AdjustAndroid.switchBackToOnlineMode()
    }

    actual fun addGlobalCallbackParameter(key: String, value: String) {
        AdjustAndroid.addGlobalCallbackParameter(key, value)
    }

    actual fun addGlobalPartnerParameter(key: String, value: String) {
        AdjustAndroid.addGlobalPartnerParameter(key, value)
    }

    actual fun removeGlobalCallbackParameter(key: String) {
        AdjustAndroid.removeGlobalCallbackParameter(key)
    }

    actual fun removeGlobalCallbackParameters() {
        AdjustAndroid.removeGlobalCallbackParameters()
    }

    actual fun removeGlobalPartnerParameter(key: String) {
        AdjustAndroid.removeGlobalPartnerParameter(key)
    }

    actual fun removeGlobalPartnerParameters() {
        AdjustAndroid.removeGlobalPartnerParameters()
    }

    actual fun setPushToken(pushToken: String, appContext: AppContext) {
        AdjustAndroid.setPushToken(pushToken, appContext.get())
    }

    actual fun gdprForgetMe(appContext: AppContext) {
        AdjustAndroid.gdprForgetMe(appContext.get())
    }

    actual fun trackThirdPartySharing(thirdPartySharing: AdjustThirdPartySharing) {
        AdjustAndroid.trackThirdPartySharing(thirdPartySharing)
    }

    actual fun trackMeasurementConsent(consentMeasurement: Boolean) {
        AdjustAndroid.trackMeasurementConsent(consentMeasurement)
    }

    actual fun trackAdRevenue(adjustAdRevenue: AdjustAdRevenue) {
        AdjustAndroid.trackAdRevenue(adjustAdRevenue)
    }

    actual fun trackPlayStoreSubscription(playStoreSubscription: AdjustPlayStoreSubscription) {
        AdjustAndroid.trackPlayStoreSubscription(playStoreSubscription)
    }

    actual fun getGoogleAdId(
        appContext: AppContext,
        googleAdIdReadListener: GoogleAdIdReadListener,
    ) {
        AdjustAndroid.getGoogleAdId(appContext.get()) { googleAdId ->
            googleAdIdReadListener.onGoogleAdIdRead(
                googleAdId
            )
        }
    }

    actual fun getAmazonAdId(
        appContext: AppContext,
        amazonAdIdReadListener: AmazonAdIdReadListener,
    ) {
        AdjustAndroid.getAmazonAdId(appContext.get()) { amazonAdId ->
            amazonAdIdReadListener.onAmazonAdIdRead(
                amazonAdId
            )
        }
    }

    actual fun getAdId(adIdReadListener: AdidReadListener) {
        AdjustAndroid.getAdid { adid -> adIdReadListener.onAdidRead(adid) }
    }

    actual fun getAttribution(attributionReadListener: AttributionReadListener) {
        AdjustAndroid.getAttribution { attribution -> attributionReadListener.onAttributionRead(attribution.toAdjustAttributino()) }
    }

    actual fun getGooglePlayInstallReferrer(
        appContext: AppContext,
        googlePlayInstallReferrerReadListener: GooglePlayInstallReferrerReadListener,
    ) {
        AdjustAndroid.getGooglePlayInstallReferrer(
            appContext.get(), object : OnGooglePlayInstallReferrerReadListenerAndroid {
                override fun onInstallReferrerRead(p0: GooglePlayInstallReferrerDetailsAndroid?) {
                    p0?.let { googlePlayInstallReferrerReadListener.onInstallReferrerRead(p0.toGooglePlayInstallReferrerDetails()) }
                }

                override fun onFail(p0: String?) {
                    p0?.let { googlePlayInstallReferrerReadListener.onFail(p0) }
                }
            }
        )
    }

    actual fun getLastDeeplink(
        appContext: AppContext,
        lastDeeplinkReadListener: LastDeeplinkReadListener,
    ) {
        AdjustAndroid.getLastDeeplink(appContext.get()) { lastDeeplink ->
            lastDeeplinkReadListener.onLastDeeplinkRead(
                lastDeeplink.toString()
            )
        }
    }

    actual fun getSdkVersion(sdkVersionReadListener: SdkVersionReadListener) {
        AdjustAndroid.getSdkVersion { sdkVersion -> sdkVersionReadListener.onSdkVersionRead(sdkVersion) }
    }

    actual fun verifyPlayStorePurchase(
        purchase: AdjustPlayStorePurchase,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
        AdjustAndroid.verifyPlayStorePurchase(purchase.toAdjustPlayStorePurchaseAndroid()) { playStorePurchase ->
            purchaseVerificationFinishedListener.onVerificationFinished(playStorePurchase.toAdjustPurchaseVerificationResult())
        }
    }

    actual fun verifyAndTrackPlayStorePurchase(
        event: AdjustEvent,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
        AdjustAndroid.verifyAndTrackPlayStorePurchase(event) { playStorePurchase ->
            purchaseVerificationFinishedListener.onVerificationFinished(playStorePurchase.toAdjustPurchaseVerificationResult())
        }
    }

    actual fun setTestOptions(testOptions: AdjustTestOptions) =
        AdjustAndroid.setTestOptions(testOptions.toAdjustTestOptionsAndroid())

    actual fun getIdfa(idfaReadListener: IdfaReadListener) {
        idfaReadListener.onIdfaReadListener(null)
    }

    actual fun getIdfv(idfvReadListener: IdfvReadListener) {
        idfvReadListener.onIdfvReadListener(null)
    }

    actual fun verifyAndTrackAppStorePurchase(
        event: AdjustEvent,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
        // do nothing
    }

    actual fun verifyAppStorePurchase(
        purchase: AdjustAppStorePurchase,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
        // do nothing
    }

    actual val appTrackingAuthorizationStatus: Int
        get() = -1

    actual fun setPushTokenAsString(pushToken: String, appContext: AppContext) {
        AdjustAndroid.setPushToken(pushToken,appContext.get())
    }

    actual fun convertUniversalLink(url: String, scheme: String): String? {
        return null
    }

    actual fun trackAppStoreSubscription(adjustAppStoreSubscription: AdjustAppStoreSubscription) {
        // do nothing
    }

    actual fun requestAppTrackingAuthorization(appTrackingAuthorization: AppTrackingAuthorizationFinishedListener) {
        // do nothing
    }

    actual fun updateSkanConversionValue(conversionValue: Int) {
        // do nothing
    }


}