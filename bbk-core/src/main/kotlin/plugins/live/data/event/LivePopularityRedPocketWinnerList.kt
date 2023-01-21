package com.elouyi.bbk.plugins.live.data.event

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlin.reflect.KClass

@Serializable
public data class LivePopularityRedPocketWinnerList(
    override val cmd: String = "POPULARITY_RED_POCKET_WINNER_LIST",
    val data: Data
) : LiveEvent.CMDEvent {
    @Serializable
    public data class Data(
        /*
        "awards": {
            "31212": {
                "award_type": 1,
                "award_name": "打call",
                "award_pic": "https://s1.hdslb.com/bfs/live/461be640f60788c1d159ec8d6c5d5cf1ef3d1830.png",
                "award_big_pic": "https://i0.hdslb.com/bfs/live/9e6521c57f24c7149c054d265818d4b82059f2ef.png",
                "award_price": 500
            },
            "31214": {
                "award_type": 1,
                "award_name": "牛哇",
                "award_pic": "https://s1.hdslb.com/bfs/live/91ac8e35dd93a7196325f1e2052356e71d135afb.png",
                "award_big_pic": "https://i0.hdslb.com/bfs/live/3b74c117b4f265edcea261bc5608a58d3a7c300a.png",
                "award_price": 100
            },
            "31216": {
                "award_type": 1,
                "award_name": "i了i了",
                "award_pic": "https://s1.hdslb.com/bfs/live/1157a445487b39c0b7368d91b22290c60fa665b2.png",
                "award_big_pic": "https://i0.hdslb.com/bfs/live/cfb9c3d9bdd2c25c95b7d859ebaa590ca9362adb.png",
                "award_price": 100
            }
        },
         */
        val awards: JsonObject,
        val lot_id: Long,
        val total_num: Int,
        val version: Int,
        /*
        "winner_info": [
            [
                28020784,
                "老猫咪酱00",
                4636497,
                31212
            ],
            [
                8302850,
                "不善良的橙子",
                4682403,
                31212
            ],
            [
                399826074,
                "大品天仙",
                4635972,
                31214
            ],
            [
                1386884047,
                "紫晶幻象阁",
                4634281,
                31214
            ],
            [
                282829397,
                "是夏天的蝉",
                4632874,
                31214
            ],
            [
                3493122040400644,
                "重新吃人",
                4634962,
                31216
            ],
            [
                1470888497,
                "伽拉小姐灬",
                4634282,
                31216
            ],
            [
                246334223,
                "Randkinan",
                4676637,
                31216
            ]
        ],
         */
        val winner_info: JsonArray
    ) {
        // todo
        @Serializable
        public class WinnerInfo(

        )
    }

    public companion object : LiveEvent.CMDEvent.CMDEventHelper<LivePopularityRedPocketWinnerList> {
        override val cmd: String = "POPULARITY_RED_POCKET_WINNER_LIST"
        override val kClass: KClass<LivePopularityRedPocketWinnerList> = LivePopularityRedPocketWinnerList::class
    }
}
