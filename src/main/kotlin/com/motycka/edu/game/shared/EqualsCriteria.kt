package com.motycka.edu.game.shared

import org.jooq.Condition
import org.jooq.TableField

class EqualsCriteria<T>(
    private val field: TableField<*, T?>,
    private val value: T?
): Criteria {
    override fun toCondition(): Condition? {
        return value?.let { field.eq(it) }
    }
}