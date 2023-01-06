package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveAnchorNormalNotify(
    override val cmd: String = "ANCHOR_NORMAL_NOTIFY",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val type: Int,
        val show_type: Int,
        val info: Info,
    ) {

        @Serializable
        public data class Info(
            val icon: String,
            val title: String,
            val content: String,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveAnchorNormalNotify> {
        override val cmd: String = "ANCHOR_NORMAL_NOTIFY"
        override val kClass: KClass<LiveAnchorNormalNotify> = LiveAnchorNormalNotify::class
    }
}
