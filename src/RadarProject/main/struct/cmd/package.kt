@file:Suppress("NAME_SHADOWING")
package main.struct.cmd

import com.badlogic.gdx.math.*
import main.struct.Archetype.Plane
import main.struct.Actor
import main.struct.Archetype
import main.struct.*
import main.struct.Archetype.*
import main.struct.Bunch
import main.struct.cmd.TeamCMD
import java.util.*

typealias cmdProcessor = (Actor, Bunch, NetGuidCacheObject?, Int, HashMap<String, Any?>) -> Boolean


object CMD {
    fun Bunch.propertyBool() = readBit()
    fun Bunch.propertyFloat() = readFloat()
    fun Bunch.propertyInt() = readInt32()
    fun Bunch.propertyByte() = readByte()
    fun Bunch.propertyName() = readName()
    fun Bunch.propertyObject() = readObject()
    fun Bunch.propertyVector() = Vector3(readFloat(), readFloat(), readFloat())
    fun Bunch.propertyRotator() = Vector3(readFloat(), readFloat(), readFloat())
    fun Bunch.propertyVector100() = readVector(100, 30)
    fun Bunch.propertyVectorQ() = readVector(1, 20)
    fun Bunch.propertyVectorNormal() = readFixedVector(1, 16)
    fun Bunch.propertyVector10() = readVector(10, 24)
    fun Bunch.propertyUInt64() = readInt64()
    fun Bunch.propertyNetId() = if (readInt32() > 0) readString() else ""
    fun Bunch.repMovement(actor: Actor) {
        val bSimulatedPhysicSleep = readBit()
        val bRepPhysics = readBit()
        actor.location = if (actor.isAPawn)
            readVector(100, 30)
        else readVector(1, 24)

        actor.rotation = if (actor.isACharacter)
            readRotationShort()
        else readRotation()

        actor.velocity = readVector(1, 24)
        if (bRepPhysics)
            readVector(1, 24)
    }

    fun Bunch.propertyString() = readString()

    val processors = mapOf<String, cmdProcessor>(
            GameState.name to GameStateCMD::process,
            Other.name to APawnCMD::process,
            DroppedItem.name to DroppedItemCMD::process,
            DroopedItemGroup.name to APawnCMD::process,
            Grenade.name to APawnCMD::process,
            TwoSeatBoat.name to APawnCMD::process,
            SixSeatBoat.name to APawnCMD::process,
            TwoSeatCar.name to APawnCMD::process,
            ThreeSeatCar.name to APawnCMD::process,
            TwoSeatBike.name to APawnCMD::process,
            FourSeatP.name to APawnCMD::process,
            FourSeatDU.name to APawnCMD::process,
            SixSeatCar.name to APawnCMD::process,
            Plane.name to APawnCMD::process,
            Player.name to ActorCMD::process,
            Parachute.name to APawnCMD::process,
            AirDrop.name to APawnCMD::process,
            PlayerState.name to PlayerStateCMD::process,
            Team.name to TeamCMD::process,
            "DroppedItemGroupRootComponent" to DroppedItemGroupRootComponentCMD::process,
            "DroppedItemInteractionComponent" to DroppedItemInteractionComponentCMD::process,
            WeaponProcessor.name to WeaponProcessorCMD::process
    )
}
