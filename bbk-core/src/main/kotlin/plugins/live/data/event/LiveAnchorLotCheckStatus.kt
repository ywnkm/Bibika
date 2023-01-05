package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveAnchorLotCheckStatus(
    override val cmd: String = "ANCHOR_LOT_CHECKSTATUS",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val id: Int,
        val status: Int,
        val uid: Long
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveAnchorLotCheckStatus> {
        override val cmd: String = "ANCHOR_LOT_CHECKSTATUS"
        override val kClass: KClass<LiveAnchorLotCheckStatus> = LiveAnchorLotCheckStatus::class
    }
}
