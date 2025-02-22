package com.motycka.edu.game.character.rest.request

import com.motycka.edu.game.account.model.AccountId

data class CreateCharacterRequest(
    val name: String,
    val health: Int,
    val attackPower: Int,
    val characterClass: String,
    val stamina: Int?,
    val defensePower: Int?,
    val mana: Int?,
    val healingPower: Int?,
    val accountId: AccountId?
)
