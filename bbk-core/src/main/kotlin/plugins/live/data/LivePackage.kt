package com.elouyi.bbk.plugins.live.data

import com.elouyi.bbk.utils.BBKExperimentalAPI
import io.ktor.utils.io.core.*

public abstract class LivePackage {

    public abstract val head: Head

    public abstract val body: ByteArray

    public data class Head(
        val len: UInt,
        val headLen: UShort, // 0x10
        val protoVer: UShort,
        val opcode: UInt,
        val seq: UInt,
    )

    public open fun build(): ByteArray {
        return head.toPacket().readBytes() + body
    }

    @BBKExperimentalAPI
    public open operator fun plus(other: LivePackage): ByteArray {
        return this.build() + other.build()
    }
}

public abstract class OutgoingLivePackage : LivePackage()

public fun LivePackage.Head.toPacket(): ByteReadPacket {
    return buildPacket {
        writeInt(len.toInt())
        writeShort(headLen.toShort())
        writeShort(protoVer.toShort())
        writeInt(opcode.toInt())
        writeInt(seq.toInt())
    }
}
