package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePopularRankChanged(
    override val cmd: String = "POPULAR_RANK_CHANGED",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val uid: Int,
        val rank: Int,
        val countdown: Int,
        val timestamp: Long,
        @SerialName("cache_key")
        val cacheKey: String,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePopularRankChanged> {
        override val kClass: KClass<LivePopularRankChanged> = LivePopularRankChanged::class
        override val cmd: String = "POPULAR_RANK_CHANGED"
    }
}
