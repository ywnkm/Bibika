package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveEntryEffect(
    override val cmd: String = "ENTRY_EFFECT",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val id: Int,
        val uid: Long,
        @SerialName("target_id")
        val targetId: Long,
        @SerialName("mock_effect")
        val mockEffect: Int,
        val face: String,
        @SerialName("privilege_type")
        val privilegeType: Int,
        @SerialName("copy_writing")
        val copyWriting: String,
        @SerialName("copy_color")
        val copyColor: String,
        @SerialName("highlight_color")
        val highlightColor: String,
        val priority: Int,
        @SerialName("basemap_url")
        val basemapUrl: String,
        @SerialName("show_avatar")
        val showAvatar: Int,
        @SerialName("effective_time")
        val effectiveTime: Int,
        @SerialName("web_basemap_url")
        val webBasemapUrl: String,
        @SerialName("web_effective_time")
        val webEffectiveTime: Int,
        @SerialName("web_effect_close")
        val webEffectClose: Int,
        @SerialName("web_close_time")
        val webCloseTime: Int,
        val business: Int,
        @SerialName("copy_writing_v2")
        val copyWritingV2: String,
        @SerialName("icon_list")
        val iconList: List<Int>,
        @SerialName("max_delay_time")
        val maxDelayTime: Int,
        @SerialName("trigger_time")
        val triggerTime: Long,
        val identities: Int,
        @SerialName("effect_silent_time")
        val effectSilentTime: Double,
        @SerialName("effective_time_new")
        val effectiveTimeNew: Double,
        @SerialName("web_dynamic_url_webp")
        val webDynamicUrlWebp: String,
        @SerialName("web_dynamic_url_apng")
        val webDynamicUrlApng: String,
        @SerialName("mobile_dynamic_url_webp")
        val mobileDynamicUrlWebp: String
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveEntryEffect> {
        override val kClass: KClass<LiveEntryEffect> = LiveEntryEffect::class
        override val cmd: String = "ENTRY_EFFECT"
    }
}
