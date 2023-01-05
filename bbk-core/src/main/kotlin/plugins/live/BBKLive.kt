package com.elouyi.bbk.plugins.live

import com.elouyi.bbk.BBKAttributeKey
import com.elouyi.bbk.BBKPlugin
import com.elouyi.bbk.Bibika
import com.elouyi.bbk.plugins.live.data.event.LiveEvent
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

public class BBKLive internal constructor(
    internal val config: Config
) {

    internal lateinit var bbk: Bibika
    internal lateinit var api: LiveAPI

    public class Config

    public companion object Plugin : BBKPlugin<Config, BBKLive> {

        override val key: BBKAttributeKey<BBKLive> = BBKAttributeKey("BBKLive")

        override fun prepare(block: Config.() -> Unit): BBKLive {
            val config = Config().also(block)
            return BBKLive(config)
        }

        override fun install(plugin: BBKLive, scope: Bibika) {
            plugin.bbk = scope
            plugin.api = LiveAPI(plugin)
        }
    }
}

public val Bibika.live: LiveAPI
    get() = this.attributes[BBKLive.key].api

public suspend inline fun <reified E : LiveEvent> Bibika.liveEvent(
    roomId: Long,
    context: CoroutineContext = EmptyCoroutineContext,
    noinline block: suspend (E) -> Unit
): Job = this.live.liveEvent(roomId, context, block)
