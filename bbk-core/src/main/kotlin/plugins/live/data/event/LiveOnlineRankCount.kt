package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveOnlineRankCount(
    override val cmd: String = "ONLINE_RANK_COUNT",
    val data: Data,
) : LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        val count: Int
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveOnlineRankCount> {
        override val kClass: KClass<LiveOnlineRankCount> = LiveOnlineRankCount::class
        override val cmd: String = "ONLINE_RANK_COUNT"
    }
}
