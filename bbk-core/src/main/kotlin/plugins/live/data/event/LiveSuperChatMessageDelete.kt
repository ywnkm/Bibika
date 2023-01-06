package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveSuperChatMessageDelete(
    override val cmd: String = "SUPER_CHAT_MESSAGE_DELETE",
    val data: Data,
    val roomid: Long,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val ids: List<Long>
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveSuperChatMessageDelete> {
        override val cmd: String = "SUPER_CHAT_MESSAGE_DELETE"
        override val kClass: KClass<LiveSuperChatMessageDelete> = LiveSuperChatMessageDelete::class
    }
}
