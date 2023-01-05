package com.elouyi.bbk.plugins.live.data.internal

import io.ktor.utils.io.core.*

internal abstract class LivePackage {

    abstract val head: Head

    abstract val body: ByteArray

    data class Head(
        val len: UInt,
        val headLen: UShort, // 0x10
        val protoVer: UShort,
        val opcode: UInt,
        val seq: UInt,
    )

    open fun build(): ByteArray {
        return head.toPacket().readBytes() + body
    }
}

internal fun LivePackage.Head.toPacket(): ByteReadPacket {
    return buildPacket {
        writeInt(len.toInt())
        writeShort(headLen.toShort())
        writeShort(protoVer.toShort())
        writeInt(opcode.toInt())
        writeInt(seq.toInt())
    }
}
