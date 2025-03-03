package com.motycka.edu.game.character.rest.request

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.domain.valueobject.CharacterProperties
import com.motycka.edu.game.domain.valueobject.CharacterType

fun CreateCharacterRequest.toProperties(
    accountId: AccountId,
    type: CharacterType
): CharacterProperties = CharacterProperties.new(
    name = name,
    health = health,
    attackPower = attackPower,
    level = 1,
    experience = 0,
    mana = mana,
    healingPower = healingPower,
    accountId = accountId,
    defensePower = defensePower,
    stamina = stamina,
    type = type
)