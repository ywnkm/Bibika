package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveHotRankChanged(
    override val cmd: String = "HOT_RANK_CHANGED",
    val data: Data,
) : LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        @SerialName("area_name")
        val areaName: String,
        val blink_url: String,
        val countdown: Int,
        val icon: String,
        @SerialName("live_link_url")
        val liveLinkUrl: String,
        @SerialName("live_url")
        val liveUrl: String,
        @SerialName("pc_link_url")
        val pcLinkUrl: String,
        val rank: Int,
        @SerialName("rank_desc")
        val rankDesc: String,
        val timestamp: Int,
        val trend: Int,
        @SerialName("web_url")
        val webUrl: String
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveHotRankChanged> {
        override val kClass: KClass<LiveHotRankChanged> = LiveHotRankChanged::class
        override val cmd: String = "HOT_RANK_CHANGED"
    }
}
