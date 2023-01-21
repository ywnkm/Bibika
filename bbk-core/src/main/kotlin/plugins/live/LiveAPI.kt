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

    public suspend fun getRoomInfo(roomId: Long): LiveRoomInfo {
        return live.bbk.client.get("https://api.live.bilibili.com/room/v1/Room/get_info?room_id=$roomId").body()
    }

    public suspend fun danmuInfo(roomId: Long): DanmuInfoData {
        logger.trace { "Get xlive danmu info, room id: $roomId" }
        return live.bbk.client.get("https://api.live.bilibili.com/xlive/web-room/v1/index/getDanmuInfo?id=$roomId") {

        }.body()
    }

    public suspend fun <E : LiveEvent> liveEvent(
        roomId: Long,
        kClass: KClass<E>,
        context: CoroutineContext = EmptyCoroutineContext,
        listener: suspend LiveRoom.(E) -> Unit
    ): Job {
        val roomInfo = getRoomInfo(roomId).data
        val realRoomId = roomInfo.roomId
        val danmuInfo = danmuInfo(realRoomId)
        val hostList = danmuInfo.data?.hostList
        if (hostList == null) {
            val errorMsg = "Get live host list failed, room id: $realRoomId"
            logger.error { errorMsg }
            throw Exception(errorMsg)
        }
        logger.info { "Host list: $hostList" }

        return startListen(roomInfo, danmuInfo.data.token, hostList.last(), 0, context) {
            if (it.instanceOf(kClass)) {
                @Suppress("UNCHECKED_CAST")
                listener(this, it as E)
            }
        }
    }

    public suspend inline fun <reified E : LiveEvent> liveEvent(
        roomId: Long,
        context: CoroutineContext = EmptyCoroutineContext,
        noinline listener: suspend LiveRoom.(E) -> Unit
    ): Job = liveEvent(roomId, E::class, context, listener)

    public fun <E : LiveEvent> liveEventAsync(
        roomId: Long,
        kClass: KClass<E>,
        context: CoroutineContext = EmptyCoroutineContext,
        listener: suspend LiveRoom.(E) -> Unit
    ): Job = live.bbk.app.launch { liveEvent(roomId, kClass, context, listener) }

    public inline fun <reified E : LiveEvent> liveEventAsync(
        roomId: Long,
        context: CoroutineContext = EmptyCoroutineContext,
        noinline listener: suspend LiveRoom.(E) -> Unit
    ): Job = liveEventAsync(roomId, E::class, context, listener)

    private fun <T> startListen(
        roomInfo: LiveRoomInfo.Data,
        token: String,
        host: DanmuInfoData.Data.Host,
        uid: Long = 0,
        context: CoroutineContext = EmptyCoroutineContext,
        listener: T,
    ): Job where T : suspend LiveRoom.(LiveEvent) -> Unit {
        val authPackage = SendAuthPackage(
            uid = uid,
            roomId = roomInfo.roomId,
            key = token
        )
        return live.bbk.app.launch(context) {
            live.bbk.client.wss(
                host = host.host,
                port = host.wssPort,
                path = "/sub"
            ) {
                val liveRoom = LiveRoom(roomInfo)
                liveRoom.send(authPackage)
                flush()
                launch {
                    while (isActive) {
                        delay(live.config.liveHeartbeatInterval)
                        logger.trace { "Send live room (${roomInfo.roomId}) heartbeat." }
                        liveRoom.send(heartbeat)
                    }
                }
                while (isActive) {
                    val res = incoming.receive()
                    launch {
                        val events = LiveEventParser.parseEvent(ByteReadPacket(res.readBytes()))
                        events.forEach {
                            listener(liveRoom, it)
                        }
                    }
                }
            }
        }
    }

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
