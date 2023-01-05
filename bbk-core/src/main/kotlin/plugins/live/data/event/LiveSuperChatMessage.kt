package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveSuperChatMessage(
    override val cmd: String = "SUPER_CHAT_MESSAGE",
    val data: Data,
    @SerialName("roomid")
    val roomId: Long,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("background_bottom_color")
        val backgroundBottomColor: String,
        @SerialName("background_color")
        val backgroundColor: String,
        @SerialName("background_color_end")
        val backgroundColorEnd: String,
        @SerialName("background_color_start")
        val backgroundColorStart: String,
        @SerialName("background_icon")
        val backgroundIcon: String,
        @SerialName("background_image")
        val backgroundImage: String,
        @SerialName("background_price_color")
        val backgroundPriceColor: String,
        @SerialName("color_point")
        val colorPoint: Double,
        val dmscore: Int,
        @SerialName("end_time")
        val endTime: Int,
        val gift: Gift,
        val id: Int,
        @SerialName("is_ranked")
        val isRanked: Int,
        @SerialName("is_send_audit")
        val isSendAudit: Int,
        @SerialName("medal_info")
        val medalInfo: MedalInfo?,
        val message: String,
        @SerialName("message_font_color")
        val messageFontColor: String,
        @SerialName("message_trans")
        val messageTrans: String,
        val price: Int,
        val rate: Int,
        @SerialName("start_time")
        val startTime: Int,
        val time: Int,
        val token: String,
        @SerialName("trans_mark")
        val transMark: Int,
        val ts: Long,
        val uid: Long,
        @SerialName("user_info")
        val userInfo: UserInfo,
    ) {

        @Serializable
        public data class Gift(
            @SerialName("gift_id")
            val giftId: Int,
            @SerialName("gift_name")
            val giftName: String,
            val num: Int,
        )

        @Serializable
        public data class MedalInfo(
            @SerialName("anchor_roomid")
            val anchorRoomid: Int,
            @SerialName("anchor_uname")
            val anchorUname: String,
            @SerialName("guard_level")
            val guardLevel: Int,
            @SerialName("icon_id")
            val iconId: Int,
            @SerialName("is_lighted")
            val isLighted: Int,
            @SerialName("medal_color")
            val medalColor: String,
            @SerialName("medal_color_border")
            val medalColorBorder: Int,
            @SerialName("medal_color_end")
            val medalColorEnd: Int,
            @SerialName("medal_color_start")
            val medalColorStart: Int,
            @SerialName("medal_level")
            val medalLevel: Int,
            @SerialName("medal_name")
            val medalName: String,
            val special: String,
            @SerialName("target_id")
            val targetId: Long,
        )

        @Serializable
        public data class UserInfo(
            val face: String,
            @SerialName("face_frame")
            val faceFrame: String,
            @SerialName("guard_level")
            val guardLevel: Int,
            @SerialName("is_main_vip")
            val isMainVip: Int,
            @SerialName("is_svip")
            val isSvip: Int,
            @SerialName("is_vip")
            val isVip: Int,
            @SerialName("level_color")
            val levelColor: String,
            val manager: Int,
            @SerialName("name_color")
            val nameColor: String,
            val title: String,
            val uname: String,
            @SerialName("user_level")
            val userLevel: Int,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveSuperChatMessage> {
        override val kClass: KClass<LiveSuperChatMessage> = LiveSuperChatMessage::class
        override val cmd: String = "SUPER_CHAT_MESSAGE"
    }

}