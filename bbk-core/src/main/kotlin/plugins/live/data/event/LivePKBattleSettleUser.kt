package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.reflect.KClass

// 有点复杂
@Serializable
public data class LivePKBattleSettleUser(
    override val cmd: String = "PK_BATTLE_SETTLE_USER",
    val data: Data,
    val pk_id: Long,
    val pk_status: Int,
    val settle_status: Int,
    val timestamp: Long
) : LiveEvent.CMDEvent.PKEvent {
    @Serializable
    public data class Data(
        val pk_id: String,
        val season_id: Int,
        val settle_status: Int,
        val result_type: Int,
        val battle_type: Int,
        val result_info: ResultInfo,
        val winner: Winner,
        val my_info: MyInfo,
        val level_info: LevelInfo,
    ) {
        @Serializable
        public data class ResultInfo(
            val total_score: Int,
            val result_type_score: Int,
            val pk_votes: Int,
            val pk_votes_name: String,
            val pk_crit_score: Int,
            val pk_resist_crit_score: Int,
            val pk_extra_score_slot: String,
            val pk_extra_value: Int,
            val pk_extra_score: Int,
            val pk_task_score: Int,
            val pk_times_score: Int,
            val pk_done_times: Int,
            val pk_total_times: Int,
            val win_count: Int,
            val win_final_hit: Int,
            val winner_count_score: Int,
            val task_score_list: List<JsonObject> // todo
        )

        @Serializable
        public data class Winner(
            val room_id: Long,
            val uid: Long,
            val uname: String,
            val face: String,
            val face_frame: String,
            val exp: Exp,
            val best_user: BestUser
        ) {
            @Serializable
            public data class Exp(
                val color: Int,
                val user_level: Int,
                val master_level: MasterLevel
            ) {
                @Serializable
                public data class MasterLevel(
                    val color: Int,
                    val level: Int
                )
            }

            @Serializable
            public data class BestUser(
                val uid: Long,
                val uname: String,
                val face: String,
                val pk_votes: Int,
                val pk_votes_name: String,
                val exp: Exp,
                val face_frame: String,
                val badge: Badge,
                val award_info: String?,
                val award_info_list: List<String>,
                val end_win_award_info_list: EndWinAwardInfoList
            ) {
                @Serializable
                public data class Exp(
                    val color: Int,
                    val level: Int
                )

                @Serializable
                public data class Badge(
                    val url: String,
                    val desc: String,
                    val position: Int
                )

                @Serializable
                public data class EndWinAwardInfoList(
                    val list: List<String>
                )
            }
        }

        @Serializable
        public data class MyInfo(
            val room_id: Long,
            val uid: Long,
            val uname: String,
            val face: String,
            val face_frame: String,
            val exp: Exp,
            val best_user: BestUser
        ) {
            @Serializable
            public data class Exp(
                val color: Int,
                val user_level: Int,
                val master_level: MasterLevel
            ) {
                @Serializable
                public data class MasterLevel(
                    val color: Int,
                    val level: Int
                )
            }

            @Serializable
            public data class BestUser(
                val uid: Long,
                val uname: String,
                val face: String,
                val pk_votes: Int,
                val pk_votes_name: String,
                val exp: Exp,
                val face_frame: String,
                val badge: Badge,
                val award_info: String?, // todo
                val award_info_list: List<String>, // todo
                val end_win_award_info_list: EndWinAwardInfoList
            ) {
                @Serializable
                public data class Exp(
                    val color: Int,
                    val level: Int
                )

                @Serializable
                public data class Badge(
                    val url: String,
                    val desc: String,
                    val position: Int
                )

                @Serializable
                public data class EndWinAwardInfoList(
                    val list: List<String>
                )
            }
        }

        @Serializable
        public data class LevelInfo(
            val first_rank_name: String,
            val second_rank_num: Int,
            val first_rank_img: String,
            val second_rank_icon: String,
        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePKBattleSettleUser> {
        override val cmd: String = "PK_BATTLE_SETTLE_USER"
        override val kClass: KClass<LivePKBattleSettleUser> = LivePKBattleSettleUser::class
    }
}
