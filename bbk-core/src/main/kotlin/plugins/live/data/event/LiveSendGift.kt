package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveSendGift(
    override val cmd: String = "SEND_GIFT",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val action: String,
        @SerialName("batch_combo_id")
        val batchComboId: String,
        @SerialName("batch_combo_send")
        @Contextual
        val batchComboSend: BatchComboSend?,
        val beatId: String,
        @SerialName("biz_source")
        val bizSource: String,
        @SerialName("blind_gift")
        val blindGift: BlindGift?,
        @SerialName("broadcast_id")
        val broadcastId: Int,
        @SerialName("coin_type")
        val coinType: String,
        @SerialName("combo_resources_id")
        val comboResourcesId: Int,
        @SerialName("combo_send")
        @Contextual
        val comboSend: ComboSend?,
        @SerialName("combo_stay_time")
        val comboStayTime: Int,
        @SerialName("combo_total_coin")
        val comboTotalCoin: Int,
        @SerialName("crit_prob")
        val critProb: Int,
        val demarcation: Int,
        @SerialName("discount_price")
        val discountPrice: Int,
        val dmscore: Int,
        val draw: Int,
        val effect: Int,
        @SerialName("effect_block")
        val effectBlock: Int,
        val face: String,
        @SerialName("face_effect_id")
        val faceEffectId: Int,
        @SerialName("face_effect_type")
        val faceEffectType: Int,
        @SerialName("float_sc_resource_id")
        val floatScResourceId: Int,
        @SerialName("giftId")
        val giftId: Int,
        @SerialName("giftName")
        val giftName: String,
        @SerialName("giftType")
        val giftType: Int,
        val gold: Int,
        @SerialName("guard_level")
        val guardLevel: Int,
        @SerialName("is_first")
        val isFirst: Boolean,
        @SerialName("is_join_receiver")
        val isJoinReceiver: Boolean,
        @SerialName("is_naming")
        val isNaming: Boolean,
        @SerialName("is_special_batch")
        val isSpecialBatch: Int,
        val magnification: Float,
        @SerialName("medal_info")
        val medalInfo: MedalInfo,
        @SerialName("name_color")
        val nameColor: String,
        val num: Int,
        @SerialName("original_gift_name")
        val originalGiftName: String,
        val price: Int,
        val rcost: Int,
        @SerialName("receive_user_info")
        val receiveUserInfo: ReceiveUserInfo,
        val remain: Int,
        val rnd: String,
        @SerialName("send_master")
        @Contextual
        val sendMaster: Nothing? = null,
        val silver: Int,
        @SerialName("super")
        val super0: Int,
        @SerialName("super_batch_gift_num")
        val superBatchGiftNum: Int,
        @SerialName("super_gift_num")
        val superGiftNum: Int,
        @SerialName("svga_block")
        val svgaBlock: Int,
        val switch: Boolean,
        @SerialName("tag_image")
        val tagImage: String,
        val tid: String,
        val timestamp: Int,
        @SerialName("top_list")
        @Contextual
        val topList: Nothing? = null,
        @SerialName("total_coin")
        val totalCoin: Int,
        val uid: Long,
        val uname: String,
    ) {

        @Serializable
        public data class BatchComboSend(
            val action: String,
            @SerialName("batch_combo_id")
            val batchComboId: String,
            @SerialName("batch_combo_num")
            val batchComboNum: Int,
            @SerialName("blind_gift")
            val blindGift: BlindGift?,
            @SerialName("gift_id")
            val giftId: Int,
            @SerialName("gift_name")
            val giftName: String,
            @SerialName("gift_num")
            val giftNum: Int,
            @SerialName("send_master")
            @Contextual
            val sendMaster: Nothing? = null,
            val uid: Long,
            val uname: String,
        )

        @Serializable
        public data class BlindGift(
            @SerialName("blind_gift_config_id")
            val blindGiftConfigId: Int,
            val from: Int,
            @SerialName("gift_action")
            val giftAction: String,
            @SerialName("original_gift_id")
            val originalGiftId: Int,
            @SerialName("original_gift_name")
            val originalGiftName: String,
        )

        @Serializable
        public data class ComboSend(
            val action: String,
            @SerialName("combo_id")
            val comboId: String,
            @SerialName("combo_num")
            val comboNum: Int,
            @SerialName("gift_id")
            val giftId: Int,
            @SerialName("gift_name")
            val giftName: String,
            @SerialName("gift_num")
            val giftNum: Int,
            @SerialName("send_master")
            @Contextual
            val sendMaster: Nothing? = null,
            val uid: Long,
            val uname: String,
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
            val uid: Long,
            val uname: String,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveSendGift> {
        public override val cmd: String = "SEND_GIFT"
        override val kClass: KClass<LiveSendGift> = LiveSendGift::class
    }
}
