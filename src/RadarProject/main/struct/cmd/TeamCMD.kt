@file:Suppress("NAME_SHADOWING")

package main.struct.cmd

import main.GameListener
import main.bugln
import main.register
import main.struct.Actor
import main.struct.Bunch
import main.struct.*
import main.struct.cmd.CMD.propertyString
import main.struct.cmd.CMD.propertyVector100
import java.util.concurrent.ConcurrentHashMap


object TeamCMD : GameListener {
    val team = ConcurrentHashMap<String, String>()

    init {
        register(this)
    }

    override fun onGameOver() {
        team.clear()
    }

    fun process(actor: Actor, bunch: Bunch, repObj: NetGuidCacheObject?, waitingHandle: Int, data: HashMap<String, Any?>): Boolean {
        with(bunch) {
            //      println("${actor.netGUID} $waitingHandle")
            when (waitingHandle) {
                5 -> {
                    val (netGUID, obj) = readObject()
                    actor.owner = if (netGUID.isValid()) netGUID else null
                    bugln { " owner: [$netGUID] $obj ---------> beOwned:$actor" }
                }
                16 -> {
                    val playerLocation = propertyVector100()
                }
                17 -> {
                    val playerRotation = readRotationShort()
                }
                18 -> {
                    val playerName = propertyString()
                    team[playerName] = playerName
                }
                else -> return false
            }
            return true
        }
    }
}