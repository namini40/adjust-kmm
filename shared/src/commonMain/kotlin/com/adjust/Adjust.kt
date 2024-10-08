package com.adjust

import com.adjust.listeners.*
import com.adjust.utils.AppContext

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object Adjust {

    val appTrackingAuthorizationStatus: Int
    fun initSdk(config: AdjustConfig)
    fun trackEvent(event: AdjustEvent)
    fun enable()
    fun disable()
    fun isEnabled(appContext: AppContext, isEnabledListener: IsEnabledReadListener)
    fun isAdjustUninstallDetectionPayload(payload: Map<String, String>): Boolean
    fun processDeeplink(deeplink: AdjustDeeplink, appContext: AppContext)
    fun processAndResolveDeeplink(
        deeplink: AdjustDeeplink,
        appContext: AppContext,
        deeplinkResolvedListener: DeeplinkResolvedListener,
    )

    fun setReferrer(referrer: String, appContext: AppContext)
    fun switchToOfflineMode()
    fun switchBackToOnlineMode()
    fun addGlobalCallbackParameter(key: String, value: String)
    fun addGlobalPartnerParameter(key: String, value: String)
    fun removeGlobalCallbackParameter(key: String)
    fun removeGlobalPartnerParameter(key: String)
    fun removeGlobalCallbackParameters()
    fun removeGlobalPartnerParameters()
    fun setPushToken(pushToken: String, appContext: AppContext)
    fun setPushTokenAsString(pushToken: String, appContext: AppContext)
    fun gdprForgetMe(appContext: AppContext)
    fun trackThirdPartySharing(thirdPartySharing: AdjustThirdPartySharing)
    fun trackMeasurementConsent(consentMeasurement: Boolean)
    fun trackAdRevenue(adjustAdRevenue: AdjustAdRevenue)
    fun trackPlayStoreSubscription(playStoreSubscription: AdjustPlayStoreSubscription)
    fun getGoogleAdId(appContext: AppContext, googleAdIdReadListener: GoogleAdIdReadListener)
    fun getAmazonAdId(appContext: AppContext, amazonAdIdReadListener: AmazonAdIdReadListener)
    fun getAdId(adIdReadListener: AdidReadListener)
    fun getIdfa(idfaReadListener: IdfaReadListener)
    fun getIdfv(idfvReadListener: IdfvReadListener)
    fun getAttribution(attributionReadListener: AttributionReadListener)
    fun getGooglePlayInstallReferrer(
        appContext: AppContext,
        googlePlayInstallReferrerReadListener: GooglePlayInstallReferrerReadListener,
    )

    fun convertUniversalLink(url: String, scheme: String): String?
    fun getLastDeeplink(appContext: AppContext, lastDeeplinkReadListener: LastDeeplinkReadListener)
    fun getSdkVersion(sdkVersionReadListener: SdkVersionReadListener)
    fun verifyPlayStorePurchase(
        purchase: AdjustPlayStorePurchase,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    )

    fun verifyAppStorePurchase(
        purchase: AdjustAppStorePurchase,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    )

    fun verifyAndTrackPlayStorePurchase(
        event: AdjustEvent,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    )

    fun verifyAndTrackAppStorePurchase(
        event: AdjustEvent,
        purchaseVerificationFinishedListener: PurchaseVerificationFinishedListener,
    )

    fun setTestOptions(testOptions: AdjustTestOptions)

    fun trackAppStoreSubscription(adjustAppStoreSubscription: AdjustAppStoreSubscription)

    fun requestAppTrackingAuthorization(appTrackingAuthorization: AppTrackingAuthorizationFinishedListener)

    fun updateSkanConversionValue(conversionValue:Int)
}