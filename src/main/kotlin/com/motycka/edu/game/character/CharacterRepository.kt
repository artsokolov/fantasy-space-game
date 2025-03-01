package com.motycka.edu.game.character

import com.motycka.edu.game.character.database.toRecord
import com.motycka.edu.game.character.model.Character
import org.jooq.DSLContext
import org.jooq.exception.DataException
import org.springframework.stereotype.Repository
import kotlin.jvm.Throws
import com.motycka.edu.game.character.exception.CharacterCreationError
import com.motycka.edu.game.character.model.CharacterId
import com.motycka.edu.game.generated.tables.GameCharacter

@Repository
class CharacterRepository(
    private val dsl: DSLContext,
    private val factory: CharacterFactory
) {

    @Throws(DataException::class)
    fun create(character: Character): CharacterId {
        return dsl.insertInto(GameCharacter.GAME_CHARACTER)
            .set(character.toRecord())
            .returningResult(GameCharacter.GAME_CHARACTER.ID)
            .fetchOne()
            ?.into(Long::class.java) ?: throw CharacterCreationError("Error during character creation")
    }

    fun <T>all(converter: (Character) -> T): List<T> {
        return dsl.selectFrom(GameCharacter.GAME_CHARACTER).fetch { record ->
            val character = factory.restoreCharacter(record)

            converter(character)
        }
    }
}