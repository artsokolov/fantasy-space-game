package com.motycka.edu.game.shared

import org.jooq.Condition

interface Criteria {
    fun toCondition(): Condition?
}