package com.elouyi.bbk.plugins.live.data

import com.elouyi.bbk.common.data.BiliResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DanmuInfoData(
    override val code: Int,
    override val message: String,
    override val ttl: Int,
    override val data: Data?
) : BiliResponse<DanmuInfoData.Data> {

    @Serializable
    public data class Data(
        val group: String,
        @SerialName("business_id")
        val businessId: Int,
        @SerialName("refresh_row_factor")
        val refreshRowFactor: Double,
        @SerialName("refresh_rate")
        val refreshRate: Int,
        @SerialName("max_delay")
        val maxDelay: Int,
        val token: String,
        @SerialName("host_list")
        val hostList: List<Host>
    ) {
        @Serializable
        public data class Host(
            val host: String,
            val port: Int,
            @SerialName("wss_port")
            val wssPort: Int,
            @SerialName("ws_port")
            val wsPort: Int
        )
    }
}
