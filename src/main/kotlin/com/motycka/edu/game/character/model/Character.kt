package com.motycka.edu.game.character.model

abstract class Character(
    open var id: CharacterId?,
    open var properties: CharacterProperties
) {
    abstract val type: CharacterType

    companion object {
        fun new(
            characterType: CharacterType,
            properties: CharacterProperties,
            id: CharacterId? = null
        ): Character {
            return when (characterType) {
                CharacterType.WARRIOR -> Warrior(id, properties)
                CharacterType.SORCERER -> Sorcerer(id, properties)
            }
        }
    }
}