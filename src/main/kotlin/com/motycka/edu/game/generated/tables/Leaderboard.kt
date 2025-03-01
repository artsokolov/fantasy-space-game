/*
 * This file is generated by jOOQ.
 */
package com.motycka.edu.game.generated.tables


import com.motycka.edu.game.generated.Public
import com.motycka.edu.game.generated.keys.LEADERBOARD_PKEY
import com.motycka.edu.game.generated.keys.LEADERBOARD__FK_LEADERBOARD_CHARACTER
import com.motycka.edu.game.generated.tables.GameCharacter.GameCharacterPath
import com.motycka.edu.game.generated.tables.records.LeaderboardRecord

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("warnings")
open class Leaderboard(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, LeaderboardRecord>?,
    parentPath: InverseForeignKey<out Record, LeaderboardRecord>?,
    aliased: Table<LeaderboardRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<LeaderboardRecord>(
    alias,
    Public.PUBLIC,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>public.leaderboard</code>
         */
        val LEADERBOARD: Leaderboard = Leaderboard()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<LeaderboardRecord> = LeaderboardRecord::class.java

    /**
     * The column <code>public.leaderboard.character_id</code>.
     */
    val CHARACTER_ID: TableField<LeaderboardRecord, Long?> = createField(DSL.name("character_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.leaderboard.wins</code>.
     */
    val WINS: TableField<LeaderboardRecord, Int?> = createField(DSL.name("wins"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.leaderboard.losses</code>.
     */
    val LOSSES: TableField<LeaderboardRecord, Int?> = createField(DSL.name("losses"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.leaderboard.draws</code>.
     */
    val DRAWS: TableField<LeaderboardRecord, Int?> = createField(DSL.name("draws"), SQLDataType.INTEGER.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<LeaderboardRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<LeaderboardRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<LeaderboardRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.leaderboard</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.leaderboard</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.leaderboard</code> table reference
     */
    constructor(): this(DSL.name("leaderboard"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, LeaderboardRecord>?, parentPath: InverseForeignKey<out Record, LeaderboardRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, LEADERBOARD, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class LeaderboardPath : Leaderboard, Path<LeaderboardRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, LeaderboardRecord>?, parentPath: InverseForeignKey<out Record, LeaderboardRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<LeaderboardRecord>): super(alias, aliased)
        override fun `as`(alias: String): LeaderboardPath = LeaderboardPath(DSL.name(alias), this)
        override fun `as`(alias: Name): LeaderboardPath = LeaderboardPath(alias, this)
        override fun `as`(alias: Table<*>): LeaderboardPath = LeaderboardPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getPrimaryKey(): UniqueKey<LeaderboardRecord> = LEADERBOARD_PKEY
    override fun getReferences(): List<ForeignKey<LeaderboardRecord, *>> = listOf(LEADERBOARD__FK_LEADERBOARD_CHARACTER)

    /**
     * Get the implicit join path to the <code>public.game_character</code>
     * table.
     */
    fun gameCharacter(): GameCharacterPath = gameCharacter
    val gameCharacter: GameCharacterPath by lazy { GameCharacterPath(this, LEADERBOARD__FK_LEADERBOARD_CHARACTER, null) }
    override fun `as`(alias: String): Leaderboard = Leaderboard(DSL.name(alias), this)
    override fun `as`(alias: Name): Leaderboard = Leaderboard(alias, this)
    override fun `as`(alias: Table<*>): Leaderboard = Leaderboard(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Leaderboard = Leaderboard(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Leaderboard = Leaderboard(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Leaderboard = Leaderboard(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Leaderboard = Leaderboard(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Leaderboard = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Leaderboard = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Leaderboard = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Leaderboard = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Leaderboard = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Leaderboard = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Leaderboard = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Leaderboard = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Leaderboard = where(DSL.notExists(select))
}
