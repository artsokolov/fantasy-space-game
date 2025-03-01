package com.motycka.edu.game.character.model

class Warrior(
    override var id: CharacterId? = null,
    override val properties: CharacterProperties
): Character(id = id, properties = properties) {
    override val type: CharacterType = CharacterType.WARRIOR
}