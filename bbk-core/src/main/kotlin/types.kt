package com.elouyi.bbk

public typealias BBKAttributes = io.ktor.util.Attributes

public typealias BBKAttributeKey<T> = io.ktor.util.AttributeKey<T>

@Suppress("Invisible_Member", "Invisible_Reference")
@kotlin.internal.InlineOnly
public inline fun BBKAttributes(concurrent: Boolean = false): BBKAttributes = io.ktor.util.Attributes(concurrent)


/**
 * @see [io.ktor.client.plugins.HttpClientPlugin]
 */
public interface BBKPlugin<out Config : Any, Plugin : Any> {

    public val key: BBKAttributeKey<Plugin>

    public fun prepare(block: Config.() -> Unit = {}): Plugin


    public fun install(plugin: Plugin, scope: Bibika)
}
