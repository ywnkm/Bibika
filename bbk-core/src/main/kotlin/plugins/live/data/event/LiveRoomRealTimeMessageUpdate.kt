package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveRoomRealTimeMessageUpdate(
    override val cmd: String = "ROOM_REAL_TIME_MESSAGE_UPDATE",
    val data: Data
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("roomid")
        val roomId: Int,
        val fans: Int,
        @SerialName("red_notice")
        val redNotice: Int,
        @SerialName("fans_club")
        val fansClub: Int,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveRoomRealTimeMessageUpdate> {
        override val kClass: KClass<LiveRoomRealTimeMessageUpdate> = LiveRoomRealTimeMessageUpdate::class
        override val cmd: String = "ROOM_REAL_TIME_MESSAGE_UPDATE"
    }
}
