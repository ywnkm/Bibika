package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePopularityRedPocketStart(
    override val cmd: String = "POPULARITY_RED_POCKET_START",
    val data: Data
) : LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        val awards: List<Award>,
        val current_time: Long,
        val danmu: String,
        val end_time: Long,
        val h5_url: String,
        val join_requirement: Int,
        val last_time: Long,
        val lot_config_id: Long,
        val lot_id: Long,
        val lot_status: Int,
        val remove_time: Long,
        val replace_time: Long,
        val sender_face: String,
        val sender_name: String,
        val sender_uid: Long,
        val start_time: Long,
        val total_price: Int,
        val user_status: Int,
        val wait_num: Int
    ) {
        @Serializable
        public data class Award(
            val gift_id: Int,
            val gift_name: String,
            val gift_pic: String,
            val num: Int
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePopularityRedPocketStart> {
        override val cmd: String = "POPULARITY_RED_POCKET_START"
        override val kClass: KClass<LivePopularityRedPocketStart> = LivePopularityRedPocketStart::class
    }
}
