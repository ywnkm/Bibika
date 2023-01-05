package com.elouyi.bbk.plugins.live.data.event

import com.elouyi.bbk.utils.hexToString
import kotlin.reflect.KClass

public interface LiveEvent {

    public open class Unknown(
        public val data: ByteArray
    ) : LiveEvent {

        override fun toString(): String {
            return buildString {
                append("Unknown live event: ")
                append(data.hexToString(0x10))
            }
        }
    }

    public interface CMDEvent : LiveEvent {
        public val cmd: String

        public sealed interface CMDEventHelper<E : CMDEvent> {
            public val kClass: KClass<E>
            public val cmd: String
        }

        public class UnknownCMDEvent(
            data: ByteArray,
            public val content: String
        ) : Unknown(data), CMDEvent {
            override val cmd: String = "Unknown CMD Event."

            override fun toString(): String {
                return "Unknown CMD Event.\n$content"
            }
        }

        public companion object {

            private val cmds: List<CMDEventHelper<*>> =
                CMDEventHelper::class.sealedSubclasses.map { it.objectInstance!! }

            public operator fun get(cmd: String): KClass<out CMDEvent>  {
                return cmds.find { it.cmd == cmd }?.kClass ?: UnknownCMDEvent::class
            }
        }
    }
}
