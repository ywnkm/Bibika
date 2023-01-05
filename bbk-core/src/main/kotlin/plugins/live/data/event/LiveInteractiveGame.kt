package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveInteractiveGame(
    override val cmd: String = "LIVE_INTERACTIVE_GAME",
    val data: Data,
) : LiveEvent.CMDEvent {


    @Serializable
    public data class Data(
        val type: Int,
        val uid: Long,
        val uname: String,
        val uface: String,
        @SerialName("gift_id")
        val giftId: Int,
        @SerialName("gift_name")
        val giftName: String,
        @SerialName("gift_num")
        val giftNum: Int,
        val price: Int,
        val paid: Boolean,
        val msg: String,
        @SerialName("fans_medal_level")
        val fansMedalLevel: Int,
        @SerialName("guard_level")
        val guardLevel: Int,
        val timestamp: Int,
        @SerialName("anchor_lottery")
        val anchorLottery: String?,
        @SerialName("pk_info")
        val pkInfo: String?,
        @SerialName("anchor_info")
        val anchorInfo: String?,
        @SerialName("combo_info")
        val comboInfo: String?,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveInteractiveGame> {
        override val kClass: KClass<LiveInteractiveGame> = LiveInteractiveGame::class
        override val cmd: String = "LIVE_INTERACTIVE_GAME"
    }
}
