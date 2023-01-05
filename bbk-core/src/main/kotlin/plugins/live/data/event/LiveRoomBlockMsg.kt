package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
}