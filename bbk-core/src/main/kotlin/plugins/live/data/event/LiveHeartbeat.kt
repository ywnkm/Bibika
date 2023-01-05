package com.elouyi.bbk.plugins.live.data.event

public class LiveHeartbeat(
    public val popularity: UInt
) : LiveEvent {
    override fun toString(): String {
        return "LiveHeartbeat(popularity=$popularity)"
    }
}
