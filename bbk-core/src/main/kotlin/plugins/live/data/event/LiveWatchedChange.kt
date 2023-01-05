package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveWatchedChange(
    val data: Data,
    override val cmd: String = Companion.cmd
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val num: Long,
        @SerialName("text_small")
        val textSmall: String,
        @SerialName("text_large")
        val textLarge: String,
    )


    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveWatchedChange> {
        public override val cmd: String = "WATCHED_CHANGE"
        override val kClass: KClass<LiveWatchedChange> = LiveWatchedChange::class
    }
}