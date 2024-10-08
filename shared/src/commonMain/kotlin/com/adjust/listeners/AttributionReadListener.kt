package com.adjust.listeners

import com.adjust.AdjustAttribution

interface AttributionReadListener {
    fun onAttributionRead(attribution: AdjustAttribution)
}