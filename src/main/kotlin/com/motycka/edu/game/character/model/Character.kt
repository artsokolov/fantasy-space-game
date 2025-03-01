package com.motycka.edu.game.character.model

abstract class Character(
    open var id: CharacterId?,
    open val properties: CharacterProperties
) {
    abstract val type: CharacterType

    companion object {
        fun new(
            characterType: CharacterType,
            properties: CharacterProperties,
            id: CharacterId? = null
        ): Character {
            return when (characterType) {
                CharacterType.WARRIOR -> Warrior(id, properties).apply {
                    requireNotNull(properties.stamina) { "Stamina should be defined" }
                    requireNotNull(properties.defensePower) { "Defense power should be defined" }
                }
                CharacterType.SORCERER -> Sorcerer(id, properties).apply {
                    requireNotNull(properties.mana) { "Mana should not be null" }
                    requireNotNull(properties.healingPower) { "Healing power should not be null" }
                }
            }
        }
    }
}