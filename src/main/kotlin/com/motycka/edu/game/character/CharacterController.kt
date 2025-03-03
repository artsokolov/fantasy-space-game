package com.motycka.edu.game.character

import com.motycka.edu.game.domain.entity.CharacterId
import com.motycka.edu.game.character.rest.request.CreateCharacterRequest
import com.motycka.edu.game.character.rest.request.UpdateCharacterRequest
import com.motycka.edu.game.config.AccountDetails
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.lang.Nullable
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


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
        @AuthenticationPrincipal account: AccountDetails,
        @RequestParam @Nullable characterClass: String? = null,
        @RequestParam @Nullable name: String? = null
    ): ResponseEntity<Any> {
        val response = service.listCharacters(account.id, name, characterClass)

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping("/{id}")
    fun getCharacter(
        @AuthenticationPrincipal account: AccountDetails,
        @PathVariable id: CharacterId
    ): ResponseEntity<Any> {
        val response = service.findCharacter(id, account.id)

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping("/challengers")
    fun getChallengers(
        @AuthenticationPrincipal account: AccountDetails
    ): ResponseEntity<Any> {
        val response = service.findChallengers(account.id)

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping("/opponents")
    fun getOpponents(
        @AuthenticationPrincipal account: AccountDetails
    ): ResponseEntity<Any> {
        val response = service.findOpponents(account.id)

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @PutMapping("/{id}")
    fun putCharacter(
        @PathVariable id: CharacterId,
        @RequestBody request: UpdateCharacterRequest,
    ): ResponseEntity<Any> {
        service.updateCharacter(id, request)

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}
