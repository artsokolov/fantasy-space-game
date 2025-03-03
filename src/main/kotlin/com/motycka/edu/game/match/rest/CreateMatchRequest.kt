package com.motycka.edu.game.match.rest

data class CreateMatchRequest(
    val rounds: Int,
    val challengerId: Long,
    val opponentId: Long
)