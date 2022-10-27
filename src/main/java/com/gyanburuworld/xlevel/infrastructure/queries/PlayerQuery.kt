package com.gyanburuworld.xlevel.infrastructure.queries

import com.gyanburuworld.xlevel.infrastructure.daos.PlayerDao
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

object PlayerQuery {
    fun findById(id: UUID): PlayerDao? {
        var dao: PlayerDao? = null
        transaction {
            dao = PlayerDao.findById(id)
        }
        return dao
    }

    fun hasAny(player: Player): Boolean {
        return findById(player.uniqueId) != null
    }
}