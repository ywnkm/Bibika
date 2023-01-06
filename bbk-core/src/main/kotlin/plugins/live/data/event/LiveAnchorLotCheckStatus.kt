package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Contextual
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
        val uid: Long,
        @Contextual
        val reject_danmu: Nothing? = null,
        val reject_reason: String?,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveAnchorLotCheckStatus> {
        override val cmd: String = "ANCHOR_LOT_CHECKSTATUS"
        override val kClass: KClass<LiveAnchorLotCheckStatus> = LiveAnchorLotCheckStatus::class
    }
}
