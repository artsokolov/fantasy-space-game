package com.motycka.edu.game.character.model

class Sorcerer(
    override var id: CharacterId? = null,
    properties: CharacterProperties
): Character(id = id, properties = properties) {
    override val type: CharacterType = CharacterType.SORCERER

    override var properties: CharacterProperties = properties
        set(value) {
            requireNotNull(value.mana) { "Mana should not be null" }
            requireNotNull(value.healingPower) { "Healing power should not be null" }
            field = value
        }

    init {
        requireNotNull(properties.mana) { "Mana should not be null" }
        requireNotNull(properties.healingPower) { "Healing power should not be null" }
    }
}