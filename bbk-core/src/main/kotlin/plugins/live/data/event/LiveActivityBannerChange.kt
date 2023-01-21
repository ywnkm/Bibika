package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveActivityBannerChange(
    override val cmd: String = "ACTIVITY_BANNER_CHANGE",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val list: List<Item>
    ) {
        @Serializable
        public data class Item(
            val action: String,
            val activity_title: String,
            val cover: String,
            val id: Int,
            val is_close: Int,
            val jump_url: String,
            val position: String,
            val timestamp: Int
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveActivityBannerChange> {
        override val kClass: KClass<LiveActivityBannerChange> = LiveActivityBannerChange::class
        override val cmd: String = "ACTIVITY_BANNER_CHANGE"
    }
}
