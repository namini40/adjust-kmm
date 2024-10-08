package com.adjust.listeners

import com.adjust.AdjustPurchaseVerificationResult

interface PurchaseVerificationFinishedListener {
    fun onVerificationFinished(result: AdjustPurchaseVerificationResult?)
}