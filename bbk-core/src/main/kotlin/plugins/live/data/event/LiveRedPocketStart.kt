package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveRedPocketStart(
    override val cmd: String = "RED_POCKET_START",
    val data: Data,
) :LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val background_color: String,
        val content: String,
        val duration: Int,
        val follow_uids: String,
        val head_icon: String,
        val high_light_text_color: String,
        val id: Int,
        val new_content: String,
        val normal_text_color: String,
        val num: Int,
        val remain_time: Int,
        val require_message: String,
        val sender_face: String,
        val sender_name: String,
        val sender_uid: Int,
        val tail_icon: String,
        val web_tail_icon: String
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveRedPocketStart> {
        override val kClass: KClass<LiveRedPocketStart> = LiveRedPocketStart::class
        override val cmd: String = "RED_POCKET_START"
    }
}
