package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.reflect.KClass

@Serializable
public data class LivePKBattlePreNew(
    override val cmd: String = "PK_BATTLE_PRE_NEW",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val roomid: Long,
    val timestamp: Long
) : LiveEvent.CMDEvent.PKEvent {
    @Serializable
    public data class Data(
        val battle_type: Int,
        val end_win_task: JsonObject?, // todo
        val face: String,
        val match_type: Int,
        val pk_votes_name: String,
        val pre_timer: Int,
        val room_id: Long,
        val season_id: Int,
        val uid: Long,
        val uname: String
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattlePreNew> {
        override val cmd: String = "PK_BATTLE_PRE_NEW"
        override val kClass: KClass<LivePKBattlePreNew> = LivePKBattlePreNew::class
    }
}
