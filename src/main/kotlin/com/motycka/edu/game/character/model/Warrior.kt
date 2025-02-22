package com.motycka.edu.game.character.model

import com.motycka.edu.game.account.model.AccountId

class Warrior(
    override var id: CharacterId? = null,
    override val name: String,
    override val health: Int,
    override val attackPower: Int,
    override val level: Int,
    override val experience: Int,
    override val stamina: Int,
    override val defensePower: Int,
    override val accountId: AccountId
): Character(
    id = id,
    name = name,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience,
    stamina = stamina,
    defensePower = defensePower,
    accountId = accountId
)