package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveAreaRankChanged(
    override val cmd: String = "AREA_RANK_CHANGED",
    val data: Data
) : LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        val action_type: Int,
        val conf_id: Int,
        val icon_url_blue: String,
        val icon_url_grey: String,
        val icon_url_pink: String,
        val jump_url_link: String,
        val jump_url_pc: String,
        val jump_url_pink: String,
        val jump_url_web: String,
        val msg_id: String,
        val rank: Int,
        val rank_name: String,
        val timestamp: Long,
        val uid: Long
    )

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveAreaRankChanged> {
        override val kClass: KClass<LiveAreaRankChanged> = LiveAreaRankChanged::class
        override val cmd: String = "AREA_RANK_CHANGED"
    }
}
