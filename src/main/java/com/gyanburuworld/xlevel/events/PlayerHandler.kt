package com.gyanburuworld.xlevel.events

import com.gyanburuworld.xlevel.domain.inventory.MainInventory
import com.gyanburuworld.xlevel.domain.items.MenuItem
import com.gyanburuworld.xlevel.domain.utils.ItemUtils
import com.gyanburuworld.xlevel.infrastructure.queries.PlayerQuery
import com.gyanburuworld.xlevel.infrastructure.transactions.PlayerTransaction
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent

class PlayerHandler : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        if (!PlayerQuery.hasAny(player)) {
            PlayerTransaction.createPlayer(player)
        }

        player.inventory.setItem(8, MenuItem.item)
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action === Action.RIGHT_CLICK_AIR) {
            if (MenuItem.isEqual(ItemUtils.getDisplayNameFromComponent(event.item))) {
                event.isCancelled = true
                MainInventory.openInventory(event.player)
            }
        }
    }

    @EventHandler
    fun onPlayerDropItem(event: PlayerDropItemEvent) {
        if (MenuItem.isEqual(ItemUtils.getDisplayNameFromComponent(event.itemDrop.itemStack))) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val menuDrops = event.drops.filter { it.itemMeta == MenuItem.item.itemMeta }
        for (drop in menuDrops) {
            event.drops.remove(drop)
        }
    }

    @EventHandler
    fun onPlayerRespawn(event: PlayerRespawnEvent) {
        addMenuToPlayer(event.player)
    }

    private fun removeMenuFromPlayer(player: Player) {
        player.inventory.remove(MenuItem.item)
    }

    private fun addMenuToPlayer(player: Player) {
        player.inventory.setItem(8, MenuItem.item)
    }
}