package com.elouyi.bbk.plugins.live.internal

import com.elouyi.bbk.plugins.live.data.event.LiveDanmu
import com.elouyi.bbk.utils.BBKExperimentalAPI
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.*

@OptIn(BBKExperimentalAPI::class)
internal class DanmuInfo0Serializer(

) : KSerializer<LiveDanmu.Info0> {

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("DanmuInfo0Serializer", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder): LiveDanmu.Info0 {

        val arr = decoder.decodeSerializableValue(JsonArray.serializer())

        return LiveDanmu.Info0(
            arr[0].jsonPrimitive.int,
            arr[1].jsonPrimitive.int,
            arr[2].jsonPrimitive.int,
            arr[3].jsonPrimitive.int,
            arr[4].jsonPrimitive.long,
            arr[5].jsonPrimitive.long,
            arr[6].jsonPrimitive.int,
            arr[7].jsonPrimitive.content,
            arr[8].jsonPrimitive.int,
            arr[9].jsonPrimitive.int,
            arr[10].jsonPrimitive.int,
            arr[11].jsonPrimitive.content,
            arr[12].jsonPrimitive.int,
            try {
                Json.decodeFromJsonElement<LiveDanmu.Info0.Obj0>(arr[13].jsonObject)
            } catch (e: IllegalArgumentException) { null },
            arr[14].jsonPrimitive.content,
            Json.decodeFromJsonElement<LiveDanmu.Info0.Obj1>(arr[15].jsonObject),
            Json.decodeFromJsonElement<LiveDanmu.Info0.Obj2>(arr[16].jsonObject),
        )
    }

    override fun serialize(encoder: Encoder, value: LiveDanmu.Info0) {
        TODO("Not yet implemented")
    }

}