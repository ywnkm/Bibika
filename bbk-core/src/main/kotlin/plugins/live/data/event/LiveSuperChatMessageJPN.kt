package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveSuperChatMessageJPN(
    override val cmd: String = "SUPER_CHAT_MESSAGE_JPN",
    val data: Data,
    val roomid: Long,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val id: String,
        val uid: String,
        val price: Int,
        val rate: Int,
        val message: String,
        val message_jpn: String,
        val is_ranked: Int,
        val background_image: String,
        val background_color: String,
        val background_icon: String,
        val background_price_color: String,
        val background_bottom_color: String,
        val ts: Long,
        val token: String,
        val medal_info: MedalInfo?,
        val user_info: UserInfo,
        val time: Int,
        val start_time: Int,
        val end_time: Int,
        val gift: Gift,
    ) {
        @Serializable
        public data class MedalInfo(
            val icon_id: Int,
            val target_id: Long,
            val special: String,
            val anchor_uname: String,
            val anchor_roomid: Long,
            val medal_level: Int,
            val medal_name: String,
            val medal_color: String,
        )

        @Serializable
        public data class UserInfo(
            val uname: String,
            val face: String,
            val face_frame: String,
            val guard_level: Int,
            val user_level: Int,
            val level_color: String,
            val is_vip: Int,
            val is_svip: Int,
            val is_main_vip: Int,
            val title: String,
            val manager: Int,
        )

        @Serializable
        public data class Gift(
            val num: Int,
            val gift_id: Int,
            val gift_name: String,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveSuperChatMessageJPN> {
        override val cmd: String = "SUPER_CHAT_MESSAGE_JPN"
        override val kClass: KClass<LiveSuperChatMessageJPN> = LiveSuperChatMessageJPN::class
    }
}
