package com.motycka.edu.game.character.rest.response

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.domain.entity.AnyCharacter
import com.motycka.edu.game.domain.entity.Character
import com.motycka.edu.game.domain.valueobject.SorcererProperties
import com.motycka.edu.game.domain.valueobject.WarriorProperties

fun AnyCharacter.toResponse(curAccountId: AccountId): CharacterResponse = when(properties) {
    is WarriorProperties -> CharacterResponse(
        id = requireNotNull(id) { "Id should not be null" },
        name = properties.name,
        health = properties.health,
        attackPower = properties.attackPower,
        level = properties.level,
        experience = properties.experience,
        isOwner = curAccountId == properties.accountId,
        stamina = properties.stamina,
        defensePower = properties.defensePower,
        characterClass = type
    )
    is SorcererProperties -> CharacterResponse(
        id = requireNotNull(id) { "Id should not be null" },
        name = properties.name,
        health = properties.health,
        attackPower = properties.attackPower,
        level = properties.level,
        experience = properties.experience,
        isOwner = curAccountId == properties.accountId,
        mana = properties.mana,
        healingPower = properties.healingPower,
        characterClass = type
    )
}