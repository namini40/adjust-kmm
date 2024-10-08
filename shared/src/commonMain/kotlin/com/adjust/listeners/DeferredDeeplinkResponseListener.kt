package com.adjust.listeners

 interface DeferredDeeplinkResponseListener {
    fun launchReceivedDeeplink(uri:String):Boolean
}