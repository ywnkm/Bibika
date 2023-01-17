package com.elouyi.bbk.plugins.live

import com.elouyi.bbk.plugins.live.data.LivePackage
import com.elouyi.bbk.plugins.live.data.LiveRoomInfo
import com.elouyi.bbk.plugins.live.data.OutgoingLivePackage
import io.ktor.client.plugins.websocket.*
import io.ktor.utils.io.*
import io.ktor.websocket.*
import kotlinx.coroutines.Job

context(ws@ DefaultClientWebSocketSession)
public class LiveRoom(
    public val roomInfo: LiveRoomInfo.Data,
) : DefaultWebSocketSession by this@ws {

    public suspend fun send(packet: OutgoingLivePackage) {
        send(packet.build())
    }

    public suspend fun send(byteArray: ByteArray) {
        send(Frame.Binary(true, byteArray))
    }

    public suspend fun cancelSession(cause: Throwable) {
        closeExceptionally(cause)
    }

    public fun closeJob(cause: CancellationException? = null) {
        coroutineContext[Job]?.cancel(cause)
    }
}
