package com.elouyi.bbk

import com.elouyi.bbk.app.BiliAPPConfig
import com.elouyi.bbk.utils.BBKDsl

public class BBKConfig<T : BiliAPPConfig> {

    private val features: MutableMap<BBKAttributeKey<*>, (Bibika) -> Unit> = mutableMapOf()
    private val featureConfigurations: MutableMap<BBKAttributeKey<*>, Any.() -> Unit> = mutableMapOf()

    internal var appConfig: T.() -> Unit = {}

    @BBKDsl
    public fun app(block: T.() -> Unit) {
        val old = appConfig
        appConfig = {
            old()
            block()
        }
    }

    @BBKDsl
    public fun <Builder : Any, Feature : Any> install(
        feature: BBKPlugin<Builder, Feature>,
        configure: Builder.() -> Unit = {}
    ) {
        val preConfigBlock = featureConfigurations[feature.key]
        featureConfigurations[feature.key] = {
            preConfigBlock?.invoke(this)
            @Suppress("UNCHECKED_CAST")
            (this as Builder).configure()
        }
        if (features.containsKey(feature.key)) return
        features[feature.key] = { bbk ->
            val attributes = bbk.attributes
            val config = bbk.config.featureConfigurations[feature.key]!!
            val featureData = feature.prepare(config)
            feature.install(featureData, bbk)
            attributes.put(feature.key, featureData)
        }
    }

    public fun install(bbk: Bibika) {
        @Suppress("UNCHECKED_CAST")
        (bbk.app.config as T).appConfig()
        features.values.forEach { it(bbk) }
    }
}
