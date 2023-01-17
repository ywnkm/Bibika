package com.elouyi.bbk.plugins.live.data.event

import com.elouyi.bbk.utils.BBKExperimentalAPI
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
public data class LivePanelChangeContent(
    override val cmd: String = "LIVE_PANEL_CHANGE_CONTENT",
    val data: Data
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val setting_list: List<Item>,
        val interaction_list: List<Item>,
        val other_list: List<Item>,
        @BBKExperimentalAPI
        val panel_data: JsonObject?,
        val is_fixed: Int,
        val is_match: Int,
        val match_cristina: String,
        val match_icon: String,
        val match_bg_image: String,
    ) {

        @Serializable
        public data class Item(
            val biz_id: Int,
            val icon: String,
            val title: String,
            val note: String,
            val weight: Int,
            val status_type: Int,
            @BBKExperimentalAPI
            val notification: JsonObject?,
            val custom: List<CustomItem>?,
            val jump_url: String,
            val type_id: Int,
            val tab: Tab?,
            val dynamic_icon: String,
            val sub_icon: String,
            val panel_icon: String,
            val match_entrance: Int
        ) {

            @Serializable
            public data class Tab(
                val type: String,
                val biz_type: String,
                val tab_comment: JsonObject,
                val tab_topic: JsonObject,
                val aggregation: Int,
                val id: Int,
                val sub_title: String,
                val sub_icon: String,
                val show_outer_aggregation: Int,
                val show_guide_bubble: String,
                val global_id: String,
            )

            @Serializable
            public data class CustomItem(
                val icon: String,
                val title: String,
                val note: String,
                val jump_url: String,
                val status: Int,
                val sub_icon: String,
            )
        }
    }
}