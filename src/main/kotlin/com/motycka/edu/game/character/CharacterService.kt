package com.motycka.edu.game.character

import com.motycka.edu.game.character.exception.UnknownCharacterClass
import com.motycka.edu.game.character.rest.request.CreateCharacterRequest
import com.motycka.edu.game.character.rest.response.CharacterResponse
import com.motycka.edu.game.character.rest.response.toResponse
import org.jooq.exception.DataException
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class CharacterService(
    private val repository: CharacterRepository,
    private val factory: CharacterFactory
) {

    @Throws(UnknownCharacterClass::class, DataException::class)
    fun createCharacter(request: CreateCharacterRequest): CharacterResponse {
        val character = factory.newCharacter(request)

        return repository.create(character).toResponse()
    }
}
