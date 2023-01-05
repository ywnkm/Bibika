package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveAnchorLotEnd(
    override val cmd: String = "ANCHOR_LOT_END",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val id: Int
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveAnchorLotEnd> {
        override val cmd: String = "ANCHOR_LOT_END"
        override val kClass: KClass<LiveAnchorLotEnd> = LiveAnchorLotEnd::class
    }
}
