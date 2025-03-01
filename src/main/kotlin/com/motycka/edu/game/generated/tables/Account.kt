/*
 * This file is generated by jOOQ.
 */
package com.motycka.edu.game.generated.tables


import com.motycka.edu.game.generated.Public
import com.motycka.edu.game.generated.keys.ACCOUNT_PKEY
import com.motycka.edu.game.generated.keys.ACCOUNT_USERNAME_KEY
import com.motycka.edu.game.generated.keys.GAME_CHARACTER__FK_CHARACTER_ACCOUNT
import com.motycka.edu.game.generated.tables.GameCharacter.GameCharacterPath
import com.motycka.edu.game.generated.tables.records.AccountRecord

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
open class Account(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, AccountRecord>?,
    parentPath: InverseForeignKey<out Record, AccountRecord>?,
    aliased: Table<AccountRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<AccountRecord>(
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
         * The reference instance of <code>public.account</code>
         */
        val ACCOUNT: Account = Account()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<AccountRecord> = AccountRecord::class.java

    /**
     * The column <code>public.account.id</code>.
     */
    val ID: TableField<AccountRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.account.name</code>.
     */
    val NAME: TableField<AccountRecord, String?> = createField(DSL.name("name"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.account.username</code>.
     */
    val USERNAME: TableField<AccountRecord, String?> = createField(DSL.name("username"), SQLDataType.CLOB.nullable(false), this, "")

    /**
     * The column <code>public.account.password</code>.
     */
    val PASSWORD: TableField<AccountRecord, String?> = createField(DSL.name("password"), SQLDataType.CLOB.nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<AccountRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<AccountRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<AccountRecord>?, where: Condition?): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.account</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.account</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.account</code> table reference
     */
    constructor(): this(DSL.name("account"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, AccountRecord>?, parentPath: InverseForeignKey<out Record, AccountRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, ACCOUNT, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class AccountPath : Account, Path<AccountRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, AccountRecord>?, parentPath: InverseForeignKey<out Record, AccountRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<AccountRecord>): super(alias, aliased)
        override fun `as`(alias: String): AccountPath = AccountPath(DSL.name(alias), this)
        override fun `as`(alias: Name): AccountPath = AccountPath(alias, this)
        override fun `as`(alias: Table<*>): AccountPath = AccountPath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<AccountRecord, Long?> = super.getIdentity() as Identity<AccountRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<AccountRecord> = ACCOUNT_PKEY
    override fun getUniqueKeys(): List<UniqueKey<AccountRecord>> = listOf(ACCOUNT_USERNAME_KEY)

    private lateinit var _gameCharacter: GameCharacterPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.game_character</code> table
     */
    fun gameCharacter(): GameCharacterPath {
        if (!this::_gameCharacter.isInitialized)
            _gameCharacter = GameCharacterPath(this, null, GAME_CHARACTER__FK_CHARACTER_ACCOUNT.inverseKey)

        return _gameCharacter;
    }

    val gameCharacter: GameCharacterPath
        get(): GameCharacterPath = gameCharacter()
    override fun `as`(alias: String): Account = Account(DSL.name(alias), this)
    override fun `as`(alias: Name): Account = Account(alias, this)
    override fun `as`(alias: Table<*>): Account = Account(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Account = Account(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Account = Account(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Account = Account(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition?): Account = Account(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): Account = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition?): Account = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>?): Account = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): Account = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): Account = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): Account = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): Account = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): Account = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): Account = where(DSL.notExists(select))
}
