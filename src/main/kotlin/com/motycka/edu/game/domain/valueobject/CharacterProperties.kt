package com.motycka.edu.game.domain.valueobject

import com.motycka.edu.game.account.model.AccountId

sealed class CharacterProperties(
    var name: String,
    val accountId: AccountId,
    var health: Int,
    var attackPower: Int,
    var level: Int,
    var experience: Int
) {
    companion object {
        fun new(
            name: String,
            accountId: AccountId,
            health: Int,
            attackPower: Int,
            level: Int,
            experience: Int,
            mana: Int? = null,
            healingPower: Int? = null,
            stamina: Int? = null,
            defensePower: Int? = null,
            type: CharacterType
        ): CharacterProperties {
            return when (type) {
                CharacterType.WARRIOR -> WarriorProperties(
                    name = name,
                    accountId = accountId,
                    health = health,
                    attackPower = attackPower,
                    level = level,
                    experience = experience,
                    stamina = requireNotNull(stamina) { "Stamina should be defined" },
                    defensePower = requireNotNull(defensePower) { "Defense power should be defined" }
                )
                CharacterType.SORCERER -> SorcererProperties(
                    name = name,
                    accountId = accountId,
                    health = health,
                    attackPower = attackPower,
                    level = level,
                    experience = experience,
                    mana = requireNotNull(mana) { "Mana should not be null" },
                    healingPower = requireNotNull(healingPower) { "Healing power should not be null" }
                )
            }
        }
    }
}