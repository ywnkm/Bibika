package com.elouyi.bbk.plugins.live.data.event.internal

import com.elouyi.bbk.plugins.live.data.event.LiveEvent

internal class LiveCMDParseFailed(
    override val cmd: String,
    val content: String,
    val exception: Exception,
) : LiveEvent.CMDEvent {

    override fun toString(): String {
        return "Failed to parse CMD: $cmd\n$content\n${exception.stackTraceToString()}"
    }
}
