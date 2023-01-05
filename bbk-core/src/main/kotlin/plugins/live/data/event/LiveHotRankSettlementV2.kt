package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveHotRankSettlementV2(
    override val cmd: String = "HOT_RANK_SETTLEMENT_V2",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val rank: Int,
        val uname: String,
        val face: String,
        val timestamp: Int,
        val icon: String,
        @SerialName("area_name")
        val areaName: String,
        val url: String,
        @SerialName("cache_key")
        val cacheKey: String,
        @SerialName("dm_msg")
        val dmMsg: String,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveHotRankSettlementV2> {
        override val kClass: KClass<LiveHotRankSettlementV2> = LiveHotRankSettlementV2::class
        override val cmd: String = "HOT_RANK_SETTLEMENT_V2"
    }
}
