package com.adjust.listeners

import com.adjust.AdjustSessionFailure

interface SessionTrackingFailedListener {
    fun onSessionTrackingFailed(failureResponseData: AdjustSessionFailure)
}