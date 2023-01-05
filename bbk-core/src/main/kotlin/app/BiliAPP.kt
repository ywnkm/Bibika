package com.elouyi.bbk.app

import com.elouyi.bbk.BBKAttributes
import com.elouyi.bbk.Bibika
import com.elouyi.bbk.utils.BBKInternalAPI
import io.ktor.utils.io.core.*
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import mu.KLogger
import mu.KotlinLogging
import kotlin.coroutines.CoroutineContext

public interface BiliAPP : CoroutineScope, Closeable {

    public val name: String

    public val isAndroid: Boolean get() = false

    public val isIOS: Boolean get() = false

    public val isAPP: Boolean get() = isAndroid or isIOS

    public val isWeb: Boolean get() = !isAPP

    public val config: BiliAPPConfig

    public val attributes: BBKAttributes

    public val logger: KLogger

    @BBKInternalAPI
    public fun install(bbk: Bibika)
}

@OptIn(BBKInternalAPI::class)
public abstract class AbstractBiliAPP(
    final override val name: String
) : BiliAPP {

    override val coroutineContext: CoroutineContext = SupervisorJob() + CoroutineName(name)

    override val logger: KLogger = KotlinLogging.logger(name)

    override fun install(bbk: Bibika) {

    }

    override fun close() {
        coroutineContext[Job]?.let {
            it.children.forEach(Job::cancel)
            it.cancel()
        }
    }
}
