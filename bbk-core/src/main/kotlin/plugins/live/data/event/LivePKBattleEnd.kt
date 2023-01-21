package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePKBattleEnd(
    override val cmd: String = "PK_BATTLE_END",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val timestamp: Long
) : LiveEvent.CMDEvent.PKEvent {
    @Serializable
    public data class Data(
        val battle_type: Int,
        val init_info: InitInfo,
        val match_info: MatchInfo,
        val timer: Int
    ) {
        @Serializable
        public data class InitInfo(
            val best_uname: String,
            val room_id: Long,
            val votes: Int,
            val winner_type: Int
        )

        @Serializable
        public data class MatchInfo(
            val best_uname: String,
            val room_id: Long,
            val votes: Int,
            val winner_type: Int
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattleEnd> {
        override val kClass: KClass<LivePKBattleEnd> = LivePKBattleEnd::class
        override val cmd: String = "PK_BATTLE_END"
    }
}
