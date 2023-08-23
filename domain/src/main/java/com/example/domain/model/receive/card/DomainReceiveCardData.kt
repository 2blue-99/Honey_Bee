package com.example.domain.model.receive.card

/**
 * 2023-03-30
 * pureum
 */
data class DomainReceiveCardData(
    var uid:Long,
    var cardName:String,
    var cardAmount:String,
    var billCheckDate:String?
)
