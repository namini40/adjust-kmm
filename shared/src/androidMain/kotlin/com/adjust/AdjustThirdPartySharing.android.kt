package com.adjust

import com.adjust.sdk.AdjustThirdPartySharing as AdjustThirdPartySharingAndroid

actual class AdjustThirdPartySharing actual constructor(val isEnabled: Boolean) :
    AdjustThirdPartySharingAndroid(isEnabled) {

    actual fun addGranularOptions(
        partnerName: String,
        key: String,
        value: String,
    ) = super.addGranularOption(partnerName, key, value)

    actual override fun addPartnerSharingSetting(
        partnerName: String,
        key: String,
        value: Boolean,
    ) = super.addPartnerSharingSetting(partnerName, key, value)

    actual override fun getEnabled(): Boolean = super.getEnabled()

    actual override fun getGranularOptions(): Map<String, Map<String, String>> =
        super.getGranularOptions()

    actual override fun getPartnerSharingSettings(): Map<String, Map<String, Boolean>> =
        super.getPartnerSharingSettings()


}