package com.motycka.edu.game.domain.entity

import com.motycka.edu.game.domain.entity.contract.Healer
import com.motycka.edu.game.domain.valueobject.CharacterProperties
import com.motycka.edu.game.domain.valueobject.CharacterType
import com.motycka.edu.game.domain.valueobject.SorcererProperties

class Sorcerer(
    override var id: CharacterId? = null,
    properties: SorcererProperties
): Character<SorcererProperties>(id = id, properties = properties), Healer {
    override val type: CharacterType = CharacterType.SORCERER

    override fun levelUp(
        name: String,
        health: Int,
        attackPower: Int,
        stamina: Int?,
        defensePower: Int?,
        mana: Int?,
        healingPower: Int?
    ) {
        properties.name = name
        properties.health = health
        properties.attackPower = attackPower
        properties.mana = requireNotNull(mana) { "Mana is required for Sorcerer" }
        properties.healingPower = requireNotNull(healingPower) { "Healing power is required for Sorcerer" }
    }

    override fun attack(target: Character<*>) {
        if (isDead()) {
            return
        }

        if (properties.mana <= 0) {
            return
        }

        heal()

        properties.mana--
        target.receiveAttack(properties.attackPower)
    }

    override fun heal() {
        if (properties.mana <= 0) {
            return
        }

        properties.mana--
        properties.health += properties.healingPower
    }

    override fun beforeRounds() {
        properties.mana++
    }

    override fun afterRound() {}
}