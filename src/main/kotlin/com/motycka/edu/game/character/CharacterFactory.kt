package com.motycka.edu.game.character

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.character.exception.UnknownCharacterClass
import com.motycka.edu.game.character.rest.request.CreateCharacterRequest
import com.motycka.edu.game.character.rest.request.toProperties
import com.motycka.edu.game.domain.entity.*
import com.motycka.edu.game.domain.valueobject.CharacterProperties
import com.motycka.edu.game.domain.valueobject.CharacterType
import com.motycka.edu.game.domain.valueobject.SorcererProperties
import com.motycka.edu.game.domain.valueobject.WarriorProperties
import com.motycka.edu.game.generated.tables.records.GameCharacterRecord
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class CharacterFactory {

    private fun createCharacter(
        properties: CharacterProperties,
        id: CharacterId? = null
    ): AnyCharacter {
        return when(properties) {
            is WarriorProperties -> Warrior(id, properties)
            is SorcererProperties -> Sorcerer(id, properties)
        }
    }

    @Throws(UnknownCharacterClass::class)
    fun newCharacter(request: CreateCharacterRequest, accountId: AccountId): AnyCharacter {
        val type = CharacterType.valueOf(request.characterClass)

        return createCharacter(
            properties = request.toProperties(type = type, accountId = accountId)
        )
    }

    fun restoreCharacter(record: GameCharacterRecord): AnyCharacter {
        val characterClass = requireNotNull(record.`class`) { "Character class should not be null" }
        val characterType = CharacterType.valueOf(characterClass)

        val properties = CharacterProperties.new(
            stamina = record.stamina,
            defensePower = record.defense,
            mana = record.mana,
            healingPower = record.healing,
            name = requireNotNull(record.name) { "Name should not be null" },
            health = requireNotNull(record.health) { "Health should not be null" },
            experience = requireNotNull(record.experience) { "Experience should not be null" },
            accountId = requireNotNull(record.accountId) { "Account id should not be null" },
            attackPower = requireNotNull(record.attack) { "Attack should not be null" },
            level = 1,
            type = characterType
        )

        return createCharacter(
            properties = properties,
            id = record.id
        )
    }
}