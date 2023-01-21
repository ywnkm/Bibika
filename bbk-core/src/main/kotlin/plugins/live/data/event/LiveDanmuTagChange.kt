package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
public data class LiveDanmuTagChange(
    override val cmd: String = "DANMU_TAG_CHANGE",
    val data: Data
) : LiveEvent.CMDEvent {

    @Serializable
    public data class Data(
        val chronos_mode: ChronosMode,
        val dm_chronos_extra: String,
        val dm_chronos_screen_type: Int,
        val dm_mode: List<Int>,
        val dm_setting_switch: Int,
        val dm_tag: Int,
        val extra: String,
        val material_conf: List<MaterialConf>,
        val platform: List<Int>,
        val room_id: Int
    ) {
        @Serializable
        public data class ChronosMode(
            val mobi_module: String,
            val mobi_module_file: String,
            val mobi_module_file_name: String,
            val mobi_pool: String
        )

        @Serializable
        public data class MaterialConf(
            val activity_test_material: String,
            val activity_type: Int,
            val customized_material: Int,
            val dm_mode: Int,
            val main_state_dm_color: String,
            val material_mode: List<MaterialMode>,
            val objective_state_dm_color: String,
            val web_material: String
        ) {

            @Serializable
            public data class MaterialMode(
                val app_key: String,
                val chronos_apply: Int,
                val mobi_material: MobiMaterial
            ) {
                @Serializable
                public data class MobiMaterial(
                    val mobi_module: String,
                    val mobi_module_file: String,
                    val mobi_module_file_name: String,
                    val mobi_module_version: Int,
                    val mobi_pool: String
                )
            }
        }
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LiveDanmuTagChange> {
        override val cmd: String = "DANMU_TAG_CHANGE"
        override val kClass: KClass<LiveDanmuTagChange> = LiveDanmuTagChange::class
    }
}
