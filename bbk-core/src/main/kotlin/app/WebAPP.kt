package com.elouyi.bbk.app

import com.elouyi.bbk.BBKAttributes
import com.elouyi.bbk.Bibika

public class WebAPP(
    override val config: WebAPPConfig
) : AbstractBiliAPP("Web") {

    private lateinit var bbk: Bibika

    override val attributes: BBKAttributes
        get() = bbk.attributes


    override fun install(bbk: Bibika) {
        logger.trace { "WebAPP install Bibika." }
        this.bbk = bbk
        super.install(bbk)
    }

    override fun close() {
        super.close()
        logger.info { "$this closed." }
    }

    public companion object : BiliAPPFactory<WebAPPConfig> {
        override fun create(block: WebAPPConfig.() -> Unit): BiliAPP {
            val config = WebAPPConfig().also(block)
            return WebAPP(config)
        }
    }
}
