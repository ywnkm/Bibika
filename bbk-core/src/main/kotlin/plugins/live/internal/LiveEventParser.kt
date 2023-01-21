package com.elouyi.bbk.plugins.live.internal

import com.elouyi.bbk.plugins.live.data.event.LiveEvent
import com.elouyi.bbk.plugins.live.data.event.LiveHeartbeat
import com.elouyi.bbk.plugins.live.data.LivePackage
import com.elouyi.bbk.plugins.live.data.event.internal.LiveCMDParseFailed
import com.elouyi.bbk.utils.decodeBrotli
import com.elouyi.bbk.utils.hexToString
import io.ktor.utils.io.core.*
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializer

internal object LiveEventParser {

    fun parseEvent(data: ByteReadPacket): List<LiveEvent> {
        val result = mutableListOf<LiveEvent>()
        val head = data.readHead()
        val bodyLen = (head.len - head.headLen).toInt()
        when (head.protoVer.toInt())  {
            0, 1 -> result.add(parseEvent2(head, data))

            2 -> {
                println("Zlib packet not supported yet.\n${data.readBytes(bodyLen).hexToString()}")
            }
            3 -> {
                val body = data.readBytes(bodyLen)
                try {
                    if (head.opcode != 8u) {
                        val bodyEncoded = decodeBrotli(body)
                        result.addAll(parseEvent(ByteReadPacket(bodyEncoded)))
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(head)
                    println("Error data: \n${body.hexToString()}")
                }
            }
            else -> println("Else??? ${head.protoVer}\n${data.readBytes(bodyLen).hexToString()}")
        }
        if (data.remaining > 0x10) {
            return result + parseEvent(data)
        }
        return result
    }

    private fun parseEvent2(head: LivePackage.Head, data: ByteReadPacket): LiveEvent {
        val bodyLen = (head.len - head.headLen).toInt()
        when (head.opcode.toInt()) {
            2 -> {}
            3 -> return parseHeartbeat(data, bodyLen)
            5 -> return parseCMD(data.readBytes(bodyLen))
        }
        return LiveEvent.Unknown(byteArrayOf())
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    private fun parseHeartbeat(bodyData: ByteReadPacket, bodyLen: Int): LiveHeartbeat {
        val popularity = bodyData.readUInt()
        bodyData.readBytes(bodyLen - 4)
        return LiveHeartbeat(popularity)
    }

    @OptIn(InternalSerializationApi::class)
    private fun parseCMD(body: ByteArray): LiveEvent.CMDEvent {
        val jsonString = String(body)
        return try {
            val jsonObj = Json.decodeFromString<JsonObject>(jsonString)
            val cmd = jsonObj["cmd"]!!.jsonPrimitive.content
            val kClass = LiveEvent.CMDEvent[cmd]
            if (kClass == LiveEvent.CMDEvent.UnknownCMDEvent::class) {
                return LiveEvent.CMDEvent.UnknownCMDEvent(body, jsonString)
            }
            try {
                Json.decodeFromString(kClass.serializer(), jsonString)
            } catch (e: Exception) {
                e.printStackTrace()
                LiveCMDParseFailed(cmd, jsonString, e)
            }
        } catch (e: Exception) {
            println(jsonString)
            e.printStackTrace()
            LiveEvent.CMDEvent.UnknownCMDEvent(body, jsonString)
        }
    }

    @OptIn(ExperimentalUnsignedTypes::class)
    private fun ByteReadPacket.readHead(): LivePackage.Head {
        val len = readUInt()
        val headLen = readUShort()
        val protoVer = readUShort()
        val opcode = readUInt()
        val seq = readUInt()
        return LivePackage.Head(len, headLen, protoVer, opcode, seq)
    }

}
