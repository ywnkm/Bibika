package com.elouyi.bbk.common.data

public interface BiliResponse<out T : Any> {
    public val code: Int
    public val message: String
    public val ttl: Int
    public val data: T?
}
