package com.motycka.edu.game.character

import com.motycka.edu.game.character.model.Character
import org.jooq.DSLContext
import org.jooq.exception.DataException
import org.jooq.impl.DSL
import org.springframework.stereotype.Repository
import kotlin.jvm.Throws

@Repository
class CharacterRepository(
    private val dsl: DSLContext
) {

    @Throws(DataException::class)
    fun create(character: Character): Character {
        dsl.insertInto(TABLE)
            .columns(
                DSL.field("account_id"),
                DSL.field("name"),
                DSL.field("class"),
                DSL.field("health"),
                DSL.field("attack"),
                DSL.field("experience"),
                DSL.field("defense"),
                DSL.field("stamina"),
                DSL.field("healing"),
                DSL.field("mana"),
            ).values(
                character.accountId,
                character.name,
                character::class.toString().uppercase(),
                character.health,
                character.attackPower,
                character.experience,
                character.defensePower,
                character.stamina,
                character.healingPower,
                character.mana
            )
            .returningResult(TABLE.field("id"))
            .execute()

        character.id = dsl.lastID().longValueExact()

        return character
    }

    companion object {
        val TABLE = DSL.table("game_character")
    }
}