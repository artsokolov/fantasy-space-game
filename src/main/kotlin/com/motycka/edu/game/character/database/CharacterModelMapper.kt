package com.motycka.edu.game.character.database

import com.motycka.edu.game.character.model.Character
import com.motycka.edu.game.generated.tables.records.GameCharacterRecord

fun Character.toRecord(): GameCharacterRecord = GameCharacterRecord(
    id = this.id,
    accountId = this.properties.accountId,
    name = this.properties.name,
    `class` = this.type.value,
    health = this.properties.health,
    attack = this.properties.attackPower,
    experience = this.properties.experience,
    defense = this.properties.defensePower,
    stamina = this.properties.stamina,
    healing = this.properties.healingPower,
    mana = this.properties.mana
)