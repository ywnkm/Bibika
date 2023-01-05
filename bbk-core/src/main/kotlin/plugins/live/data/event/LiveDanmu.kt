package com.elouyi.bbk.plugins.live.data.event

import com.elouyi.bbk.plugins.live.internal.DanmuInfo0Serializer
import com.elouyi.bbk.utils.BBKExperimentalAPI
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import kotlin.reflect.KClass

@Serializable
public data class LiveDanmu(
    override val cmd: String = "DANMU_MSG",
    val info: JsonArray,
) : LiveEvent.CMDEvent {

    // info[1]
    public val content: String = info[1].jsonPrimitive.content

    @BBKExperimentalAPI
    public val info0: Info0 by lazy {
        Json.decodeFromJsonElement(info[0])
    }

    public val time: Time by lazy {
        val obj = info[9].jsonObject
        Time(obj["ts"]!!.jsonPrimitive.long, obj["ct"]!!.jsonPrimitive.content)
    }

    @BBKExperimentalAPI
    @Serializable(DanmuInfo0Serializer::class)
    public data class Info0(
        val p0: Int,
        val p1: Int,
        val p2: Int,
        val p3: Int,
        val p4: Long,
        val p5: Long,
        val p6: Int,
        val p7: String,
        val p8: Int,
        val p9: Int,
        val p10: Int,
        val p11: String,
        val p12: Int,
        val p13: Obj0?,
        val p14: String,
        val p15: Obj1,
        val p16: Obj2
    ) {

        @Serializable
        public data class Obj0(
            val bulge_display: Int,
            val emoticon_unique: String,
            val height: Int,
            val in_player_area: Int,
            val is_dynamic: Int,
            val url: String,
            val width: Int,
        )

        @Serializable
        public data class Obj1(
            val mode: Int,
            val show_player_type: Int,
            val extra: String
        )

        @Serializable
        public data class Obj2(
            val activity_identity: String,
            val activity_source: Int,
            val not_show: Int
        )
    }

    public data class Time(
        val ts: Long,
        val ct: String
    )

    @OptIn(BBKExperimentalAPI::class)
    override fun toString(): String {
        return "LiveDanmuEvent(content='$content', info0=$info0, time=$time)"
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveDanmu> {
        override val kClass: KClass<LiveDanmu> = LiveDanmu::class
        override val cmd: String = "DANMU_MSG"
    }
}
