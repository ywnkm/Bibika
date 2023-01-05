package com.elouyi.bbk

import com.elouyi.bbk.app.BiliAPP
import com.elouyi.bbk.app.BiliAPPConfig
import com.elouyi.bbk.app.BiliAPPFactory
import com.elouyi.bbk.utils.BBKInternalAPI
import com.elouyi.bbk.utils.getDep
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.websocket.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.serialization.kotlinx.protobuf.*
import kotlinx.coroutines.job
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.module

public fun <T : BiliAPPConfig> Bibika(
    factory: BiliAPPFactory<T>,
    block: BBKConfig<T>.() -> Unit = {}
): Bibika {
    val config = BBKConfig<T>().apply(block)
    return Bibika(factory.create(), config)
}

public class Bibika(
    public val app: BiliAPP,
    internal val config: BBKConfig<out BiliAPPConfig>
) {

    public val attributes: BBKAttributes = BBKAttributes()

    init {
        config.install(this)
        @OptIn(BBKInternalAPI::class)
        app.install(this)
    }

    public suspend fun join() {
        app.coroutineContext.job.join()
    }

}

public val Bibika.client: HttpClient
    get() = getDep()

// clinit
@Suppress("Unused")
private val CL_INIT = run {
    val module = module {
        single {
            HttpClient(CIO) {
                install(ContentEncoding)
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    })
                    @OptIn(ExperimentalSerializationApi::class)
                    protobuf()
                }
                install(WebSockets) {

                }
            }
        }
        single {  }
    }
    startKoin {
        modules(module)
    }
}
