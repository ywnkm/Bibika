package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveCommonNoticeDanmaku(
    override val cmd: String = "COMMON_NOTICE_DANMAKU",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("content_segments")
        val contentSegments: List<ContentSegment>,
        val dmscore: Int,
        val terminals: List<Int>,
    ) {

        @Serializable
        public data class ContentSegment(
            @SerialName("font_color")
            val fontColor: String,
            @SerialName("font_color_dark")
            val fontColorDark: String,
            @SerialName("highlight_font_color")
            val highlightFontColor: String,
            @SerialName("highlight_font_color_dark")
            val highlightFontColorDark: String,
            val text: String,
            val type: Int,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveCommonNoticeDanmaku> {
        override val kClass: KClass<LiveCommonNoticeDanmaku> = LiveCommonNoticeDanmaku::class
        override val cmd: String = "COMMON_NOTICE_DANMAKU"
    }
}
