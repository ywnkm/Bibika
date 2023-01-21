package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePKBattleStart(
    override val cmd: String = "PK_BATTLE_START",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val roomid: String,
    val timestamp: Long
) : LiveEvent.CMDEvent.PKEvent {
    @Serializable
    public data class Data(
        val battle_type: Int,
        val final_conf: FinalConf,
        val final_hit_votes: Int,
        val init_info: InitInfo,
        val match_info: MatchInfo,
        val pk_countdown: Long,
        val pk_end_time: Long,
        val pk_frozen_time: Long,
        val pk_start_time: Long,
        val pk_votes_add: Int,
        val pk_votes_name: String,
        val pk_votes_type: Int,
        val star_light_msg: String
    ) {
        @Serializable
        public data class FinalConf(
            val end_time: Long,
            val start_time: Long,
            val switch: Int
        )

        @Serializable
        public data class InitInfo(
            val date_streak: Int,
            val room_id: Long
        )

        @Serializable
        public data class MatchInfo(
            val date_streak: Int,
            val room_id: Long
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattleStart> {
        override val cmd: String = "PK_BATTLE_START"
        override val kClass: KClass<LivePKBattleStart> = LivePKBattleStart::class
    }
}
