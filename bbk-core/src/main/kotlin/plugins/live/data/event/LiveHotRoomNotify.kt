package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveHotRoomNotify(
    override val cmd: String = "HOT_ROOM_NOTIFY",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val threshold: Int,
        val ttl: Int,
        val exit_no_refresh: Int,
        val random_delay_req_v2: List<RandomDelayReqV2>
    )

    @Serializable
    public data class RandomDelayReqV2(
        val path: String,
        val delay: Int
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveHotRoomNotify> {
        override val cmd: String = "HOT_ROOM_NOTIFY"
        override val kClass: KClass<LiveHotRoomNotify> = LiveHotRoomNotify::class
    }
}
