package com.adjust.listeners

import com.adjust.AdjustAttribution

interface AttributionChangedListener{
    fun onAttributionChanged(attribution: AdjustAttribution)
}