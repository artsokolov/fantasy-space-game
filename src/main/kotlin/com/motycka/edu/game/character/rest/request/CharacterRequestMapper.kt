package com.motycka.edu.game.character.rest.request

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.character.model.CharacterProperties

fun CreateCharacterRequest.toProperties(
    accountId: AccountId
): CharacterProperties = CharacterProperties(
    name = name,
    health = health,
    attackPower = attackPower,
    level = 1,
    experience = 0,
    mana = mana,
    healingPower = healingPower,
    accountId = accountId,
    defensePower = defensePower,
    stamina = stamina
)