package com.gyanburu.events

import com.gyanburu.Xlevel
import com.gyanburu.inventory.InventoryMenuController
import com.gyanburu.sql.PlayerDao
import com.gyanburu.sql.PlayerTable
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class PlayerEvent : Listener {
    private fun addMenuItemToPlayer(player: Player) {
        val menuItem = InventoryMenuController.getMenuItemStack()
        player.inventory.setItem(8, menuItem)
    }

    private fun removeMenuItemFromPlayer(player: Player) {
        val menuItem = InventoryMenuController.getMenuItemStack()
        player.inventory.remove(menuItem)
    }

    private fun removeMenuItemFromPlayerDrop(event: PlayerDeathEvent) {
        event.drops.remove(InventoryMenuController.getMenuItemStack())
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val p = event.player
        transaction {
            val playerExist = PlayerDao.findById(p.uniqueId)
            if (playerExist == null) {
                PlayerTable.insert {
                    it[id] = EntityID(p.uniqueId, PlayerTable)
                    it[nickname] = p.name
                    it[level] = 0
                    it[exp] = 0
                }
            }
        }
        addMenuItemToPlayer(player = event.player)
    }

    @EventHandler
    fun onPlayerDropItem(event: PlayerDropItemEvent) {
        if (InventoryMenuController.isMenuItem(item = event.itemDrop.itemStack)) {
            removeMenuItemFromPlayer(player = event.player)
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action === Action.RIGHT_CLICK_AIR) {
            if (InventoryMenuController.isMenuItem(item = event.item)) {
                event.isCancelled = true
                InventoryMenuController.openInventory(event.player)
            }
        }
    }

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        removeMenuItemFromPlayerDrop(event)
    }

    @EventHandler
    fun onPlayerRespawn(event: PlayerRespawnEvent) {
        addMenuItemToPlayer(player = event.player)
    }
}
