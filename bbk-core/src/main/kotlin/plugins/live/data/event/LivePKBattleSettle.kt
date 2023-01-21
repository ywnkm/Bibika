package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePKBattleSettle(
    override val cmd: String = "PK_BATTLE_SETTLE",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val roomid: String,
    val settle_status: Int,
    val timestamp: Long
) : LiveEvent.CMDEvent.PKEvent {
    @Serializable
    public data class Data(
        val battle_type: Int,
        val result_type: Int,
        val star_light_msg: String
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattleSettle> {
        override val cmd: String = "PK_BATTLE_SETTLE"
        override val kClass: KClass<LivePKBattleSettle> = LivePKBattleSettle::class
    }
}

