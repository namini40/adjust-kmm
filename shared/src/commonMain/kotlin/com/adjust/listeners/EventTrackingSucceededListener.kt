package com.adjust.listeners

import com.adjust.AdjustEventSuccess

interface EventTrackingSucceededListener {
    fun onEventTrackingSucceeded(eventSuccess: AdjustEventSuccess)
}

