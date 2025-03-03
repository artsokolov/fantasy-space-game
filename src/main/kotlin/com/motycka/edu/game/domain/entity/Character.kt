package com.motycka.edu.game.domain.entity

import com.motycka.edu.game.domain.entity.contract.Recoverable
import com.motycka.edu.game.domain.valueobject.CharacterProperties
import com.motycka.edu.game.domain.valueobject.CharacterType

sealed class Character<T : CharacterProperties>(
    open var id: CharacterId?,
    val properties: T
): Recoverable {
    abstract val type: CharacterType

    protected fun isDead(): Boolean = properties.health <= 0

    open fun receiveAttack(attackPower: Int) {
        properties.health -= attackPower

        if (properties.health <= 0) {
            return
        }
    }

    abstract fun levelUp(
        name: String,
        health: Int,
        attackPower: Int,
        stamina: Int?,
        defensePower: Int?,
        mana: Int?,
        healingPower: Int?,
    )

    abstract fun attack(target: Character<*>)
}