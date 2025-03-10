/*
 * This file is generated by jOOQ.
 */
package com.motycka.edu.game.generated.tables


import com.motycka.edu.game.generated.Public
import com.motycka.edu.game.generated.keys.GAME_CHARACTER_PKEY
import com.motycka.edu.game.generated.keys.GAME_CHARACTER__FK_CHARACTER_ACCOUNT
import com.motycka.edu.game.generated.keys.GAME_MATCH__FK_MATCH_CHALLENGER
import com.motycka.edu.game.generated.keys.GAME_MATCH__FK_MATCH_OPPONENT
import com.motycka.edu.game.generated.keys.LEADERBOARD__FK_LEADERBOARD_CHARACTER
import com.motycka.edu.game.generated.keys.ROUND__FK_ROUND_CHARACTER
import com.motycka.edu.game.generated.tables.Account.AccountPath
import com.motycka.edu.game.generated.tables.GameMatch.GameMatchPath
import com.motycka.edu.game.generated.tables.Leaderboard.LeaderboardPath
import com.motycka.edu.game.generated.tables.Round.RoundPath
import com.motycka.edu.game.generated.tables.records.GameCharacterRecord

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
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
open class GameCharacter(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, GameCharacterRecord>?,
    parentPath: InverseForeignKey<out Record, GameCharacterRecord>?,
    aliased: Table<GameCharacterRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<GameCharacterRecord>(
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
         * The reference instance of <code>public.game_character</code>
         */
        val GAME_CHARACTER: GameCharacter = GameCharacter()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<GameCharacterRecord> = GameCharacterRecord::class.java

    /**
     * The column <code>public.game_character.id</code>.
     */
    val ID: TableField<GameCharacterRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.game_character.account_id</code>.
     */
    val ACCOUNT_ID: TableField<GameCharacterRecord, Long?> = createField(DSL.name("account_id"), SQLDataType.BIGINT.nullable(false), this, "")

    /**
     * The column <code>public.game_character.name</code>.
     */
    val NAME: TableField<GameCharacterRecord, String?> = createField(DSL.name("name"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.game_character.class</code>.
     */
    val CLASS: TableField<GameCharacterRecord, String?> = createField(DSL.name("class"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.game_character.health</code>.
     */
    val HEALTH: TableField<GameCharacterRecord, Int?> = createField(DSL.name("health"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.game_character.attack</code>.
     */
    val ATTACK: TableField<GameCharacterRecord, Int?> = createField(DSL.name("attack"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.game_character.experience</code>.
     */
    val EXPERIENCE: TableField<GameCharacterRecord, Int?> = createField(DSL.name("experience"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.game_character.defense</code>.
     */
    val DEFENSE: TableField<GameCharacterRecord, Int?> = createField(DSL.name("defense"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.game_character.stamina</code>.
     */
    val STAMINA: TableField<GameCharacterRecord, Int?> = createField(DSL.name("stamina"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.game_character.healing</code>.
     */
    val HEALING: TableField<GameCharacterRecord, Int?> = createField(DSL.name("healing"), SQLDataType.INTEGER, this, "")

    /**
     * The column <code>public.game_character.mana</code>.
     */
    val MANA: TableField<GameCharacterRecord, Int?> = createField(DSL.name("mana"), SQLDataType.INTEGER, this, "")

    private constructor(alias: Name, aliased: Table<GameCharacterRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<GameCharacterRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<GameCharacterRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.game_character</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.game_character</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.game_character</code> table reference
     */
    constructor(): this(DSL.name("game_character"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, GameCharacterRecord>?, parentPath: InverseForeignKey<out Record, GameCharacterRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, GAME_CHARACTER, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class GameCharacterPath : GameCharacter, Path<GameCharacterRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, GameCharacterRecord>?, parentPath: InverseForeignKey<out Record, GameCharacterRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<GameCharacterRecord>): super(alias, aliased)
        override fun `as`(alias: String): GameCharacterPath = GameCharacterPath(DSL.name(alias), this)
        override fun `as`(alias: Name): GameCharacterPath = GameCharacterPath(alias, this)
        override fun `as`(alias: Table<*>): GameCharacterPath = GameCharacterPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<GameCharacterRecord, Long?> = super.getIdentity() as Identity<GameCharacterRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<GameCharacterRecord> = GAME_CHARACTER_PKEY
    override fun getReferences(): List<ForeignKey<GameCharacterRecord, *>> = listOf(GAME_CHARACTER__FK_CHARACTER_ACCOUNT)

    /**
     * Get the implicit join path to the <code>public.account</code> table.
     */
    fun account(): AccountPath = account
    val account: AccountPath by lazy { AccountPath(this, GAME_CHARACTER__FK_CHARACTER_ACCOUNT, null) }

    private lateinit var _leaderboard: LeaderboardPath

    /**
     * Get the implicit to-many join path to the <code>public.leaderboard</code>
     * table
     */
    fun leaderboard(): LeaderboardPath {
        if (!this::_leaderboard.isInitialized)
            _leaderboard = LeaderboardPath(this, null, LEADERBOARD__FK_LEADERBOARD_CHARACTER.inverseKey)

        return _leaderboard;
    }

    val leaderboard: LeaderboardPath
        get(): LeaderboardPath = leaderboard()

    private lateinit var _fkMatchChallenger: GameMatchPath

    /**
     * Get the implicit to-many join path to the <code>public.game_match</code>
     * table, via the <code>fk_match_challenger</code> key
     */
    fun fkMatchChallenger(): GameMatchPath {
        if (!this::_fkMatchChallenger.isInitialized)
            _fkMatchChallenger = GameMatchPath(this, null, GAME_MATCH__FK_MATCH_CHALLENGER.inverseKey)

        return _fkMatchChallenger;
    }

    val fkMatchChallenger: GameMatchPath
        get(): GameMatchPath = fkMatchChallenger()

    private lateinit var _fkMatchOpponent: GameMatchPath

    /**
     * Get the implicit to-many join path to the <code>public.game_match</code>
     * table, via the <code>fk_match_opponent</code> key
     */
    fun fkMatchOpponent(): GameMatchPath {
        if (!this::_fkMatchOpponent.isInitialized)
            _fkMatchOpponent = GameMatchPath(this, null, GAME_MATCH__FK_MATCH_OPPONENT.inverseKey)

        return _fkMatchOpponent;
    }

    val fkMatchOpponent: GameMatchPath
        get(): GameMatchPath = fkMatchOpponent()

    private lateinit var _round: RoundPath

    /**
     * Get the implicit to-many join path to the <code>public.round</code> table
     */
    fun round(): RoundPath {
        if (!this::_round.isInitialized)
            _round = RoundPath(this, null, ROUND__FK_ROUND_CHARACTER.inverseKey)

        return _round;
    }

    val round: RoundPath
        get(): RoundPath = round()
    override fun `as`(alias: String): GameCharacter = GameCharacter(DSL.name(alias), this)
    override fun `as`(alias: Name): GameCharacter = GameCharacter(alias, this)
    override fun `as`(alias: Table<*>): GameCharacter = GameCharacter(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): GameCharacter = GameCharacter(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): GameCharacter = GameCharacter(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): GameCharacter = GameCharacter(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): GameCharacter = GameCharacter(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): GameCharacter = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): GameCharacter = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): GameCharacter = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): GameCharacter = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): GameCharacter = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): GameCharacter = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): GameCharacter = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): GameCharacter = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): GameCharacter = where(DSL.notExists(select))
}
