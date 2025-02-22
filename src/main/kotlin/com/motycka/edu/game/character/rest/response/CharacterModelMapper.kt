package com.motycka.edu.game.character.rest.response

import com.motycka.edu.game.character.model.Character

fun Character.toResponse() = CharacterResponse(
    id = requireNotNull(id) { "Id should not be null" },
    name = name,
    accountId = accountId,
    health = health,
    attackPower = attackPower,
    level = level,
    experience = experience,
    mana = mana,
    healingPower = healingPower,
    stamina = stamina,
    defensePower = defensePower
)