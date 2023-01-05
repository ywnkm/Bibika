package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

/**
 * 上舰
 */
@Serializable
public data class LiveGuardBuy(
    override val cmd: String = "GUARD_BUY",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val uid: Long,
        val username: String,
        @SerialName("guard_level")
        val guardLevel: Int,
        val num: Int,
        val price: Int,
        @SerialName("gift_id")
        val giftId: Int,
        @SerialName("gift_name")
        val giftName: String,
        @SerialName("start_time")
        val startTime: Long,
        @SerialName("end_time")
        val endTime: Long,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveGuardBuy> {
        override val cmd: String = "GUARD_BUY"
        override val kClass: KClass<LiveGuardBuy> = LiveGuardBuy::class
    }
}
