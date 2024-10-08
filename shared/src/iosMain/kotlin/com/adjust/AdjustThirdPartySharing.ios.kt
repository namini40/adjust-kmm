package com.adjust

import cocoapods.Adjust.ADJThirdPartySharing
import kotlinx.cinterop.ExperimentalForeignApi

@OptIn(ExperimentalForeignApi::class)
actual class AdjustThirdPartySharing actual constructor(isEnabled: Boolean) {
    internal val adjThirdPartySharing = ADJThirdPartySharing()
    actual fun addGranularOptions(partnerName: String, key: String, value: String) {
        adjThirdPartySharing.addGranularOption(partnerName, key, value)
    }

    actual fun getEnabled(): Boolean {
        return adjThirdPartySharing.enabled()?.boolValue ?: false
    }

    actual fun getGranularOptions(): Map<String, Map<String, String>> {
        return adjThirdPartySharing.granularOptions().toNestedMapOfStrings()
    }

    actual fun getPartnerSharingSettings(): Map<String, Map<String, Boolean>> {
        return adjThirdPartySharing.partnerSharingSettings().toNestedMapOfStringBoolean()
    }

    actual fun addPartnerSharingSetting(partnerName: String, key: String, value: Boolean) {
        adjThirdPartySharing.addPartnerSharingSetting(partnerName, key, value)
    }

}