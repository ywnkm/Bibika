package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveRoomBlockMsg(
    override val cmd: String = "ROOM_BLOCK_MSG",
    val data: Data,
    val uid: String,
    val uname: String,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("dmscore")
        val dmScore: Int,
        val operator: Int,
        val uid: Long,
        val uname: String,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveRoomBlockMsg> {
        override val cmd: String = "ROOM_BLOCK_MSG"
        override val kClass: KClass<LiveRoomBlockMsg> = LiveRoomBlockMsg::class
    }
}
