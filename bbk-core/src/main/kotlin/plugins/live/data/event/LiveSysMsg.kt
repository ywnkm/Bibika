package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveSysMsg(
    override val cmd: String = "SYS_MSG",
    val msg: String,
    val url: String,
) : LiveEvent.CMDEvent {

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveSysMsg> {
        override val cmd: String = "SYS_MSG"
        override val kClass: KClass<LiveSysMsg> = LiveSysMsg::class
    }
}
