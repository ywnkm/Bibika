package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveMultiVoiceOperatin(
    override val cmd: String = "MULTI_VOICE_OPERATIN",
    val data: Data,
) : LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        val uid: Long,
        val total_price: Int,
        val ts: Long,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveMultiVoiceOperatin> {
        override val kClass: KClass<LiveMultiVoiceOperatin> = LiveMultiVoiceOperatin::class
        override val cmd: String = "MULTI_VOICE_OPERATIN"
    }
}
