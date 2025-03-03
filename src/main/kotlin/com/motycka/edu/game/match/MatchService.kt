package com.motycka.edu.game.match

import com.motycka.edu.game.match.rest.CreateMatchRequest
import com.motycka.edu.game.domain.repository.CharacterRepositoryInterface

class MatchService(
    private val characters: CharacterRepositoryInterface
) {
    fun createMatch(req: CreateMatchRequest) {
        val opponent = characters.find(req.opponentId)
        val challenger = characters.find(req.challengerId)


    }
}