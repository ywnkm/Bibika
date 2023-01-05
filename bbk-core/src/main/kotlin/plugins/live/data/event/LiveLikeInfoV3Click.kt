package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveLikeInfoV3Click(
    override val cmd: String = "LIKE_INFO_V3_CLICK",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("show_area")
        val showArea: Int,
        @SerialName("msg_type")
        val msgType: Int,
        @SerialName("like_icon")
        val likeIcon: String,
        val uid: Long,
        @SerialName("like_text")
        val likeText: String,
        val uname: String,
        @SerialName("uname_color")
        val unameColor: String,
        val identities: List<Int>,
        @SerialName("fans_medal")
        val fansMedal: FansMedal,
        @SerialName("contribution_info")
        val contributionInfo: ContributionInfo,
        @SerialName("dmscore")
        val dmScore: Int
    ) {

        @Serializable
        public data class FansMedal(
            @SerialName("target_id")
            val targetId: Long,
            @SerialName("medal_level")
            val medalLevel: Int,
            @SerialName("medal_name")
            val medalName: String,
            @SerialName("medal_color")
            val medalColor: Int,
            @SerialName("medal_color_start")
            val medalColorStart: Int,
            @SerialName("medal_color_end")
            val medalColorEnd: Int,
            @SerialName("medal_color_border")
            val medalColorBorder: Int,
            @SerialName("is_lighted")
            val isLighted: Int,
            @SerialName("guard_level")
            val guardLevel: Int,
            val special: String,
            @SerialName("icon_id")
            val iconId: Int,
            @SerialName("anchor_roomid")
            val anchorRoomid: Long,
            val score: Int
        )

        @Serializable
        public data class ContributionInfo(
            val grade: Int
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveLikeInfoV3Click> {
        override val kClass: KClass<LiveLikeInfoV3Click> = LiveLikeInfoV3Click::class
        override val cmd: String = "LIKE_INFO_V3_CLICK"
    }

}