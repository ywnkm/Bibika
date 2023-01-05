package com.elouyi.bbk.plugins.live.data.internal

import io.ktor.utils.io.core.*
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

internal class SendAuthPackage(
    uid: Long = 0L,
    roomId: Long,
    protoVer: Int = 3,
    platform: String = "web",
    type: Int = 2,
    key: String = "",
) : LivePackage() {

    override val body: ByteArray = buildJsonObject {
        put("uid", uid)
        put("roomid", roomId)
        put("protover", protoVer)
        put("platform", platform)
        put("type", type)
        put("key", key)
    }.toString().toByteArray()

    override val head: Head = Head(
        len = body.size.toUInt() + 0x10u,
        headLen = 0x10u,
        protoVer = protoVer.toUShort(),
        opcode = 7u,
        seq = 1u,
    )
}
