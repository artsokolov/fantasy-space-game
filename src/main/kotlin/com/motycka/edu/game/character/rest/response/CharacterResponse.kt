package com.motycka.edu.game.character.rest.response

import com.motycka.edu.game.account.model.AccountId
import com.motycka.edu.game.character.model.CharacterId
import com.motycka.edu.game.character.model.CharacterType

data class CharacterResponse(
    val id: CharacterId,
    val name: String,
    val health: Int,
    val attackPower: Int,
    val level: Int,
    val experience: Int,
    val isOwner: Boolean,
    val characterClass: CharacterType,
    val mana: Int? = null,
    val healingPower: Int? = null,
    val stamina: Int? = null,
    val defensePower: Int? = null,
)