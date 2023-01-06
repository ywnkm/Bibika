package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveDanmuAggregation(
    override val cmd: String = "DANMU_AGGREGATION",
    val data: Data,
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val activity_identity: String,
        val activity_source: Int,
        val aggregation_cycle: Int,
        val aggregation_icon: String,
        val aggregation_num: Int,
        val broadcast_msg_type: Int,
        val dmscore: Int,
        val msg: String,
        val show_rows: Int,
        val show_time: Int,
        val timestamp: Long
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveDanmuAggregation> {
        override val cmd: String = "DANMU_AGGREGATION"
        override val kClass: KClass<LiveDanmuAggregation> = LiveDanmuAggregation::class
    }
}
