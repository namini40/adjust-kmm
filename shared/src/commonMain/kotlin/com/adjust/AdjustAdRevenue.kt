package com.adjust

expect class AdjustAdRevenue(source:String) {
    val revenue:Double
    val currency:String
    var adImpressionsCount:Int
    var adRevenueNetwork:String
    var adRevenueUnit:String
    var adRevenuePlacement:String
    val callbackParameters:Map<String,String>
    val partnerParameters:Map<String,String>

    fun setRevenue(revenue:Double,currency:String)
    fun addCallbackParameter(key:String,value:String)
    fun addPartnerParameter(key:String,value:String)
}