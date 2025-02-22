package com.motycka.edu.game.character

import com.motycka.edu.game.character.exception.UnknownCharacterClass
import com.motycka.edu.game.character.model.Character
import com.motycka.edu.game.character.model.Sorcerer
import com.motycka.edu.game.character.model.Warrior
import com.motycka.edu.game.character.rest.request.CreateCharacterRequest
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class CharacterFactory {

    @Throws(UnknownCharacterClass::class)
    fun newCharacter(request: CreateCharacterRequest): Character {
        return when (request.characterClass) {
            "WARRIOR" -> Warrior(
                name = request.name,
                health = request.health,
                attackPower = request.attackPower,
                level = 1,
                experience = 0,
                stamina = requireNotNull(request.stamina) { "Stamina should be defined" },
                defensePower = requireNotNull(request.defensePower) { "Defense power should be defined" }
            )
            "SORCERER" -> Sorcerer(
                name = request.name,
                health = request.health,
                attackPower = request.attackPower,
                level = 1,
                experience = 0,
                mana = requireNotNull(request.mana) { "Mana should not be null" },
                healingPower = requireNotNull(request.healingPower) { "Healing power should not be null" }
            )
            else -> throw UnknownCharacterClass()
        }
    }
}