package com.motycka.edu.game.character.model

import com.motycka.edu.game.account.model.AccountId

class Sorcerer(
    override var id: CharacterId? = null,
    override val name: String,
    override val health: Int,
    override val attackPower: Int,
    override val level: Int,
    override val experience: Int,
    override val mana: Int,
    override val healingPower: Int,
    override val accountId: AccountId
): Character(
    id = id,
    name = name,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience,
    mana = mana,
    healingPower = healingPower,
    accountId = accountId
)