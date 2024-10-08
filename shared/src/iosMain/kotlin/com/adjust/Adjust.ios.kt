package com.adjust

import com.adjust.listeners.*
import com.adjust.utils.AppContext
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSURL
import cocoapods.Adjust.Adjust as AdjustIOS

actual object Adjust {
    @OptIn(ExperimentalForeignApi::class)
    actual fun initSdk(config: AdjustConfig) {
        AdjustIOS.initSdk(config.adjustConfig)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun trackEvent(event: AdjustEvent) {
        AdjustIOS.trackEvent(event.event)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun disable() = AdjustIOS.disable()

    @OptIn(ExperimentalForeignApi::class)
    actual fun isEnabled(
        appContext: AppContext,
        isEnabledListener: IsEnabledReadListener,
    ) {
        AdjustIOS.isEnabledWithCompletionHandler { isEnabled ->
            isEnabledListener.onIsEnabledRead(isEnabled)
        }
    }

    actual fun isAdjustUninstallDetectionPayload(payload: Map<String, String>): Boolean {
        return false
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun processDeeplink(
        deeplink: AdjustDeeplink,
        appContext: AppContext,
    ) {
        AdjustIOS.processDeeplink(deeplink)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun processAndResolveDeeplink(
        deeplink: AdjustDeeplink,
        appContext: AppContext,
        deeplinkResolvedListener: DeeplinkResolvedListener,
    ) {
        AdjustIOS.processAndResolveDeeplink(deeplink) { dplnk ->
            dplnk?.let { deeplinkResolvedListener.onDeeplinkResolved(it) }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun switchToOfflineMode() {
        AdjustIOS.switchToOfflineMode()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun switchBackToOnlineMode() {
        AdjustIOS.switchBackToOnlineMode()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun addGlobalCallbackParameter(
        key: String,
        value: String,
    ) {
        AdjustIOS.addGlobalCallbackParameter(key, value)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun addGlobalPartnerParameter(
        key: String,
        value: String,
    ) {
        AdjustIOS.addGlobalPartnerParameter(key, value)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun removeGlobalCallbackParameter(key: String) {
        AdjustIOS.removeGlobalCallbackParameterForKey(key)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun removeGlobalCallbackParameters() {
        AdjustIOS.removeGlobalCallbackParameters()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun removeGlobalPartnerParameter(key: String) {
        AdjustIOS.removeGlobalPartnerParameterForKey(key)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun removeGlobalPartnerParameters() {
        AdjustIOS.removeGlobalPartnerParameters()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun setPushToken(
        pushToken: String,
        appContext: AppContext,
    ) {
        AdjustIOS.setPushToken(NSData)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun gdprForgetMe(appContext: AppContext) {
        AdjustIOS.gdprForgetMe()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun trackThirdPartySharing(thirdPartySharing: AdjustThirdPartySharing) {
        AdjustIOS.trackThirdPartySharing(thirdPartySharing.adjThirdPartySharing)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun trackMeasurementConsent(consentMeasurement: Boolean) {
        AdjustIOS.trackMeasurementConsent(consentMeasurement)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun trackAdRevenue(adjustAdRevenue: AdjustAdRevenue) {
        AdjustIOS.trackAdRevenue(adjustAdRevenue.adjAdRevenue)
    }


    @OptIn(ExperimentalForeignApi::class)
    actual fun getAdId(adIdReadListener: AdidReadListener) {
        AdjustIOS.adidWithCompletionHandler { adid -> adid?.let { adIdReadListener.onAdidRead(it) } }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getAttribution(attributionReadListener: AttributionReadListener) {
        AdjustIOS.attributionWithCompletionHandler { att -> att?.let { attributionReadListener.onAttributionRead(it.toAdjustAttribution()) } }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getLastDeeplink(
        appContext: AppContext,
        lastDeeplinkReadListener: LastDeeplinkReadListener,
    ) {
        AdjustIOS.lastDeeplinkWithCompletionHandler { lastDeeplink ->
            lastDeeplink?.let {
                lastDeeplinkReadListener.onLastDeeplinkRead(
                    it.absoluteString() ?: ""
                )
            }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getSdkVersion(sdkVersionReadListener: SdkVersionReadListener) {
        AdjustIOS.sdkVersionWithCompletionHandler { version ->
            version?.let {
                sdkVersionReadListener.onSdkVersionRead(
                    it
                )
            }
        }
    }

    actual fun verifyPlayStorePurchase(
        purchase: AdjustPlayStorePurchase,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
        // do nothing
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun verifyAndTrackPlayStorePurchase(
        event: AdjustEvent,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun setTestOptions(testOptions: AdjustTestOptions) {
        AdjustIOS.setTestOptions(testOptions.toMap())
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun enable() {
        AdjustIOS.enable()
    }

    actual fun setReferrer(referrer: String, appContext: AppContext) {
        // do nothing
    }

    actual fun trackPlayStoreSubscription(playStoreSubscription: AdjustPlayStoreSubscription) {
        // do nothing
    }

    actual fun getGoogleAdId(
        appContext: AppContext,
        googleAdIdReadListener: GoogleAdIdReadListener,
    ) {
        googleAdIdReadListener.onGoogleAdIdRead(null)
    }

    actual fun getAmazonAdId(
        appContext: AppContext,
        amazonAdIdReadListener: AmazonAdIdReadListener,
    ) {
        amazonAdIdReadListener.onAmazonAdIdRead(null)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getIdfa(idfaReadListener: IdfaReadListener) {
        AdjustIOS.idfaWithCompletionHandler { idfa -> idfa?.let { idfaReadListener.onIdfaReadListener(idfa) } }
    }

    actual fun getGooglePlayInstallReferrer(
        appContext: AppContext,
        googlePlayInstallReferrerReadListener: GooglePlayInstallReferrerReadListener,
    ) {
        googlePlayInstallReferrerReadListener.onFail("No Imeplementation for IOS!")
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun getIdfv(idfvReadListener: IdfvReadListener) {
        AdjustIOS.idfvWithCompletionHandler { idfv -> idfvReadListener.onIdfvReadListener(idfv) }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun verifyAppStorePurchase(
        purchase: AdjustAppStorePurchase,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
        AdjustIOS.verifyAppStorePurchase(purchase.toADJAppStorePurchsae()) { verification ->
            verification?.let { purchaseVerificationFinishedListener.onVerificationFinished(it.toAdjustPurchaseVerificationResult()) }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun verifyAndTrackAppStorePurchase(
        event: AdjustEvent,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    ) {
        AdjustIOS.verifyAndTrackAppStorePurchase(event.event) { verification ->
            verification?.let { purchaseVerificationFinishedListener.onVerificationFinished(it.toAdjustPurchaseVerificationResult()) }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun trackAppStoreSubscription(adjustAppStoreSubscription: AdjustAppStoreSubscription) {
        AdjustIOS.trackAppStoreSubscription(adjustAppStoreSubscription.toADJAppStoreSubscription())
    }

    @OptIn(ExperimentalForeignApi::class)
    actual val appTrackingAuthorizationStatus: Int
        get() = AdjustIOS.appTrackingAuthorizationStatus()

    @OptIn(ExperimentalForeignApi::class)
    actual fun setPushTokenAsString(pushToken: String, appContext: AppContext) {
        AdjustIOS.setPushTokenAsString(pushToken)
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun convertUniversalLink(url: String, scheme: String): String? {
       return AdjustIOS.convertUniversalLink(url, scheme).toString()
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun requestAppTrackingAuthorization(appTrackingAuthorization: AppTrackingAuthorizationFinishedListener) {
        AdjustIOS.requestAppTrackingAuthorizationWithCompletionHandler { result ->
            appTrackingAuthorization.onAppTrackingAuthorizationFinished(result.toInt())
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    actual fun updateSkanConversionValue(conversionValue: Int) {
        AdjustIOS.updateSkanConversionValue(conversionValue.toInt())
    }

}
