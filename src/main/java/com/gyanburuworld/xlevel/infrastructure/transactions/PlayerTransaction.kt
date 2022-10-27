package com.gyanburuworld.xlevel.infrastructure.transactions

import com.gyanburuworld.xlevel.infrastructure.daos.PlayerDao
import com.gyanburuworld.xlevel.infrastructure.daos.PlayerTable
import com.gyanburuworld.xlevel.infrastructure.queries.PlayerQuery
import org.bukkit.entity.Player
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class PlayerTransaction {
    companion object{
        fun createPlayer(player : Player){
            transaction {
                PlayerTable.insert {
                    it[id] = EntityID(player.uniqueId, PlayerTable)
                    it[nickname] = player.name
                    it[level] = 0
                    it[exp] = 0
                }
            }
        }
    }
}