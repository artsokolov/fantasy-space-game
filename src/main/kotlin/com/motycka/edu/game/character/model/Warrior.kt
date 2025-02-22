package com.motycka.edu.game.character.model

class Warrior(
    override var id: CharacterId? = null,
    override val name: String,
    override val health: Int,
    override val attackPower: Int,
    override val level: Int,
    override val experience: Int,
    override val stamina: Int,
    override val defensePower: Int,
): Character(
    id = id,
    name = name,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience,
    stamina = stamina,
    defensePower = defensePower,
    accountId = 1
)