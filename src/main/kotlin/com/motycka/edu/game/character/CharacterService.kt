package com.motycka.edu.game.character

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.character.exception.UnknownCharacterClass
import com.motycka.edu.game.character.model.CharacterId
import com.motycka.edu.game.character.rest.request.CreateCharacterRequest
import com.motycka.edu.game.character.rest.response.CharacterResponse
import com.motycka.edu.game.character.rest.response.toResponse
import com.motycka.edu.game.generated.tables.GameCharacter
import com.motycka.edu.game.shared.EqualsCriteria
import com.motycka.edu.game.shared.NotEqualsCriteria
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

    fun listCharacters(
        id: AccountId,
        name: String?,
        characterClass: String?
    ): List<CharacterResponse> {
        // TODO("Make validation for name and characterClass")

        return repository.findBy(
            EqualsCriteria(GameCharacter.GAME_CHARACTER.NAME, name),
            EqualsCriteria(GameCharacter.GAME_CHARACTER.CLASS, characterClass)
        ) {
            it.toResponse(id)
        }
    }

    fun findCharacter(id: CharacterId, accountId: AccountId): CharacterResponse {
        return repository.find(id).toResponse(accountId)
    }

    fun findChallengers(accountId: AccountId): List<CharacterResponse> {
        return repository.findBy(
            EqualsCriteria(GameCharacter.GAME_CHARACTER.ACCOUNT_ID, accountId)
        ) {
            it.toResponse(accountId)
        }
    }

    fun findOpponents(id: AccountId): List<CharacterResponse> {
        return repository.findBy(
            NotEqualsCriteria(GameCharacter.GAME_CHARACTER.ACCOUNT_ID, id)
        ) { it.toResponse(id) }
    }
}
