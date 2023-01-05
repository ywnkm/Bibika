package com.elouyi.bbk.utils

import org.brotli.dec.BrotliInputStream
import org.koin.core.context.GlobalContext

public inline fun <reified T : Any> getDep(): T = GlobalContext.get().get()

public fun ByteArray.hexToString(len: Int = size): String {
    return buildString {
        append("[")
        for (i in 0 until len) {
            append(String.format("%02x ", this@hexToString[i]))
        }
        append("]")
    }
}

public fun decodeBrotli(data: ByteArray): ByteArray {
    return data.inputStream().use {
        BrotliInputStream(it).use {  bis ->
            bis.readBytes()
        }
    }
}
