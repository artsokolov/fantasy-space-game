package com.motycka.edu.game.domain.valueobject

import com.motycka.edu.game.account.model.AccountId

class WarriorProperties(
    name: String,
    accountId: AccountId,
    health: Int,
    attackPower: Int,
    level: Int,
    experience: Int,
    var stamina: Int,
    var defensePower: Int,
): CharacterProperties(
    name = name,
    accountId = accountId,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience
)