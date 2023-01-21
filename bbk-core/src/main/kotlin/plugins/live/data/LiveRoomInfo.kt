package com.elouyi.bbk.plugins.live.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
字段	类型	内容	备注
code	num	返回值	0：成功
1：不存在
message	str	错误信息
msg	str	错误信息
data	obj	信息本体
data对象：

字段	类型	内容	备注
uid	num	主播mid
room_id	num	直播间长号
short_id	num	直播间短号	为0是无短号
attention	num	关注数量
online	num	观看人数
is_portrait	bool	是否竖屏
description	str	描述
live_status	num	直播状态	0：未开播
1：直播中
2：轮播中
area_id	num	分区id
area_name	str	分区名称
parent_area_id	num	父分区id
parent_area_name	str	父分区名称
old_area_id	num	旧版分区id
background	str	背景图片链接
title	str	标题
user_cover	str	封面
keyframe	str	关键帧	用于网页端悬浮展示
is_strict_room	bool	未知	未知
live_time	str	直播开始时间	YYYY-MM-DD HH:mm:ss
tags	str	标签	','分隔
is_anchor	num	未知	未知
room_silent_type	str	禁言状态
room_silent_level	num	禁言等级
room_silent_second	num	禁言时间	单位是秒
pardants	str	未知	未知
area_pardants	str	未知	未知
hot_words	list(str)	热词
hot_words_status	num	热词状态
verify	str	未知	未知
new_pendants	obj	头像框\大v
up_session	str	未知
pk_status	num	pk状态
pk_id	num	pk id
battle_id	num	未知
new_pendants对象：

字段	类型	内容	备注
frame	obj	头像框
mobile_frame	obj	同上	手机版, 结构一致, 可能null
badge	obj	大v
mobile_badge	obj	同上	手机版, 结构一致, 可能null
frame对象：

字段	类型	内容	备注
name	str	名称
value	str	值
position	num	位置
desc	str	描述
area	num	分区
area_old	num	旧分区
bg_color	str	背景色
bg_pic	str	背景图
use_old_area	bool	是否旧分区号
badge对象：

字段	类型	内容	备注
name	str	类型	v_person: 个人认证(黄)
v_company: 企业认证(蓝)
position	num	位置
value	str	值
desc	str	描述
 */
@Serializable
public data class LiveRoomInfo(
    val code: Int,
    val msg: String,
    val message: String,
    val data: Data
) {

    @Serializable
    public data class Data(
        val uid: Long,
        @SerialName("room_id")
        val roomId: Long,
        @SerialName("short_id")
        val shortId: Int,
        val attention: Int,
        val online: Int,
        @SerialName("is_portrait")
        val isPortrait: Boolean,
        val description: String,
        @SerialName("live_status")
        val liveStatus: Int,
        @SerialName("area_id")
        val areaId: Int,
        @SerialName("area_name")
        val areaName: String,
        @SerialName("parent_area_id")
        val parentAreaId: Int,
        @SerialName("parent_area_name")
        val parentAreaName: String,
        @SerialName("old_area_id")
        val oldAreaId: Int,
        val background: String,
        val title: String,
        @SerialName("user_cover")
        val userCover: String,
        val keyframe: String,
        @SerialName("is_strict_room")
        val isStrictRoom: Boolean,
        @SerialName("live_time")
        val liveTime: String,
        val tags: String,
        @SerialName("is_anchor")
        val isAnchor: Int,
        @SerialName("room_silent_type")
        val roomSilentType: String,
        @SerialName("room_silent_level")
        val roomSilentLevel: Int,
        @SerialName("room_silent_second")
        val roomSilentSecond: Int,
        val pendants: String,
        @SerialName("area_pendants")
        val areaPendants: String,
        @SerialName("hot_words")
        val hotWords: List<String>,
        @SerialName("hot_words_status")
        val hotWordsStatus: Int,
        val verify: String,
        @SerialName("new_pendants")
        val newPendants: NewPendants,
        @SerialName("up_session")
        val upSession: String,
        @SerialName("pk_status")
        val pkStatus: Int,
        @SerialName("pk_id")
        val pkId: Int,
        @SerialName("battle_id")
        val battleId: Int
    ) {

        @Serializable
        public data class NewPendants(
            @SerialName("frame")
            val frame: Frame?,
            @SerialName("mobile_frame")
            val mobileFrame: Frame?,
            @SerialName("badge")
            val badge: Badge?,
            @SerialName("mobile_badge")
            val mobileBadge: Badge?
        ) {

            @Serializable
            public data class Frame(
                val name: String,
                val value: String,
                val position: Int,
                val desc: String,
                val area: Int,
                @SerialName("area_old")
                val areaOld: Int,
                @SerialName("bg_color")
                val bgColor: String,
                @SerialName("bg_pic")
                val bgPic: String,
                @SerialName("use_old_area")
                val useOldArea: Boolean
            )

            @Serializable
            public data class Badge(
                val name: String,
                val position: Int,
                val value: String,
                val desc: String
            )
        }
    }
}
