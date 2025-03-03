package com.motycka.edu.game.domain.entity

import com.motycka.edu.game.domain.entity.contract.Defender
import com.motycka.edu.game.domain.valueobject.CharacterType
import com.motycka.edu.game.domain.valueobject.WarriorProperties

class Warrior(
    override var id: CharacterId? = null,
    properties: WarriorProperties
): Character<WarriorProperties>(id = id, properties = properties), Defender {
    override val type: CharacterType = CharacterType.WARRIOR

    override fun attack(target: Character<*>) {
        if (isDead()) {
            return
        }

        if (properties.stamina <= 0) {
            return
        }

        target.receiveAttack(properties.attackPower)
    }

    override fun defend(attackPower: Int): Int {
        if (properties.stamina <= 0) {
            return attackPower
        }

        properties.stamina--

        if (properties.defensePower >= attackPower) {
            return 0
        }

        return attackPower - properties.defensePower
    }

    override fun receiveAttack(attackPower: Int) {
        super.receiveAttack(defend(attackPower))
    }

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
        properties.stamina = requireNotNull(stamina) { "Stamina is required for Warrior" }
        properties.defensePower = requireNotNull(defensePower) { "Defense power is required for Warrior" }
    }

    override fun beforeRounds() {
        properties.stamina++
    }

    override fun afterRound() {}
}