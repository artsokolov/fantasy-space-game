package com.motycka.edu.game.match.model

import com.motycka.edu.game.domain.entity.AnyCharacter

class Match(
    private val rounds: Int,
    private val challenger: AnyCharacter,
    private val opponent: AnyCharacter
) {
    private fun round(): AnyCharacter {
        val chance = (1..100).random()

        return if (chance <= 50) challenger else opponent
    }

    fun fight(): AnyCharacter {
        val scores = mutableMapOf(
            challenger to 0,
            opponent to 0
        )

        repeat(rounds) {
            challenger.beforeRounds()
            opponent.beforeRounds()

            val winner = round()
            scores[winner] = scores.getValue(winner) + 1

            challenger.afterRound()
            opponent.afterRound()
        }

        return when {
            scores[challenger]!! >= scores[opponent]!! -> challenger
            else -> opponent
        }
    }
}