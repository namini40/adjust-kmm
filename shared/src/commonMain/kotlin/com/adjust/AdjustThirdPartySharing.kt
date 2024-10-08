package com.adjust

expect class AdjustThirdPartySharing(isEnabled:Boolean) {
    fun addGranularOptions(partnerName:String, key:String,value: String)
    fun addPartnerSharingSetting(partnerName: String,key: String,value: Boolean)
    fun getEnabled():Boolean
    fun getGranularOptions():Map<String,Map<String,String>>
    fun getPartnerSharingSettings():Map<String,Map<String,Boolean>>
}

