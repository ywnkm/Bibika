package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveTradingScore(
    override val cmd: String = "TRADING_SCORE",
    val data: Data
) : LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        val bubble_show_time: Int,
        val num: Int,
        val score_id: Int,
        val uid: Long,
        val update_time: Long,
        val update_type: Int
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveTradingScore> {
        override val cmd: String = "TRADING_SCORE"
        override val kClass: KClass<LiveTradingScore> = LiveTradingScore::class
    }
}
