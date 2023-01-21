package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePKBattleSettleV2(
    override val cmd: String = "PK_BATTLE_SETTLE_V2",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val settle_status: Int,
    val timestamp: Long
) :LiveEvent.CMDEvent.PKEvent {
    @Serializable
    public data class Data(
        val assist_list: List<Assist>,
        val level_info: LevelInfo,
        val pk_id: String,
        val pk_type: Int,
        val result_info: ResultInfo,
        val result_type: Int,
        val season_id: Int,
        val star_light_msg: String
    ) {
        @Serializable
        public data class Assist(
            val face: String,
            val id: Int,
            val score: Int,
            val uname: String
        )

        @Serializable
        public data class LevelInfo(
            val first_rank_img: String,
            val first_rank_name: String,
            val second_rank_icon: String,
            val second_rank_num: Int,
            val uid: String
        )

        @Serializable
        public data class ResultInfo(
            val pk_extra_value: Int,
            val pk_votes: Int,
            val pk_votes_name: String,
            val total_score: Int
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattleSettleV2> {
        override val cmd: String = "PK_BATTLE_SETTLE_V2"
        override val kClass: KClass<LivePKBattleSettleV2> = LivePKBattleSettleV2::class
    }
}
