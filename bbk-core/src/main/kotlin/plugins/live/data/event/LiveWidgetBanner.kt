package com.elouyi.bbk.plugins.live.data.event

import com.elouyi.bbk.utils.BBKExperimentalAPI
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveWidgetBanner(
    override val cmd: String = "WIDGET_BANNER",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data constructor(
        val timestamp: Long,
        @SerialName("widget_list")
        @OptIn(BBKExperimentalAPI::class)
        val widgetList: WidgetList,
    ) {

        @Serializable
        @BBKExperimentalAPI
        public class WidgetList(
            // TODO
//            @SerialName("303")
//            @Contextual
//            val _303: Nothing? = null,
//            @SerialName("306")
//            @Contextual
//            val _306: Nothing? = null
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveWidgetBanner> {
        override val cmd: String = "WIDGET_BANNER"
        override val kClass: KClass<LiveWidgetBanner> = LiveWidgetBanner::class
    }
}
