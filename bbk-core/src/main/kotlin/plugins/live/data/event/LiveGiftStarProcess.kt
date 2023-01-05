package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable

@Serializable
public data class LiveGiftStarProcess(
    override val cmd: String = "GIFT_STAR_PROCESS",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val status: Int,
        val tip: String,
    )
}
