package com.adjust.listeners

import com.adjust.AdjustEventFailure

interface EventTrackingFailedListener {
    fun onEventTrackingFailed(eventFailure: AdjustEventFailure)
}