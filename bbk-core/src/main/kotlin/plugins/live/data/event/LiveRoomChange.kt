package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveRoomChange(
    override val cmd: String = "ROOM_CHANGE",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val title: String,
        val area_id: Int,
        val parent_area_id: Int,
        val area_name: String,
        val parent_area_name: String,
        val live_key: String,
        val sub_session_key: String,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveRoomChange> {
        override val cmd: String = "ROOM_CHANGE"
        override val kClass: KClass<LiveRoomChange> = LiveRoomChange::class
    }
}
