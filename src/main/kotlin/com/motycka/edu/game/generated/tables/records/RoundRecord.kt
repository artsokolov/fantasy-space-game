/*
 * This file is generated by jOOQ.
 */
package com.motycka.edu.game.generated.tables.records


import com.motycka.edu.game.generated.tables.Round

import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("warnings")
open class RoundRecord() : UpdatableRecordImpl<RoundRecord>(Round.ROUND) {

    open var id: Long?
        set(value): Unit = set(0, value)
        get(): Long? = get(0) as Long?

    open var matchId: Long?
        set(value): Unit = set(1, value)
        get(): Long? = get(1) as Long?

    open var roundNumber: Int?
        set(value): Unit = set(2, value)
        get(): Int? = get(2) as Int?

    open var characterId: Long?
        set(value): Unit = set(3, value)
        get(): Long? = get(3) as Long?

    open var healthDelta: Int?
        set(value): Unit = set(4, value)
        get(): Int? = get(4) as Int?

    open var staminaDelta: Int?
        set(value): Unit = set(5, value)
        get(): Int? = get(5) as Int?

    open var manaDelta: Int?
        set(value): Unit = set(6, value)
        get(): Int? = get(6) as Int?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    /**
     * Create a detached, initialised RoundRecord
     */
    constructor(id: Long? = null, matchId: Long? = null, roundNumber: Int? = null, characterId: Long? = null, healthDelta: Int? = null, staminaDelta: Int? = null, manaDelta: Int? = null): this() {
        this.id = id
        this.matchId = matchId
        this.roundNumber = roundNumber
        this.characterId = characterId
        this.healthDelta = healthDelta
        this.staminaDelta = staminaDelta
        this.manaDelta = manaDelta
        resetTouchedOnNotNull()
    }
}
