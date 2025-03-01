package com.motycka.edu.game.character

import com.motycka.edu.game.character.exception.UnknownCharacterClass
import com.motycka.edu.game.character.rest.request.CreateCharacterRequest
import com.motycka.edu.game.config.AccountDetails
import com.motycka.edu.game.error.ErrorResponse
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * This is example of a controller class that handles HTTP requests for the account resource with service dependency injection.
 */
@RestController
@RequestMapping("/api/characters")
class CharacterController(
    private val service: CharacterService
) {
    @PostMapping
    fun postCharacter(
        @RequestBody request: CreateCharacterRequest,
        @AuthenticationPrincipal user: AccountDetails
    ): ResponseEntity<Any> {
        val response = service.createCharacter(request, user.id)

        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @GetMapping
    fun getCharacters(
        @AuthenticationPrincipal account: AccountDetails
    ): ResponseEntity<Any> {
        val response = service.listCharacters(account.id)

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}
