package com.motycka.edu.game.character.rest.response

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.character.model.Character

fun Character.toResponse(curAccountId: AccountId) = CharacterResponse(
    id = requireNotNull(id) { "Id should not be null" },
    name = name,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience,
    isOwner = curAccountId == this.accountId,
    mana = mana,
    healingPower = healingPower,
    stamina = stamina,
    defensePower = defensePower
)