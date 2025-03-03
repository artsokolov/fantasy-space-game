package com.motycka.edu.game.domain.repository

import com.motycka.edu.game.character.exception.CharacterNotFoundException
import com.motycka.edu.game.domain.entity.AnyCharacter
import com.motycka.edu.game.domain.entity.Character
import com.motycka.edu.game.domain.entity.CharacterId
import com.motycka.edu.game.shared.Criteria
import org.jooq.exception.DataException

interface CharacterRepositoryInterface {

    @Throws(DataException::class)
    fun create(character: AnyCharacter): CharacterId

    fun <T> findBy(vararg filters: Criteria, converter: (AnyCharacter) -> T): List<T>

    @Throws(CharacterNotFoundException::class)
    fun find(id: CharacterId): AnyCharacter

    fun update(id: CharacterId, character: AnyCharacter)
}
