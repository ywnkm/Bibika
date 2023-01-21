package com.elouyi.bbk.plugins.live.data.event.internal

import com.elouyi.bbk.plugins.live.data.event.LiveEvent
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

internal class LiveCMDJsonObject(
    val jsonObject: JsonObject
) : LiveEvent.CMDEvent {

    override val cmd: String = jsonObject["cmd"]?.jsonPrimitive!!.content

    override fun toString(): String {
        return "LiveCMDJsonObject($jsonObject)"
    }
}
