package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveOnlineRankV2(
    override val cmd: String = "ONLINE_RANK_V2",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val list: List<ListData>,
        @SerialName("rank_type")
        val rankType: String,
    ) {

        @Serializable
        public data class ListData(
            val uid: Long,
            val face: String,
            val score: String,
            val uname: String,
            val rank: Int,
            @SerialName("guard_level")
            val guardLevel: Int,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveOnlineRankV2> {
        override val kClass: KClass<LiveOnlineRankV2> = LiveOnlineRankV2::class
        override val cmd: String = "ONLINE_RANK_V2"
    }
}
