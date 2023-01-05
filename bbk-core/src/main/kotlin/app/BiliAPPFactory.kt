package com.elouyi.bbk.app

public interface BiliAPPFactory<out Config : BiliAPPConfig> {

    public fun create(block: Config.() -> Unit = {}): BiliAPP
}
