package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveRingStatusChangeV2(
    override val cmd: String = "RING_STATUS_CHANGE_V2",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val status: Int
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveRingStatusChangeV2> {
        override val cmd: String = "RING_STATUS_CHANGE_V2"
        override val kClass: KClass<LiveRingStatusChangeV2> = LiveRingStatusChangeV2::class
    }
}
