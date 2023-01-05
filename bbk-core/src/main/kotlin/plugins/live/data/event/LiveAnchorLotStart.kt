package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveAnchorLotStart(
    override val cmd: String = "ANCHOR_LOT_START",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        @SerialName("asset_icon")
        val assetIcon: String,
        @SerialName("asset_icon_webp")
        val assetIconWebp: String,
        @SerialName("award_image")
        val awardImage: String,
        @SerialName("award_name")
        val awardName: String,
        @SerialName("award_num")
        val awardNum: Int,
        @SerialName("award_type")
        val awardType: Int,
        @SerialName("cur_gift_num")
        val curGiftNum: Int,
        @SerialName("current_time")
        val currentTime: Long,
        val danmu: String,
        @SerialName("danmu_new")
        val danmuNew: List<DanmuNew>,
        @SerialName("danmu_type")
        val danmuType: Int,
        @SerialName("gift_id")
        val giftId: Int,
        @SerialName("gift_name")
        val giftName: String,
        @SerialName("gift_num")
        val giftNum: Int,
        @SerialName("gift_price")
        val giftPrice: Int,
        @SerialName("goaway_time")
        val goawayTime: Int,
        @SerialName("goods_id")
        val goodsId: Int,
        val id: Int,
        @SerialName("is_broadcast")
        val isBroadcast: Int,
        @SerialName("join_type")
        val joinType: Int,
        @SerialName("lot_status")
        val lotStatus: Int,
        @SerialName("max_time")
        val maxTime: Int,
        @SerialName("require_text")
        val requireText: String,
        @SerialName("require_type")
        val requireType: Int,
        @SerialName("require_value")
        val requireValue: Int,
        @SerialName("room_id")
        val roomId: Int,
        @SerialName("send_gift_ensure")
        val sendGiftEnsure: Int,
        @SerialName("show_panel")
        val showPanel: Int,
        @SerialName("start_dont_popup")
        val startDontPopup: Int,
        val status: Int,
        val time: Int,
        val url: String,
        @SerialName("web_url")
        val webUrl: String,
    ) {

        @Serializable
        public data class DanmuNew(
            val danmu: String,
            @SerialName("danmu_view")
            val danmuView: String,
            val reject: Boolean,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveAnchorLotStart> {
        override val cmd: String = "ANCHOR_LOT_START"
        override val kClass: KClass<LiveAnchorLotStart> = LiveAnchorLotStart::class
    }
}
