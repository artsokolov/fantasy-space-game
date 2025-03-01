package com.motycka.edu.game.character

import com.motycka.edu.game.account.model.AccountId
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
    fun createCharacter(
        request: CreateCharacterRequest,
        accountId: AccountId
    ): CharacterResponse {
        val character = factory.newCharacter(request, accountId)

        return character.apply {
            id = repository.create(character)
        }.toResponse(accountId)
    }

    fun listCharacters(id: AccountId): List<CharacterResponse> {
        return repository.all {
            it.toResponse(id)
        }
    }
}
