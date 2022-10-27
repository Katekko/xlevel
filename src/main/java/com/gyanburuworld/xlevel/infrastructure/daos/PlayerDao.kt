package com.gyanburuworld.xlevel.infrastructure.daos

import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import java.util.*

object PlayerTable : UUIDTable() {
    val nickname = varchar("name", 50)
    val level = integer("level")
    val exp = integer("experience")
}

class PlayerDao(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<PlayerDao>(PlayerTable)

    var nickname by PlayerTable.nickname
    var level by PlayerTable.level
    var exp by PlayerTable.exp
}