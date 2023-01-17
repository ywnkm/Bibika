package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePlayTag(
    override val cmd: String = "PLAY_TAG",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val tag_id: Int,
        val pic: String,
        val timestamp: Long,
        val type: String
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePlayTag> {
        override val cmd: String = "PLAY_TAG"
        override val kClass: KClass<LivePlayTag> = LivePlayTag::class
    }
}
