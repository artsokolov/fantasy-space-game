package com.motycka.edu.game.character

import com.motycka.edu.game.character.database.toRecord
import org.jooq.DSLContext
import org.jooq.exception.DataException
import org.springframework.stereotype.Repository
import kotlin.jvm.Throws
import com.motycka.edu.game.character.exception.CharacterCreationError
import com.motycka.edu.game.character.exception.CharacterNotFoundException
import com.motycka.edu.game.domain.entity.AnyCharacter
import com.motycka.edu.game.domain.entity.CharacterId
import com.motycka.edu.game.generated.tables.GameCharacter
import com.motycka.edu.game.domain.repository.CharacterRepositoryInterface
import com.motycka.edu.game.shared.Criteria

@Repository
class CharacterRepository(
    private val dsl: DSLContext,
    private val factory: CharacterFactory
): CharacterRepositoryInterface {

    @Throws(DataException::class)
    override fun create(character: AnyCharacter): CharacterId {
        return dsl.insertInto(GameCharacter.GAME_CHARACTER)
            .set(character.toRecord())
            .returningResult(GameCharacter.GAME_CHARACTER.ID)
            .fetchOne()
            ?.into(Long::class.java) ?: throw CharacterCreationError("Error during character creation")
    }

    override fun <T>findBy(
        vararg filters: Criteria,
        converter: (AnyCharacter) -> T
    ): List<T> {
        return dsl.selectFrom(GameCharacter.GAME_CHARACTER)
            .where(
                filters.map { it.toCondition() }
            ).fetch { record ->
                val character = factory.restoreCharacter(record)

                converter(character)
            }
    }

    @Throws(CharacterNotFoundException::class)
    override fun find(id: CharacterId): AnyCharacter {
        return dsl.selectFrom(GameCharacter.GAME_CHARACTER)
            .where(GameCharacter.GAME_CHARACTER.ID.eq(id))
            .fetchOne()
            ?.let { factory.restoreCharacter(it) }
            ?: throw CharacterNotFoundException("Character with id $id not found")
    }

    override fun update(id: CharacterId, character: AnyCharacter) {
        dsl.update(TABLE)
            .set(character.toRecord())
            .where(GameCharacter.GAME_CHARACTER.ID.eq(id))
            .execute()
    }

    companion object {
        private val TABLE = GameCharacter.GAME_CHARACTER
    }
}