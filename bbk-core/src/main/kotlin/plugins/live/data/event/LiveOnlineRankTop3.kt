package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveOnlineRankTop3(
    override val cmd: String = "ONLINE_RANK_TOP3",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("dmscore")
        val dmScore: Int,
        val list: List<ListData>,
    ) {

        @Serializable
        public data class ListData(
            val msg: String,
            val rank: Int,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveOnlineRankTop3> {
        override val kClass: KClass<LiveOnlineRankTop3> = LiveOnlineRankTop3::class
        override val cmd: String = "ONLINE_RANK_TOP3"
    }
}