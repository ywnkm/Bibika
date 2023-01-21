package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveActivityBannerChangeV2(
    override val cmd: String = "ACTIVITY_BANNER_CHANGE_V2",
    val data: Data
) :LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        val list: List<Item>,
        val timestamp: Long,
    ) {
        @Serializable
        public data class Item(
            val action: String,
            val activity_title: String,
            val cover: String,
            val ext_data: String,
            val id: Int,
            val is_close: Int,
            val jump_url: String,
            val platform_info: List<PlatformInfo>,
            val position: String,
            val type: Int
        ) {
            @Serializable
            public data class PlatformInfo(
                val build: Int,
                val condition: Int,
                val platform: String
            )
        }
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveActivityBannerChangeV2> {
        override val kClass: KClass<LiveActivityBannerChangeV2> = LiveActivityBannerChangeV2::class
        override val cmd: String = "ACTIVITY_BANNER_CHANGE_V2"
    }
}
