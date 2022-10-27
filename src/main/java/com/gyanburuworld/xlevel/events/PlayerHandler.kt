package com.gyanburuworld.xlevel.events

import com.gyanburuworld.xlevel.infrastructure.queries.PlayerQuery
import com.gyanburuworld.xlevel.infrastructure.transactions.PlayerTransaction
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerHandler : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        if (!PlayerQuery.playerAlreadyExists(player.uniqueId)) {
            PlayerTransaction.createPlayer(player)
        }
    }
}