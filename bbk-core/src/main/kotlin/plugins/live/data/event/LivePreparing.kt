package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePreparing(
    override val cmd: String = "PREPARING",
    val roomid: String,
    val round: Int?
) :LiveEvent.CMDEvent {

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePreparing> {
        override val cmd: String = "PREPARING"
        override val kClass: KClass<LivePreparing> = LivePreparing::class
    }
}
