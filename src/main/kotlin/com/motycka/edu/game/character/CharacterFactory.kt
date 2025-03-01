package com.motycka.edu.game.character

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.character.exception.UnknownCharacterClass
import com.motycka.edu.game.character.model.*
import com.motycka.edu.game.character.rest.request.CreateCharacterRequest
import com.motycka.edu.game.character.rest.request.toProperties
import com.motycka.edu.game.generated.tables.records.GameCharacterRecord
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class CharacterFactory {

    @Throws(UnknownCharacterClass::class)
    fun newCharacter(request: CreateCharacterRequest, accountId: AccountId): Character {
        val type = CharacterType.valueOf(request.characterClass)

        return Character.new(
            characterType = type,
            properties = request.toProperties(accountId)
        )
    }

    fun restoreCharacter(record: GameCharacterRecord): Character {
        val properties = CharacterProperties(
            stamina = record.stamina,
            defensePower = record.defense,
            mana = record.mana,
            healingPower = record.healing,
            name = requireNotNull(record.name) { "Name should not be null" },
            health = requireNotNull(record.health) { "Health should not be null" },
            experience = requireNotNull(record.experience) { "Experience should not be null" },
            accountId = requireNotNull(record.accountId) { "Account id should not be null" },
            attackPower = requireNotNull(record.attack) { "Attack should not be null" },
            level = 1
        )

        val characterClass = requireNotNull(record.`class`) { "Character class should not be null" }

        return Character.new(
            characterType = CharacterType.valueOf(characterClass),
            properties = properties,
            id = record.id
        )
    }
}