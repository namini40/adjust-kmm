package com.adjust.listeners

import com.adjust.AdjustSessionSuccess

interface SessionTrackingSucceededListener {
    fun onSessionTrackingSucceeded(succeededListener: AdjustSessionSuccess)
}