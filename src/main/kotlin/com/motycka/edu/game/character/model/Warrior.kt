package com.motycka.edu.game.character.model

class Warrior(
    override var id: CharacterId? = null,
    properties: CharacterProperties
): Character(id = id, properties = properties) {
    override val type: CharacterType = CharacterType.WARRIOR

    override var properties: CharacterProperties = properties
        set(value) {
            requireNotNull(value.stamina) { "Stamina should be defined" }
            requireNotNull(value.defensePower) { "Defense power should be defined" }
            field = value
        }

    init {
        requireNotNull(properties.stamina) { "Stamina should be defined" }
        requireNotNull(properties.defensePower) { "Defense power should be defined" }
    }
}