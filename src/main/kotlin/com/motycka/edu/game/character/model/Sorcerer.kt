package com.motycka.edu.game.character.model

class Sorcerer(
    override var id: CharacterId? = null,
    override val name: String,
    override val health: Int,
    override val attackPower: Int,
    override val level: Int,
    override val experience: Int,
    override val mana: Int,
    override val healingPower: Int
): Character(
    id = id,
    name = name,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience,
    mana = mana,
    healingPower = healingPower,
    accountId = 1
)