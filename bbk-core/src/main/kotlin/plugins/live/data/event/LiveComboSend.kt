package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveComboSend(
    override val cmd: String = "COMBO_SEND",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val action: String,
        @SerialName("batch_combo_id")
        val batchComboId: String,
        @SerialName("batch_combo_num")
        val batchComboNum: Int,
        @SerialName("combo_id")
        val comboId: String,
        @SerialName("combo_num")
        val comboNum: Int,
        @SerialName("combo_total_coin")
        val comboTotalCoin: Int,
        @SerialName("dmscore")
        val dmScore: Int,
        @SerialName("gift_id")
        val giftId: Int,
        @SerialName("gift_name")
        val giftName: String,
        @SerialName("gift_num")
        val giftNum: Int,
        @SerialName("is_join_receiver")
        val isJoinReceiver: Boolean,
        @SerialName("is_naming")
        val isNaming: Boolean,
        @SerialName("is_show")
        val isShow: Int,
        @SerialName("medal_info")
        val medalInfo: MedalInfo,
        @SerialName("name_color")
        val nameColor: String,
        @SerialName("r_uname")
        val rUname: String,
        @SerialName("receive_user_info")
        val receiveUserInfo: ReceiveUserInfo,
        @SerialName("ruid")
        val ruid: Long,
        @SerialName("send_master")
        @Contextual
        val sendMaster: Nothing? = null,
        @SerialName("total_num")
        val totalNum: Int,
        @SerialName("uid")
        val uid: Long,
        @SerialName("uname")
        val uname: String,
    ) {

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
            val special: String,
            @SerialName("target_id")
            val targetId: Long,
        )

        @Serializable
        public data class ReceiveUserInfo(
            @SerialName("uid")
            val uid: Long,
            @SerialName("uname")
            val uname: String,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveComboSend> {
        override val cmd: String = "COMBO_SEND"
        override val kClass: KClass<LiveComboSend> = LiveComboSend::class
    }
}
