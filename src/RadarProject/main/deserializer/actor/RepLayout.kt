@file:Suppress("NAME_SHADOWING")
package main.deserializer.actor

import main.info
import main.struct.Actor
import main.struct.Bunch
import main.struct.NetGuidCacheObject
import main.struct.cmd.CMD.processors

fun repl_layout_bunch(bunch: Bunch, repObj: NetGuidCacheObject?, actor: Actor) {
    val cmdProcessor = processors[repObj?.pathName ?: return] ?: return
    val bDoChecksum = bunch.readBit()
    val data = HashMap<String, Any?>()
    do {
        val waitingHandle = bunch.readIntPacked()
        info { ",<$waitingHandle>" }
    } while (waitingHandle > 0 && cmdProcessor(actor, bunch, repObj, waitingHandle, data) && bunch.notEnd())
}