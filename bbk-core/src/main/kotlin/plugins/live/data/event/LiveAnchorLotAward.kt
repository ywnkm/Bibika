package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveAnchorLotAward(
    override val cmd: String = "ANCHOR_LOT_AWARD",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val award_dont_popup: Int,
        val award_image: String,
        val award_name: String,
        val award_num: Int,
        val award_type: Int,
        val award_users: List<AwardUser>,
        val id: Int,
        val lot_status: Int,
        val url: String,
        val web_url: String
    ) {
        @Serializable
        public data class AwardUser(
            val uid: Long,
            val uname: String,
            val face: String,
            val level: Int,
            val color: Int,
            val num: Int
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveAnchorLotAward> {
        override val cmd: String = "ANCHOR_LOT_AWARD"
        override val kClass: KClass<LiveAnchorLotAward> = LiveAnchorLotAward::class
    }
}
