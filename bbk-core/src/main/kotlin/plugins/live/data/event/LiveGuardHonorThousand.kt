package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveGuardHonorThousand(
    override val cmd: String = "GUARD_HONOR_THOUSAND",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val add: List<Long>,
        val del: List<Long>,
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveGuardHonorThousand> {
        override val kClass: KClass<LiveGuardHonorThousand> = LiveGuardHonorThousand::class
        override val cmd: String = "GUARD_HONOR_THOUSAND"
    }
}
