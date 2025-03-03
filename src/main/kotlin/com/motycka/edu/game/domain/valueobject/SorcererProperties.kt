package com.motycka.edu.game.domain.valueobject

import com.motycka.edu.game.account.model.AccountId

class SorcererProperties(
    name: String,
    accountId: AccountId,
    health: Int,
    attackPower: Int,
    level: Int,
    experience: Int,
    var mana: Int,
    var healingPower: Int
): CharacterProperties(
    name = name,
    accountId = accountId,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience
)