package com.motycka.edu.game.character.model

import com.motycka.edu.game.account.model.AccountId

abstract class Character(
    open var id: CharacterId?,
    open val name: String,
    open val accountId: AccountId,
    open val health: Int,
    open val attackPower: Int,
    open val level: Int,
    open val experience: Int,
    open val mana: Int? = null,
    open val healingPower: Int? = null,
    open val stamina: Int? = null,
    open val defensePower: Int? = null,
)