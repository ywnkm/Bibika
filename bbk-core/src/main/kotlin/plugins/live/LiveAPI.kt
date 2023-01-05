package com.elouyi.bbk.plugins.live

import com.elouyi.bbk.BibikaAPI
import com.elouyi.bbk.client
import com.elouyi.bbk.plugins.live.data.DanmuInfoData
import com.elouyi.bbk.plugins.live.data.LiveRoomInfo
import com.elouyi.bbk.plugins.live.data.event.LiveEvent
import com.elouyi.bbk.plugins.live.data.internal.SendAuthPackage
import com.elouyi.bbk.plugins.live.internal.LiveEventParser
import io.ktor.client.call.*
import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*
import io.ktor.utils.io.core.*
import io.ktor.websocket.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.KClass

public class LiveAPI(
    private val live: BBKLive
) : BibikaAPI {

    private val logger get() = live.bbk.app.logger

    public suspend fun getRoomInfo(roomId: Int): LiveRoomInfo {
        return live.bbk.client.get("https://api.live.bilibili.com/room/v1/Room/get_info?room_id=$roomId").body()
    }

    public suspend fun danmuInfo(roomId: Int): DanmuInfoData {
        logger.trace { "Get xlive danmu info, room id: $roomId" }
        return live.bbk.client.get("https://api.live.bilibili.com/xlive/web-room/v1/index/getDanmuInfo?id=$roomId") {

        }.body()
    }

    public suspend fun <E : LiveEvent> liveEvent(
        roomId: Long,
        kClass: KClass<E>,
        context: CoroutineContext = EmptyCoroutineContext,
        listener: suspend (E) -> Unit
    ): Job {
        val realRoomId = getRoomInfo(roomId.toInt()).data.roomId
        val danmuInfo = danmuInfo(realRoomId)
        val hostList = danmuInfo.data?.hostList
        if (hostList == null) {
            val errorMsg = "Get live host list failed, room id: $realRoomId"
            logger.error { errorMsg }
            throw Exception(errorMsg)
        }
        logger.info { "Host list: $hostList" }
        val authPackage = SendAuthPackage(
            uid = 0,
            roomId = realRoomId.toLong(),
            key = danmuInfo.data.token
        ).build()

        return live.bbk.app.launch(context) la@ {
            live.bbk.client.wss(
                host = danmuInfo.data.hostList.last().host ,
                port = danmuInfo.data.hostList.last().wssPort,
                path = "/sub"
            ) {
                outgoing.send(Frame.Binary(true, authPackage))
                flush()
                launch {
                    while (isActive) {
                        delay(15_000)
                        logger.trace { "Send live room ($realRoomId) heartbeat." }
                        outgoing.send(Frame.Binary(true, heartbeat))
                    }
                }
                while (isActive) {
                    val res = incoming.receive()
                    launch {
                        val events = LiveEventParser.parseEvent(ByteReadPacket(res.readBytes()))
                        events.forEach {
                            if (it.instanceOf(kClass)) {
                                listener(it as E)
                            }
                        }
                    }
                }
            }
        }
    }

    public suspend inline fun <reified E : LiveEvent> liveEvent(
        roomId: Long,
        context: CoroutineContext = EmptyCoroutineContext,
        noinline listener: suspend (E) -> Unit
    ): Job = liveEvent(roomId, E::class, context, listener)

    public companion object {

        private val heartbeat = byteArrayOf(
            0,0,0,0x1f,
            0,0x10,0,0x1,
            0,0,0,0x2,
            0,0,0,0x1,
            0x5b,0x6f,0x62,0x6a,
            0x65,0x63,0x74,0x20,
            0x4f,0x62,0x6a,0x65,
            0x63,0x74,0x5d
        )
    }
}
