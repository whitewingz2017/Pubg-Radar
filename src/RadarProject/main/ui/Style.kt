package main.ui

import com.badlogic.gdx.graphics.Color
import main.mapWidth

const val initialWindowWidth = 1000f
const val windowToMapUnit = mapWidth / initialWindowWidth
const val runSpeed = 6.3 * 100 //6.3m/s
const val visionRadius = mapWidth / 4
const val attackLineDuration = 1000
const val directionRadius = 16000f
const val attackMeLineDuration = 10000
const val pinRadius = 4000f
const val healthBarWidth = 15000f
const val healthBarHeight = 2000f
const val playerRadius = 4000f
const val corpseRadius = 150f
const val itemRadius = 100f

//Aordp
const val airDropRadius = 4000f

//Player Edge
val playerEdgeColor = Color(0.9f, 0.1f, 0.1f, 0.8f)
val teamEdgeColor = Color(1f, 1f, 0f, 0.8f)  //yello

val safeDirectionColor = Color(0.12f, 0.56f, 1f, 0.5f)
val visionColor = Color(1f, 1f, 1f, 0.1f)
val attackLineColor = Color(1.0f, 0f, 0f, 1f)
val pinColor = Color(1f, 1f, 0f, 1f)
val redZoneColor = Color(1f, 0f, 0f, 0.2f)
val safeZoneColor = Color(1f, 1f, 1f, 0.5f)
val selfColor = Color(0x32cd32ff)