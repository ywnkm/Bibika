package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveInteractWord(
    override val cmd: String = "INTERACT_WORD",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val contribution: Contribution,
        @SerialName("core_user_type")
        val coreUserType: Int,
        val dmscore: Int,
        @SerialName("fans_medal")
        val fansMedal: FansMedal,
        val identities: List<Int>,
        @SerialName("is_spread")
        val isSpread: Int,
        @SerialName("msg_type")
        val msgType: Int,
        @SerialName("privilege_type")
        val privilegeType: Int,
        val roomid: Long,
        val score: Long,
        @SerialName("spread_desc")
        val spreadDesc: String,
        @SerialName("spread_info")
        val spreadInfo: String,
        @SerialName("tail_icon")
        val tailIcon: Int,
        val timestamp: Int,
        @SerialName("trigger_time")
        val triggerTime: Long,
        val uid: Long,
        val uname: String,
        @SerialName("uname_color")
        val unameColor: String
    ) {
        @Serializable
        public data class Contribution(
            val grade: Int
        )
        @Serializable
        public data class FansMedal(
            @SerialName("anchor_roomid")
            val anchorRoomid: Long,
            @SerialName("guard_level")
            val guardLevel: Int,
            @SerialName("icon_id")
            val iconId: Int,
            @SerialName("is_lighted")
            val isLighted: Int,
            @SerialName("medal_color")
            val medalColor: Int,
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
            val score: Int,
            val special: String,
            @SerialName("target_id")
            val targetId: Long
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveInteractWord> {
        override val kClass: KClass<LiveInteractWord> = LiveInteractWord::class
        override val cmd: String = "INTERACT_WORD"
    }


}