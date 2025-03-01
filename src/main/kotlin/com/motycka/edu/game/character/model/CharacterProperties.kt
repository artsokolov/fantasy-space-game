package com.motycka.edu.game.character.model

import com.motycka.edu.game.account.model.AccountId

data class CharacterProperties(
    val name: String,
    val accountId: AccountId,
    val health: Int,
    val attackPower: Int,
    val level: Int,
    val experience: Int,
    val mana: Int? = null,
    val healingPower: Int? = null,
    val stamina: Int? = null,
    val defensePower: Int? = null,
)