package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveUserToastMsg(
    override val cmd: String = "USER_TOAST_MSG",
    val data: Data,
) :LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val anchor_show: Boolean,
        val color: String,
        val dmscore: Int,
        val effect_id: Int,
        val end_time: Long,
        val face_effect_id: Int,
        val gift_id: Int,
        val guard_level: Int,
        val is_show: Int,
        val num: Int,
        val op_type: Int,
        val payflow_id: String,
        val price: Int,
        val role_name: String,
        val room_effect_id: Int,
        val start_time: Long,
        val svga_block: Int,
        val target_guard_count: Int,
        val toast_msg: String,
        val uid: Long,
        val unit: String,
        val user_show: Boolean,
        val username: String,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveUserToastMsg> {
        override val cmd: String = "USER_TOAST_MSG"
        override val kClass: KClass<LiveUserToastMsg> = LiveUserToastMsg::class
    }
}
