package com.motycka.edu.game.character.database

import com.motycka.edu.game.domain.entity.AnyCharacter
import com.motycka.edu.game.domain.entity.Character
import com.motycka.edu.game.domain.valueobject.SorcererProperties
import com.motycka.edu.game.domain.valueobject.WarriorProperties
import com.motycka.edu.game.generated.tables.records.GameCharacterRecord

fun AnyCharacter.toRecord(): GameCharacterRecord = when(properties) {
    is WarriorProperties -> GameCharacterRecord(
        id = id,
        accountId = properties.accountId,
        name = properties.name,
        `class` = type.value,
        health = properties.health,
        attack = properties.attackPower,
        experience = properties.experience,
        defense = properties.defensePower,
        stamina = properties.stamina,
    )
    is SorcererProperties -> GameCharacterRecord(
        id = id,
        accountId = properties.accountId,
        name = properties.name,
        `class` = type.value,
        health = properties.health,
        attack = properties.attackPower,
        experience = properties.experience,
        healing = properties.healingPower,
        mana = properties.mana
    )
}