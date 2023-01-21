package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePKBattleProcessNew(
    override val cmd: String = "PK_BATTLE_PROCESS_NEW",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val timestamp: Long,
) : LiveEvent.CMDEvent.PKEvent {

    @Serializable
    public data class Data(
        val battle_type: Int,
        val init_info: InitInfo,
        val match_info: MatchInfo
    ) {
        @Serializable
        public data class InitInfo(
            val best_uname: String,
            val room_id: Long,
            val vision_desc: Int,
            val votes: Int
        )

        @Serializable
        public data class MatchInfo(
            val best_uname: String,
            val room_id: Int,
            val vision_desc: Int,
            val votes: Int
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattleProcessNew> {
        override val kClass: KClass<LivePKBattleProcessNew> = LivePKBattleProcessNew::class
        override val cmd: String = "PK_BATTLE_PROCESS_NEW"
    }
}
