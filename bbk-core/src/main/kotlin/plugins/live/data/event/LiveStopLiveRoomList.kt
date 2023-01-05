package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveStopLiveRoomList(
    override val cmd: String = "STOP_LIVE_ROOM_LIST",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("room_id_list")
        val roomIdList: List<Int>
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveStopLiveRoomList> {
        override val kClass: KClass<LiveStopLiveRoomList> = LiveStopLiveRoomList::class
        override val cmd: String = "STOP_LIVE_ROOM_LIST"
    }
}
