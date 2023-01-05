package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveNoticeMsg(
    override val cmd: String = "NOTICE_MSG",
    val id: Int,
    val name: String,
    val full: Full,
    val half: Half,
    val side: Side,
    @SerialName("roomid")
    val roomId: Int,
    @SerialName("real_roomid")
    val realRoomId: Int,
    @SerialName("msg_common")
    val msgCommon: String,
    @SerialName("msg_self")
    val msgSelf: String,
    @SerialName("link_url")
    val linkUrl: String,
    @SerialName("msg_type")
    val msgType: Int,
    @SerialName("shield_uid")
    val shieldUid: Int,
    @SerialName("business_id")
    val businessId: String,
    val scatter: Scatter,
    @SerialName("marquee_id")
    val marqueeId: String,
    @SerialName("notice_type")
    val noticeType: Int,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Full(
        @SerialName("head_icon")
        val headIcon: String,
        @SerialName("tail_icon")
        val tailIcon: String,
        @SerialName("head_icon_fa")
        val headIconFa: String,
        @SerialName("tail_icon_fa")
        val tailIconFa: String,
        @SerialName("head_icon_fan")
        val headIconFan: Int,
        @SerialName("tail_icon_fan")
        val tailIconFan: Int,
        val background: String,
        val color: String,
        val highlight: String,
        val time: Int
    )

    @Serializable
    public data class Half(
        @SerialName("head_icon")
        val headIcon: String,
        @SerialName("tail_icon")
        val tailIcon: String,
        val background: String,
        val color: String,
        val highlight: String,
        val time: Int
    )

    @Serializable
    public data class Side(
        @SerialName("head_icon")
        val headIcon: String,
        val background: String,
        val color: String,
        val highlight: String,
        val border: String
    )

    @Serializable
    public data class Scatter(
        val min: Int,
        val max: Int,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveNoticeMsg> {
        override val kClass: KClass<LiveNoticeMsg> = LiveNoticeMsg::class
        override val cmd: String = "NOTICE_MSG"
    }
}
