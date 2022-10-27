package com.gyanburuworld.xlevel.infrastructure.queries

import com.gyanburuworld.xlevel.infrastructure.daos.PlayerDao
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class PlayerQuery {
    companion object {
        fun findById(id: UUID): PlayerDao? {
            var dao: PlayerDao? = null
            transaction {
                dao = PlayerDao.findById(id)
            }
            return dao
        }

        fun hasAnyById(id: UUID): Boolean {
            return findById(id) != null
        }
    }
}