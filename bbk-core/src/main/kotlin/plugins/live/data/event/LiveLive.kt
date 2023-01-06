package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveLive(
    override val cmd: String = "LIVE",
    val live_key: String,
    val voice_background: String,
    val sub_session_key: String,
    val live_platform: String,
    val live_model: Int,
    val live_time: Long,
    val roomid: Long
) : LiveEvent.CMDEvent {

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveLive> {
        override val cmd: String = "LIVE"
        override val kClass: KClass<LiveLive> = LiveLive::class
    }
}
