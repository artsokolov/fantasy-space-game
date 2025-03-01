package com.motycka.edu.game.character.rest.response

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.character.model.Character

fun Character.toResponse(curAccountId: AccountId) = CharacterResponse(
    id = requireNotNull(id) { "Id should not be null" },
    name = properties.name,
    health = properties.health,
    attackPower = properties.attackPower,
    level = properties.level,
    experience = properties.experience,
    isOwner = curAccountId == properties.accountId,
    mana = properties.mana,
    healingPower = properties.healingPower,
    stamina = properties.stamina,
    defensePower = properties.defensePower
)