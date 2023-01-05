package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveHotRankSettlement(
    override val cmd: String = "HOT_RANK_SETTLEMENT",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("area_name")
        val areaName: String,
        @SerialName("cache_key")
        val cacheKey: String,
        @SerialName("dm_msg")
        val dmMsg: String,
        @SerialName("dmscore")
        val dmScore: Int,
        val face: String,
        val icon: String,
        val rank: Int,
        val timestamp: Int,
        val uname: String,
        val url: String,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveHotRankSettlement> {
        override val kClass: KClass<LiveHotRankSettlement> = LiveHotRankSettlement::class
        override val cmd: String = "HOT_RANK_SETTLEMENT"
    }
}
