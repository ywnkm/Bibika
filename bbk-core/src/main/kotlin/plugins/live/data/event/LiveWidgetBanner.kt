package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveWidgetBanner(
    override val cmd: String = "WIDGET_BANNER",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val timestamp: Long,
        @SerialName("widget_list")
        val widgetList: WidgetList,
    ) {

        @Serializable
        public data class WidgetList(
            @SerialName("303")
            @Contextual
            val _303: Nothing? = null
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveWidgetBanner> {
        override val cmd: String = "WIDGET_BANNER"
        override val kClass: KClass<LiveWidgetBanner> = LiveWidgetBanner::class
    }
}
