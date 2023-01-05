package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveLikeInfoV3Update(
    override val cmd: String = "LIKE_INFO_V3_UPDATE",
    val data: Data
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("click_count")
        val clickCount: Int
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveLikeInfoV3Update> {
        override val kClass: KClass<LiveLikeInfoV3Update> = LiveLikeInfoV3Update::class
        override val cmd: String = "LIKE_INFO_V3_UPDATE"
    }
}