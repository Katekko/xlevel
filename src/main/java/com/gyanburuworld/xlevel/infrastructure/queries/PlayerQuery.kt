package com.gyanburuworld.xlevel.infrastructure.queries

import com.gyanburuworld.xlevel.infrastructure.daos.PlayerDao
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class PlayerQuery {
    companion object {
        fun getPlayerById(id: UUID): PlayerDao? {
            var dao: PlayerDao? = null
            transaction {
                dao = PlayerDao.findById(id)
            }
            return dao
        }

        fun playerAlreadyExists(id: UUID): Boolean {
            return getPlayerById(id) != null
        }
    }
}