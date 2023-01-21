package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LivePKBattleFinalProcess(
    override val cmd: String = "PK_BATTLE_FINAL_PROCESS",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val timestamp: Long
) :LiveEvent.CMDEvent.PKEvent {
    @Serializable
    public data class Data(
        val battle_type: Int,
        val pk_frozen_time: Int
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattleFinalProcess> {
        override val cmd: String = "PK_BATTLE_FINAL_PROCESS"
        override val kClass: KClass<LivePKBattleFinalProcess> = LivePKBattleFinalProcess::class
    }
}
